package com.assessment2;

import java.time.LocalDate;

public class Juice extends Drinks {

    public Juice(String name, double cost, LocalDate productionDate) {
        super(name, cost, productionDate, 2);
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", productionDate=" + productionDate +
                ", shelfLife=" + shelfLife +
                '}';
    }
}
