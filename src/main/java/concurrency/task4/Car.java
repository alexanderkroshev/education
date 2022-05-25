package concurrency.task4;

import java.util.Random;

public class Car extends Thread {
    private int carNumber;
    private Parking parking;

    public Car(int carNumber, Parking parking) {
        this.carNumber = carNumber;
        this.parking = parking;
    }

    @Override
    public void run() {
        System.out.println("Car_" + this.carNumber + " looking for parking spot");
        try {
            parking.getSEMAPHORE().acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int parkingNumber = -1;
        synchronized (parking.getPARKING_PLACES()) {
            for (int i = 0; i < 5; i++)
                if (!parking.getPARKING_PLACES()[i]) {
                    parking.getPARKING_PLACES()[i] = true;
                    parkingNumber = i;
                    System.out.println("Car_" + this.carNumber + " occupied parking spot № " + parkingNumber);
                    break;
                }
        }

        if (parkingNumber == -1)
            System.out.println("Car_" + this.carNumber + " can`t find empty place");
        else {
            try {
                Thread.sleep(5000);//TODO change 5000 to random...
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (parking.getPARKING_PLACES()) {
                parking.getPARKING_PLACES()[parkingNumber] = false;
            }

            parking.getSEMAPHORE().release();
            System.out.println("Car_" + this.carNumber + " left parking spot");
        }
    }
}

