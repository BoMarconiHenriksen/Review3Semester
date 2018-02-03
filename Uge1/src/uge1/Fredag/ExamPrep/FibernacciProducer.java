package uge1.Fredag.ExamPrep;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Bo
 */
public class FibernacciProducer implements Runnable {

    BlockingQueue<Integer> numbersToUse;
    BlockingQueue<Integer> producedNumbers;
    private volatile boolean moreNumbersToFetch = true;

    public FibernacciProducer(BlockingQueue<Integer> numbersToUse, BlockingQueue<Integer> producedNumbers) {
        this.numbersToUse = numbersToUse;
        this.producedNumbers = producedNumbers;
    }

    @Override
    public void run() {

        while (moreNumbersToFetch) {

            try {
                Integer number = numbersToUse.poll();

                if (number == null) {
                    Thread.currentThread().interrupt();
                    moreNumbersToFetch = false;
                } else {
                    long fibNumber = fib(number);
                    Integer fibInt = (int) (long) fibNumber;
                    producedNumbers.put(fibInt);
                }
            } catch (InterruptedException e) {
                System.out.println("Fejl i producer run metoden!");
            }
        }

    }

    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    
}
