package com.company;

import sun.awt.Mutex;

import java.util.concurrent.Semaphore;
/**
 * @author nuran
 * @version 1.0.
 * @since 12/27/15
 */
public class Rider {
    private Mutex busStopMutex;
    private Semaphore queue;
    private BusStop busStop;

    public Rider(BusStop busStop){
        this.busStopMutex = busStop.getBusStopMutex();
        this.queue = busStop.getQueue();
    }

    public void boardBus() throws InterruptedException {
        busStopMutex.lock();
        busStopMutex.unlock();
        queue.acquire();
        busStop.getIn();
        
    }
}
