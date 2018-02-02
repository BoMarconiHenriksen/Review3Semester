package uge1.Fredag.ExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author Bo
 */
public class FibernacciConsumer implements Runnable {
    
    int sumTotal;
    List<Integer> fibernacciNumbers = new ArrayList();
    ArrayBlockingQueue<Integer> producedNumbers;

    public FibernacciConsumer(ArrayBlockingQueue<Integer> producedNumbers) {
        this.producedNumbers = producedNumbers;
    }

    @Override
    public void run() {
      boolean morenumbersToConsume = true;
      int totalFibSum = 0;
      Integer fibNumber;
        
      while(morenumbersToConsume) {
          try {
              fibNumber = producedNumbers.take();
              
              if(fibNumber != null) {
                  System.out.println("Fibernacci number is: " + fibNumber);
                  totalFibSum += fibNumber;
                  System.out.println("Totalsummen er " + totalFibSum);
              } else {
                  morenumbersToConsume = false;
              }
          } catch (InterruptedException e) {
              System.out.println("Fejl i consumer - metode run.");
          }
      }
        

    }
    
    
    
}
