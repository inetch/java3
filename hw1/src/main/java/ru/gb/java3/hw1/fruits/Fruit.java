package ru.gb.java3.hw1.fruits;

//a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
public abstract class Fruit {
    private final float weight;
    private final String name;

    protected Fruit(String name, float weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

}
