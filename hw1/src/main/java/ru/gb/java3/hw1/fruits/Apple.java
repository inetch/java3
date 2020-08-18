package ru.gb.java3.hw1.fruits;

//a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
public class Apple extends Fruit {
    //(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
    private static final float standardWeight = 1.5f;
    private static final String name = "Apple";

    public Apple(){
        super(name, standardWeight);
    }
}
