package uge1.Fredag.ExamPrep;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Bo
 */
public class ExamPrepWeek1 {

    public static void main(String[] args) {

        //Laver en kø af integers FIFO. Er thread safe. 
        //De tal som skal udregnes som Fibernacci tal.
        ArrayBlockingQueue<Integer> s1 = new ArrayBlockingQueue(12);

        //Tilføjer numre til s1
        int[] numbersToProducer = {4, 5, 8, 12, 21, 22, 34, 35, 36, 37, 42};

        for (int i = 0; i < numbersToProducer.length; i++) {
            s1.add(numbersToProducer[i]);
        }

        //De udregnede Fibonacci tal. s2
        ArrayBlockingQueue<Integer> producedNumbers = new ArrayBlockingQueue(12);

        //
        ExecutorService es = Executors.newCachedThreadPool();

        //Laver og starter de 4 producere. P1 til P4
        es.execute(new FibernacciProducer(s1, producedNumbers));
        es.execute(new FibernacciProducer(s1, producedNumbers));
        es.execute(new FibernacciProducer(s1, producedNumbers));
        es.execute(new FibernacciProducer(s1, producedNumbers));

        //Laver en consumer og starter den
        FibernacciConsumer consumer = new FibernacciConsumer(producedNumbers);
        es.execute(consumer);

        es.shutdown();
        try {
            es.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("Closing Down");
        } catch (InterruptedException e) {
            System.out.println("Fejl ved closing down i main");
        }

    }

}