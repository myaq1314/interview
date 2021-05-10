package org.czh.interview.design_mode_interview.j2ee_patterns.sevices_locator_pattern;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class ServicesLocatorPatternDemo {

    public static void main(String[] args) {
        IService service = ServiceLocator.getService("Service1");
        service.execute();
        System.out.println();

        service = ServiceLocator.getService("Service2");
        service.execute();
        System.out.println();

        service = ServiceLocator.getService("Service1");
        service.execute();
        System.out.println();

        service = ServiceLocator.getService("Service2");
        service.execute();
        System.out.println();
    }

    // 抽象服务或者服务接口
    public interface IService {

        String getName();

        void execute();

        // 具体服务1，有唯一服务标识 name
        class ConcreteService1 implements IService {
            public void execute() {
                System.out.println("Executing Service1");
            }

            @Override
            public String getName() {
                return "Service1";
            }
        }

        // 具体服务2，有唯一服务标识 name
        class ConcreteService2 implements IService {
            public void execute() {
                System.out.println("Executing Service2");
            }

            @Override
            public String getName() {
                return "Service2";
            }
        }
    }

    // 上下文，可以查找服务，生成服务对象
    public static class InitialContext {
        public static IService lookup(String jndiName) {
            if (jndiName.equalsIgnoreCase("SERVICE1")) {
                System.out.println("Looking up and creating a new Service1 object");
                return new IService.ConcreteService1();
            } else if (jndiName.equalsIgnoreCase("SERVICE2")) {
                System.out.println("Looking up and creating a new Service2 object");
                return new IService.ConcreteService2();
            }
            throw new RuntimeException("找不到指定的服务");
        }
    }

    // 缓存，记录服务，复用
    @NoArgsConstructor
    public static class Cache {

        private final List<IService> services = new ArrayList<>();

        public IService getService(String serviceName) {
            for (IService service : services) {
                if (service.getName().equalsIgnoreCase(serviceName)) {
                    System.out.println("Returning cached  " + serviceName + " object");
                    return service;
                }
            }
            return null;
        }

        public void addService(IService newService) {
            for (IService service : services) {
                if (service.getName().equalsIgnoreCase(newService.getName())) {
                    return;
                }
            }
            services.add(newService);
        }
    }

    // 定位器，从缓存中，或者是上下文中，获取服务
    public static class ServiceLocator {

        private static final Cache cache = new Cache();

        public static IService getService(String jndiName) {
            IService service = cache.getService(jndiName);
            if (service == null) {
                service = InitialContext.lookup(jndiName);
                cache.addService(service);
            }
            return service;
        }
    }
}
