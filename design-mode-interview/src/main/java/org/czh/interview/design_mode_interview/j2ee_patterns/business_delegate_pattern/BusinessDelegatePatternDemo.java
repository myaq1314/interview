package org.czh.interview.design_mode_interview.j2ee_patterns.business_delegate_pattern;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class BusinessDelegatePatternDemo {

    public static void main(String[] args) {
        // 业务代表
        BusinessDelegate businessDelegate = new BusinessDelegate();
        // 业务代表 首次 设置 业务服务类型
        businessDelegate.setServiceType("EJB");

        // 客户端
        Client client = new Client(businessDelegate);
        client.doTask();

        // 业务代表，切换 业务服务类型
        businessDelegate.setServiceType("JMS");
        client.doTask();
    }

    // 业务服务
    public interface BusinessService {
        // 核心处理方法
        void doProcessing();

        class EJBService implements BusinessService {

            @Override
            public void doProcessing() {
                System.out.println("Processing task by invoking EJB Service");
            }
        }

        class JMSService implements BusinessService {

            @Override
            public void doProcessing() {
                System.out.println("Processing task by invoking JMS Service");
            }
        }
    }

    // 查询服务
    public static class BusinessLookUp {
        public BusinessService getBusinessService(String serviceType) {
            if (serviceType.equalsIgnoreCase("EJB")) {
                return new BusinessService.EJBService();
            } else if (serviceType.equalsIgnoreCase("JMS")) {
                return new BusinessService.JMSService();
            }
            throw new RuntimeException("未知的业务服务");
        }
    }

    // 业务代表
    public static class BusinessDelegate {

        private final BusinessLookUp lookupService = new BusinessLookUp();
        @Setter
        private String serviceType;

        public void doTask() {
            BusinessService businessService = lookupService.getBusinessService(serviceType);
            businessService.doProcessing();
        }
    }

    // 客户端
    @AllArgsConstructor
    public static class Client {

        BusinessDelegate businessService;

        public void doTask() {
            businessService.doTask();
        }
    }
}
