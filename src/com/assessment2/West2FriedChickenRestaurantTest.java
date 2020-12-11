package com.assessment2;

import java.time.LocalDate;
import java.util.LinkedList;

public class West2FriedChickenRestaurantTest {
    public static void main(String[] args) {
        // 初始化列表: 10瓶青岛，10瓶雪花，10瓶橙汁，10瓶苹果汁
        LinkedList<Beer> beers = new LinkedList<>();
        LinkedList<Juice> juices = new LinkedList<>();
        for(int i = 1; i <= 10; i++){
            beers.add(new Beer("QingDao",15, LocalDate.of(2020, 11,i),10));
            beers.add(new Beer("XueHua",15, LocalDate.of(2020, 11,i),10));
            juices.add(new Juice("Orange",10, LocalDate.of(2020, 11,i)));
            juices.add(new Juice("Apple",10, LocalDate.of(2020, 11,i)));
        }

        // 构造一个炸鸡店对象
        West2FriedChickenRestaurant west2 = new West2FriedChickenRestaurant(2000,beers,juices);

        //// 售卖套餐
        // test 1
        System.out.println("Origin: "+west2.balance);
        west2.sellSetMeal(West2FriedChickenRestaurant.SET_MEALS.get(0));// OK，beer was removed,balance increase 20
        System.out.println("After: "+west2.balance);
        // test 2
        west2.sellSetMeal(West2FriedChickenRestaurant.SET_MEALS.get(1));// IngredientSortOutException

        //// 批量进货
        // test 1
        System.out.println("Origin: "+west2.balance);
        Beer QingDao = new Beer("QingDao", 8, LocalDate.of(2020, 11, 1), 8);
        west2.bulkPurchase(QingDao, 10);
        System.out.println("After: "+west2.balance); // OK, balance -80
        // test 2
        west2.bulkPurchase(QingDao, 1000); // OverdraftBalanceException
    }
}
