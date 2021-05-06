package org.czh.interview.design_mode_interview.builder_pattern;

import java.util.ArrayList;
import java.util.List;

// 食物条目 接口
interface IItem {

    // 食物条目 名称
    String name();

    // 食物条目 包装
    Packing packing();

    // 食物条目 价格
    float price();

    // 抽象的 食物条目，汉堡包
    abstract class AbstractBurgerItem implements IItem {
        @Override
        public Packing packing() {
            return new Packing.Wrapper();
        }
    }

    // 蔬菜汉堡包，具体的食物条目，汉堡包
    class VegBurgerItem extends AbstractBurgerItem {

        @Override
        public String name() {
            return "Veg Burger";
        }

        @Override
        public float price() {
            return 25.0f;
        }
    }

    // 鸡肉汉堡包，具体的食物条目，汉堡包
    class ChickenBurgerItem extends AbstractBurgerItem {
        @Override
        public String name() {
            return "Chicken Burger";
        }

        @Override
        public float price() {
            return 50.5f;
        }
    }

    // 抽象的 食物条目，冷饮
    abstract class AbstractColdDrinkItem implements IItem {
        @Override
        public Packing packing() {
            return new Packing.Bottle();
        }
    }

    // 可口可乐，具体的食物条目，冷饮
    class CokeColdDrinkItem extends AbstractColdDrinkItem {

        @Override
        public String name() {
            return "Coke";
        }

        @Override
        public float price() {
            return 30.0f;
        }
    }

    // 百事可乐，具体的食物条目，冷饮
    class PepsiColdDrinkItem extends AbstractColdDrinkItem {
        @Override
        public String name() {
            return "Pepsi";
        }

        @Override
        public float price() {
            return 35.0f;
        }
    }
}

// 食物包装 接口
interface Packing {
    String pack();

    // 包装纸，具体的食物包装
    class Wrapper implements Packing {

        @Override
        public String pack() {
            return "Wrapper";
        }
    }

    // 瓶子，具体的食物包装
    class Bottle implements Packing {

        @Override
        public String pack() {
            return "Bottle";
        }
    }
}

/**
 * @author : czh
 * description :
 * date : 2021-05-05
 * email 916419307@qq.com
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        vegMeal.showItems();

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        nonVegMeal.showItems();
    }
}

// 套餐类，存放 食物条目 的集合
class Meal {
    private String mealName;
    private List<IItem> items = new ArrayList<>();

    public Meal(String mealName) {
        this.mealName = mealName;
    }

    public void addItem(IItem item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (IItem item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        System.out.println(this.mealName);
        for (IItem item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
        System.out.println("Total Cost: " + getCost());
        System.out.println();
    }
}

class MealBuilder {
    // 准备 蔬菜汉堡 套餐
    public Meal prepareVegMeal() {
        Meal meal = new Meal("Veg Meal");
        meal.addItem(new IItem.VegBurgerItem());
        meal.addItem(new IItem.CokeColdDrinkItem());
        return meal;
    }

    // 准备 鸡肉汉堡 套餐
    public Meal prepareNonVegMeal() {
        Meal meal = new Meal("Non-Veg Meal");
        meal.addItem(new IItem.ChickenBurgerItem());
        meal.addItem(new IItem.PepsiColdDrinkItem());
        return meal;
    }
}


