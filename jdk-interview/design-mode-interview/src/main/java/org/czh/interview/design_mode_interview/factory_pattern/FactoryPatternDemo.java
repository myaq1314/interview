package org.czh.interview.design_mode_interview.factory_pattern;

import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.validate.EmptyAssert;

/**
 * @author : czh
 * description :
 * date : 2021-05-04
 * email 916419307@qq.com
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        // 获取工厂
        CarFactory carFactory = new CarFactory();

        // 生产 奥迪 汽车
        ICar aoDiCar = carFactory.make("AoDi");

        // 开车旅游
        aoDiCar.travel();

        // 生产 时风四轮拉货 汽车
        ICar shiFengCar = carFactory.make("ShiFeng");

        // 开车运输
        shiFengCar.transport();
    }
}

// 汽车 接口
interface ICar {
    void travel(); // 旅游

    void transport(); // 运输
}

// 奥迪 汽车
class AoDiCar implements ICar {
    @Override
    public void travel() { // 旅游
        System.out.println("开奥迪车去旅游，安全又快");
    }

    @Override
    public void transport() {  // 运输
        System.out.println("开奥迪车搞运输，赚不够汽油钱");
    }
}

// 时风四轮拉货 汽车
class ShiFengCar implements ICar {
    @Override
    public void travel() { // 旅游
        System.out.println("开时风四轮拉货车去旅游，风吹日晒");
    }

    @Override
    public void transport() {  // 运输
        System.out.println("开时风四轮拉货车搞运输，赚钱满满");
    }
}

class CarFactory {
    public ICar make(String name) {
        EmptyAssert.isNotBlank(name, "请说出要生产的汽车名称");

        if ("AoDi".equals(name)) {
            return new AoDiCar();
        } else if ("ShiFeng".equals(name)) {
            return new ShiFengCar();
        }

        throw new CommonException("还没有配置生产" + name + "这种汽车的生产线");
    }
}