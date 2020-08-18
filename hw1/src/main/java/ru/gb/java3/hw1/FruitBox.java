package ru.gb.java3.hw1;

import ru.gb.java3.hw1.fruits.Fruit;

import java.util.ArrayList;

//b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
public class FruitBox<T extends Fruit> {

    //c. Для хранения фруктов внутри коробки можете использовать ArrayList;
    private ArrayList<T> fruits;

    private float fruitWeight;
    private String fruitName;

    public FruitBox(){
        fruits = new ArrayList<T>();
    }

    //g. Не забываем про метод добавления фрукта в коробку.
    public void add(T fruit){
        fruits.add(fruit);
        fruitWeight = fruit.getWeight();
        fruitName = fruit.getName();
    }

    //f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
    public void moveTo(FruitBox<? super T> box){
        for(T fruit : fruits){
            box.add(fruit);
        }
        fruits.clear();
    }

    /*
     d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
        (вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
     */
    public float getWeight(){
        return fruitWeight * fruits.size();
    }

    /*
     e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра,
        true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
     */
    public boolean compare(FruitBox box){
        return Math.abs(getWeight() - box.getWeight()) < 0.001;
    }

    @Override
    public String toString(){
        return String.format("%s-box, weight: %.2f", fruitName, getWeight());
    }
}
