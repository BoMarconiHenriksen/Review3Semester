package uge1.Day2.Ex4;

import static uge1.Day2.Ex4.ThreadDay2Ex4.lock1;
import static uge1.Day2.Ex4.ThreadDay2Ex4.lock2;

/**
 *
 * @author Bo
 */
public class Thread1 extends Thread {

    public void run() {
        synchronized (lock1) {//tager lock1
            System.out.println("Thread 1: Har lock1");
            try {
                Thread.sleep(100);//Kalder sleep og suspenderes
            } catch (InterruptedException e) {
                System.out.println("Fejl i Thread1 - run metoden.");
            }
            System.out.println("Thread 1: Venter på lock2.");
            synchronized (lock2) {//prøver at tage lock 2, men Thread2 holder den og bloker for Thread1
                System.out.println("Thread 1: Har lock1 og lock2");
            }
            System.out.println("Thread 1: Release lock2");
        }
        System.out.println("Thread 1: Released lock1. Exiting...");
    }

}
