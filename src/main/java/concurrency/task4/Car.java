package concurrency.task4;


import java.util.Random;

import static concurrency.task4.Parking.SEMAPHORE;


public class Car extends Thread {
    private int carNumber;

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        System.out.println("Car_" + this.carNumber + " looking for parking spot");
        try {
            Parking.SEMAPHORE.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int parkingNumber = -1;
        synchronized (Parking.PARKING_PLACES) {
            for (int i = 0; i < 5; i++)
                if (!Parking.PARKING_PLACES[i]) {
                    Parking.PARKING_PLACES[i] = true;
                    parkingNumber = i;
                    System.out.println("Car_" + this.carNumber + " occupied parking spot № " + parkingNumber);
                    break;
                }
        }

        if (parkingNumber == -1)
            System.out.println("Car_" + this.carNumber + " can`t find empty place");



        else {
            try {
                Thread.sleep(getRandomSec());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (Parking.PARKING_PLACES) {
                Parking.PARKING_PLACES[parkingNumber] = false;
            }

            SEMAPHORE.release();
            System.out.println("Car_" + this.carNumber + " left parking spot");
        }
    }

    private int getRandomSec(){
        return new Random().nextInt(6000)+2000;
    }
}


