package uge1.Day2.rndnumberprodcon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class RandomNumberConsumer implements Runnable {

    ArrayBlockingQueue<Integer> numbersProduced;

    public RandomNumberConsumer(ArrayBlockingQueue<Integer> numbersProduced) {
        this.numbersProduced = numbersProduced;
    }
    //Should eventually hold the sum of all random number consumed
    int sumTotal = 0;
    List<Integer> below50 = new ArrayList();
    List<Integer> aboveOr50 = new ArrayList();

    @Override
    public void run() {
        //In this exercise, we start four threads, each producing 100 numbers, so we know how much to consume
        for (int i = 0; i < 400; i++) {
            //Todo: Fetch numbers from numbersProduced and do what you have to do
            try {
                int number = numbersProduced.take();
                sumTotal += number;
               
                if (number < 50) {
                    getBelow50().add(number);
                } else {
                    getAboveOr50().add(number);
                }
            } catch (InterruptedException e) {
                System.out.println("Fejl i consumer!");
            }

        }
    }

    public int getSumTotal() {
        return sumTotal;
    }

    public List<Integer> getBelow50() {
        return below50;
    }

    public List<Integer> getAboveOr50() {
        return aboveOr50;
    }

}
