package com.company;

import java.util.concurrent.Semaphore;
/**
 * @author nuran
 * @version 1.0.
 * @since 12/27/15
 */
public class Rider extends Thread {
    private Semaphore busStopMutex;
    private Semaphore queue;
    private BusStop busStop;
    int id=0;

    public void run(){
        while (true)
        try{
            boardBus();
        }catch (Exception e){
            System.out.println("from here \n"+e);
        }
    }

    public Rider(BusStop busStop){
        this.busStop = busStop;
        this.busStopMutex = busStop.getBusStopMutex();
        this.queue = busStop.getQueue();
    }

    public void boardBus() throws InterruptedException {
        System.out.println("The "+id+" Came to Bus Stop.");
        queue.acquire();
        System.out.println("The "+id+" Enter to Queue.");
            busStopMutex.acquire();
            busStop.enterBusStopQueue();
            busStopMutex.release();

            busStop.getbusReturn().acquire();
        queue.release();

        //boardBus();

        busStop.getIn();
        System.out.println("****************The "+id+" get into bus.");
        if(busStop.getRaiders() == 0){
            busStop.getAllAboard().release();
        }
        else
            busStop.getbusReturn().release();

    }
}
