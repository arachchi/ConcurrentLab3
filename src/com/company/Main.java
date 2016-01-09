package com.company;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int noOfRiders = Integer.parseInt(args[0]);
        int noOfBuses = Integer.parseInt(args[1]);

        Semaphore busStopMutex= new Semaphore(1);
        Semaphore busReturn = new Semaphore(0);
        Semaphore allAboard =new Semaphore(0);
        Semaphore queue = new Semaphore(50);

        BusStop busStop = new BusStop(busStopMutex,busReturn,allAboard,queue);

        Rider riders[] = new Rider[noOfRiders];
        Bus buses[] = new Bus[noOfBuses];

        for(int i=0;i<noOfRiders;i++) {
            riders[i] = new Rider(busStop);
            riders[i].id=i;
        }

        for(int i=0;i<noOfBuses;i++) {
            buses[i] = new Bus(busStop);
            buses[i].id=i;
        }


         {
            for (int i = 0; i < noOfRiders; i++) {
                riders[i].start();
            }

            for (int i = 0; i < noOfBuses; i++) {
                buses[i].start();
            }
        }





    }
}
