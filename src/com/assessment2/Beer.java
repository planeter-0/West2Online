package com.assessment2;

import java.time.LocalDate;

public class Beer extends Drinks {
    float alcoholDegree;

    public Beer(String name, double cost, LocalDate productionDate, float alcoholDegree) {
        super(name, cost, productionDate, 30);
        this.alcoholDegree = alcoholDegree;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", productionDate=" + productionDate +
                ", shelfLife=" + shelfLife +
                ",alcoholDegree=" + alcoholDegree +
                '}';
    }
}
