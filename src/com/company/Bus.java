package com.company;

import sun.awt.Mutex;

import java.util.concurrent.Semaphore;

/**
 * @author nuran
 * @version 1.0.
 * @since 12/27/15
 */
public class Bus {
    private Mutex busStopMutex;
    private int noOfSeats;
    private BusStop busStop;

    public Bus(BusStop busStop){
        this.busStopMutex = busStop.getBusStopMutex();
        noOfSeats = 50;
    }

    public void reachBusStop(){
        busStopMutex.lock();

        busStop.setBus(this);
        busStop.ridersGetIn(noOfSeats);

    }

    public void depart(){
        busStopMutex.unlock();
    }
}
