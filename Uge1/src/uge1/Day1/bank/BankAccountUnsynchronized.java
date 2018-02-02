package uge1.Day1.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// NOT THREADSAFE
public class BankAccountUnsynchronized {

    private double balance;
    private final Lock lock = new ReentrantLock();

    public BankAccountUnsynchronized() {
        balance = 0;
    }

    //Metoderne skal være synkroniseret. Hver gang der er metoder/objekter med delte data mellem tråde
    //så skal det synkroniseres for at undgå race condition. Rækkefølgen af trådene er vilkårlige og derfor kan en tråd
    //ændre variablen før en anden tråd.
    public void deposit(double amount) {//synchronized
//    double newBalance = balance + amount;
//    balance = newBalance; 
        lock.lock();
        balance += amount;
        lock.unlock();
    }

    public void withdraw(double amount) {//synchronized 
//    double newBalance = balance - amount;
//    balance = newBalance;
        lock.lock();
        balance -= amount;
        lock.unlock();
    }

    public double getBalance() {
        return balance;
    }
}
