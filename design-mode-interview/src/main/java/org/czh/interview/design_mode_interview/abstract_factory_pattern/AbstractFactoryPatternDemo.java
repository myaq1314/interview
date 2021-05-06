package org.czh.interview.design_mode_interview.abstract_factory_pattern;

import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.validate.EmptyAssert;

// 汽车 接口
interface ICar {
    void travel(); // 旅游

    void transport(); // 运输
}

// 食物 接口
interface IFood {
    void shape(); // 外形

    void taste(); // 口味
}

/**
 * @author : czh
 * description :
 * date : 2021-05-04
 * email 916419307@qq.com
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        // 获取 汽车 工厂
        AbstractFactory carFactory = FactoryProducer.makeFactory("Car");

        // 生产 奥迪 汽车
        ICar aoDiCar = carFactory.makeCar("AoDi");
        // 开车旅游
        aoDiCar.travel();

        // 生产 时风四轮拉货 汽车
        ICar shiFengCar = carFactory.makeCar("ShiFeng");
        // 开车运输
        shiFengCar.transport();

        // 获取 食物 工厂
        AbstractFactory foodFactory = FactoryProducer.makeFactory("Food");

        // 生产 干吃面 食物
        IFood ganChiMianFood = foodFactory.makeFood("GanChiMian");
        // 外形、口味
        ganChiMianFood.shape();
        ganChiMianFood.taste();

        // 生产 巧克力派 食物
        IFood qiaoKeLiPaiFood = foodFactory.makeFood("QiaoKeLiPai");
        // 外形、口味
        qiaoKeLiPaiFood.shape();
        qiaoKeLiPaiFood.taste();

    }
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

// 干吃面 食物
class GanChiMianFood implements IFood {

    @Override
    public void shape() { // 外形
        System.out.println("干吃面的外形，方方正正");
    }

    @Override
    public void taste() { // 口味
        System.out.println("干吃面，吃起来，脆脆的，棒棒的");
    }
}

// 巧克力派 食物
class QiaoKeLiPaiFood implements IFood {
    @Override
    public void shape() { // 外形
        System.out.println("巧克力派的外形，细长条");
    }

    @Override
    public void taste() { // 口味
        System.out.println("巧克力派，吃起来，甜甜的，好好吃");
    }
}

// 抽象工厂
abstract class AbstractFactory {
    public IFood makeFood(String name) {
        return null;
    }

    public ICar makeCar(String name) {
        return null;
    }
}

class CarFactory extends AbstractFactory {

    public ICar makeCar(String name) {
        EmptyAssert.isNotBlank(name, "请说出要生产的汽车名称");

        if ("AoDi".equals(name)) {
            return new AoDiCar();
        } else if ("ShiFeng".equals(name)) {
            return new ShiFengCar();
        }

        throw new CommonException("还没有配置生产" + name + "这种汽车的生产线");
    }
}

class FoodFactory extends AbstractFactory {

    public IFood makeFood(String name) {
        EmptyAssert.isNotBlank(name, "请说出要生产的汽车名称");

        if ("GanChiMian".equals(name)) {
            return new GanChiMianFood();
        } else if ("QiaoKeLiPai".equals(name)) {
            return new QiaoKeLiPaiFood();
        }

        throw new CommonException("还没有配置生产" + name + "这种食物的生产线");
    }
}

class FactoryProducer {
    public static AbstractFactory makeFactory(String type) {
        EmptyAssert.isNotBlank(type, "请说出要生成的工厂名称");

        if (type.equals("Car")) {
            return new CarFactory();
        } else if (type.equals("Food")) {
            return new FoodFactory();
        }

        throw new CommonException("还没有配置生成" + type + "这种工厂的生产线");
    }
}