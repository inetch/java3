package ru.gb.java3.hw1;

import ru.gb.java3.hw1.fruits.Apple;
import ru.gb.java3.hw1.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        Integer[] testArr = new Integer[10];
        fillArray(testArr);

        System.out.println(Arrays.toString(testArr));
        changeElements(testArr, 0, 9);

        ArrayList<Integer> list = toArrayList(testArr);
        System.out.println(list);

        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        FruitBox<Orange> orangeBox = new FruitBox<Orange>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());

        System.out.println(appleBox.toString());
        System.out.println(orangeBox.toString());

        System.out.println("The boxes weights are equal?: " + appleBox.compare(orangeBox));

        FruitBox<Orange> orangeBox2 = new FruitBox<Orange>();
        orangeBox2.add(new Orange());
        orangeBox2.add(new Orange());

        System.out.println("Orange box 2: " + orangeBox2.toString());

        orangeBox.moveTo(orangeBox2);

        System.out.println(orangeBox);
        System.out.println(orangeBox2);

        //(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
        //orangeBox2.moveTo(appleBox); -- error, as expected
    }

    private static void fillArray(Integer[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = (int)Math.round(Math.random() * 100);
        }
    }

    //1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    private static <T>  void  changeElements(T[] arr, int i1, int i2){
        if (i1 >= arr.length|| i2 >= arr.length){
            return;
        }

        T buf = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = buf;
    }

    //2. Написать метод, который преобразует массив в ArrayList;
    private static <T> ArrayList<T> toArrayList(T[] arr){
        return new ArrayList<T>(Arrays.asList(arr));
    }
}
