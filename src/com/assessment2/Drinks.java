package com.assessment2;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public abstract class Drinks {
    protected String name;
    protected double cost;
    protected LocalDate productionDate;
    protected int shelfLife;

    public Drinks(String name, double cost, LocalDate productionDate, int shelfLife) {
        this.name = name;
        this.cost = cost;
        this.productionDate = productionDate;
        this.shelfLife = shelfLife;
    }

    public boolean isExpired() {
        return productionDate.until(LocalDate.now(), DAYS) >= shelfLife;
    }

    @Override
    public abstract String toString();
}
