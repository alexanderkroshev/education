package concurrency.task4;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import static concurrency.task4.Parking.SEMAPHORE;

@AllArgsConstructor
public class Car implements Runnable {
    private int carNumber;

    @Override
    @SneakyThrows
    public void run() {
        System.out.println("Car_" + this.carNumber + " looking for parking spot");
        Parking.SEMAPHORE.acquire();
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
            Thread.sleep(5000);
            synchronized (Parking.PARKING_PLACES) {
                Parking.PARKING_PLACES[parkingNumber] = false;
            }

            SEMAPHORE.release();
            System.out.println("Car_" + this.carNumber + " left parking spot");
        }
    }
}


