package ru.gb.hw5.race;

import ru.gb.hw5.Car;

public abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}
