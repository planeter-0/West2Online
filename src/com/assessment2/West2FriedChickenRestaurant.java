package com.assessment2;

import java.time.LocalDate;
import java.util.LinkedList;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
    /* 为什么你选择这个List保存啤酒和果汁?
       答: 饮料列表需要频繁插入和删除，链表有优势。
           查找时不是随机访问，数组无优势。*/
    protected double balance;
    protected LinkedList<Beer> beerLinkedList;
    protected LinkedList<Juice> juiceLinkedList;
    protected static final LinkedList<SetMeal> setMealLinkedList = new LinkedList<>();

    static {
        //2种啤酒: 青岛，雪花
        Beer QingDao = new Beer("QingDao", 8, LocalDate.of(2020, 11, 1), 8);
        Beer XueHua = new Beer("XueHua", 8, LocalDate.of(2020, 11, 1), 9);
        //2种果汁：橙汁，苹果汁
        Juice Orange = new Juice("Orange", 10, LocalDate.of(2020, 11, 1));
        Juice Apple = new Juice("Apple", 10, LocalDate.of(2020, 11, 1));
        //4种套餐: 套餐1(鸡翅+青岛啤酒)，套餐2(鸡翅+橙汁)，套餐3(鸡排+雪花啤酒)，套餐4(鸡排+苹果汁)
        setMealLinkedList.add(new SetMeal("SetMeal_1", 20, "Wings", QingDao));
        setMealLinkedList.add(new SetMeal("SetMeal_2", 22, "Wings", Orange));
        setMealLinkedList.add(new SetMeal("SetMeal_3", 24, "Chop", XueHua));
        setMealLinkedList.add(new SetMeal("SetMeal_4", 26, "Chop", Apple));
    }

    public West2FriedChickenRestaurant(double balance, LinkedList<Beer> beerLinkedList, LinkedList<Juice> juiceLinkedList) {
        this.balance = balance;
        this.beerLinkedList = beerLinkedList;
        this.juiceLinkedList = juiceLinkedList;
    }

    // 方法removeExpiredDrinks: 移除过期饮料
    private void removeExpiredDrinks() {
        beerLinkedList.removeIf(Drinks::isExpired);
        juiceLinkedList.removeIf(Drinks::isExpired);
    }

    // 方法use: 随套餐售卖从饮料列表中移除饮料
    private boolean use(Beer beer) throws IngredientSortOutException {
        this.removeExpiredDrinks();
        try {
            for (Beer b : beerLinkedList) {
                if (b.name.equals(beer.name)) {
                    beerLinkedList.remove(b);
                    return true; //避开ConcurrentModificationException和throw语句, 直接退出方法
                }
            }
            throw new IngredientSortOutException("Sorry, " + beer.name + " is sold out."); //遍历完列表也无，抛出异常
        } catch (IngredientSortOutException e) { //捕获异常
            System.out.println(e.getMessage()); //打印信息给顾客
            return false;
        }
    }

    private boolean use(Juice juice) throws IngredientSortOutException {
        this.removeExpiredDrinks();
        try {
            for (Juice j : juiceLinkedList) {
                if (j.name.equals(juice.name)) {
                    juiceLinkedList.remove(j);
                    return true;
                }
            }
            throw new IngredientSortOutException("Sorry, " + juice.name + " is sold out.");
        } catch (IngredientSortOutException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // 方法sellSetMeal: 售出套餐，balance增加
    public void sellSetMeal(SetMeal set) {
        if (set.drink instanceof Beer) {
            Beer beer = (Beer) set.drink;
            boolean isHave = this.use(beer);
            if (isHave) balance += set.price;
        } else {
            Juice juice = (Juice) set.drink;
            boolean isHave = this.use(juice);
            if (isHave) balance += set.price;
        }
    }

    //方法: bulkPurchase批量进货
    public void bulkPurchase(Drinks drink, int num) throws OverdraftBalanceException {
        double cost = num * drink.cost;
        try {
            if (cost > balance)
                throw new OverdraftBalanceException("OVERDRAFT BALANCE!\n" +
                        "Balance: " + balance + '\n' + "Cost: " + cost + '\n' + "Difference:" + (balance - cost));
        } catch (OverdraftBalanceException e) {
            System.out.println(e.getMessage());
        }
        //balance减去cost
        balance -= cost;
        // 向列表中添加所进货物
        for (int i = 0; i < num; i++) {
            if (drink instanceof Beer) {
                Beer beer = (Beer) drink;
                Beer new_beer = new Beer(beer.name, beer.cost, LocalDate.now(), beer.alcoholDegree);
                this.beerLinkedList.addLast(new_beer);
            } else {
                Juice juice = (Juice) drink;
                Juice new_juice = new Juice(juice.name, juice.cost, LocalDate.now());
                this.juiceLinkedList.addLast(new_juice);
            }
        }
    }
}
