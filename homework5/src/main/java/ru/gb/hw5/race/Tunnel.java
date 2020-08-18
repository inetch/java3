package ru.gb.hw5.race;

import ru.gb.hw5.Car;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private static Semaphore tunnelSemaphore;
    private static int tunnelCapacity;

    public Tunnel(int carCount) {
        if(carCount > 1){
            tunnelCapacity = carCount / 2;
        }else{
            tunnelCapacity = carCount;
        }

        if(tunnelSemaphore == null){
            tunnelSemaphore = new Semaphore(tunnelCapacity);
        }

        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                tunnelSemaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description + " " + (tunnelCapacity - tunnelSemaphore.availablePermits()) + "/" + tunnelCapacity);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                tunnelSemaphore.release();
                System.out.println(c.getName() + " закончил этап: " + description + " " + (tunnelCapacity - tunnelSemaphore.availablePermits()) + "/" + tunnelCapacity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
