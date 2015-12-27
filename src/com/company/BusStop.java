package com.company;

import sun.awt.Mutex;

import java.util.concurrent.Semaphore;

/**
 * @author nuran
 * @version 1.0.
 * @since 12/27/15
 */
public class BusStop {
    //contains the busStop mutex and the queue Semaphore
    private Mutex busStopMutex;
    private Semaphore queue;
    private Bus bus;
    private int queueSize;

    public synchronized void ridersGetIn(int no){
        queueSize = no;
        for(int i=0;i<no;i++){
            queue.release();
        }
    }

    public synchronized void getIn(){
        queueSize--;
        if(queueSize==0)
            bus.depart();
    }

    public Mutex getBusStopMutex() {
        return busStopMutex;
    }

    public void setBusStopMutex(Mutex busStopMutex) {
        this.busStopMutex = busStopMutex;
    }

    public Semaphore getQueue() {
        return queue;
    }

    public void setQueue(Semaphore queue) {
        this.queue = queue;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
