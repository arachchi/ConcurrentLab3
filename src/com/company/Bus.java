package com.company;

import java.util.concurrent.Semaphore;

/**
 * @author nuran
 * @version 1.0.
 * @since 12/27/15
 */
public class Bus extends Thread{
    private Semaphore busStopMutex;
    private int noOfSeats;
    private BusStop busStop;
    private Semaphore busReturn;
    int id;

    public void run(){
        while (true) {
            System.out.println(".....The " + id + " Bus has reached.");
            reachBusStop();
        }
    }
    public Bus(BusStop busStop){
        this.busStop = busStop;
        this.busStopMutex = busStop.getBusStopMutex();
        this.busReturn= busStop.getbusReturn();
        noOfSeats = 50;
    }

    public void reachBusStop(){
        try {
            busStopMutex.acquire();
            if (busStop.getRaiders() > 0) {

                busReturn.release();
                busStop.getAllAboard().acquire();

            }
            busStopMutex.release();
        }catch (Exception e){}
        depart();

    }

    public void depart(){
        System.out.println(" ------------------------The"+id+" bus departed.-------------------------------------------");
    }
}
