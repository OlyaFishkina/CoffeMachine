package com.company;

public class Component {
    String name;
    double coast;
    double amount;

    public Component(String name, double coast, double amount) {
        this.name = name;
        this.coast = coast;
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Component{" +
                "name='" + name + '\'' +
                ", coast=" + coast +
                ", amount=" + String.format("%.2f", amount) +
                '}';
    }
}
