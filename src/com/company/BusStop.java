package com.company;

import java.util.concurrent.Semaphore;

/**
 * @author nuran
 * @version 1.0.
 * @since 12/27/15
 */
public class BusStop {
    //contains the busStop mutex and the queue Semaphore
    private Semaphore busStopMutex;
    private Semaphore queue;
    private int queueSize;
    private int raiders=0;
    private Semaphore busReturn;
    private Semaphore AllAboard;

    public BusStop(Semaphore busStopMutex,Semaphore busReturn, Semaphore allAboard, Semaphore queue){
        this.busStopMutex = busStopMutex;
        this.queue = queue;
        this.busReturn = busReturn;
        this.AllAboard = allAboard;
    }
    public synchronized int getRaiders(){
        return raiders;
    }

    public synchronized void enterBusStopQueue(){
        raiders++;
    }
    public synchronized void getIn(){
        raiders--;
    }

    public Semaphore getQueue() {
        if(queue == null)
            queue = new Semaphore(0);

        return queue;
    }

    public Semaphore getBusStopMutex() {
        return busStopMutex;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public Semaphore getbusReturn() {
        return busReturn;
    }

    public Semaphore getAllAboard() {
        return AllAboard;
    }
}
