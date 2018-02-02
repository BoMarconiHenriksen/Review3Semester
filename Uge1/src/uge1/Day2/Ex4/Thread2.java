package uge1.Day2.Ex4;

import static uge1.Day2.Ex4.ThreadDay2Ex4.lock1;
import static uge1.Day2.Ex4.ThreadDay2Ex4.lock2;

/**
 *
 * @author Bo
 */
public class Thread2 extends Thread {

    public void run() {
        synchronized (lock2) {//Ændre til lock1
            System.out.println("Thread 2: Har lock2");//Tager lock2
            try {
                Thread.sleep(100);//kalder sleep og suspenderes
            } catch (InterruptedException e) {
                System.out.println("Fejl i Thread2 - run metoden.");
            }
            System.out.println("Thread 2: Venter på lock1");
            synchronized (lock1) {//Prøver at tage lock1, men Thread1 holder den og bloker for Thread2
                //Ændre til lock2
                //Alle tråde skal gå efter den samme lock for at undgå deadlock
                System.out.println("Thread 2: Har lock1 og lock2");
            }
            System.out.println("Thread 2: release lock1");
        }
        System.out.println("Thread 2: Release lock2. Exiting...");
    }

}
