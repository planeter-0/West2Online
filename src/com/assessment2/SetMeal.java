package com.assessment2;

public class SetMeal {
    String name;
    double price;
    String friedChickenName;
    Drinks drink;

    public SetMeal(String name, double price, String friedChickenName, Drinks drink) {
        this.name = name;
        this.price = price;
        this.friedChickenName = friedChickenName;
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "SetMeal{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", friedChickenName='" + friedChickenName + '\'' +
                ", drink=" + drink +
                '}';
    }
}
