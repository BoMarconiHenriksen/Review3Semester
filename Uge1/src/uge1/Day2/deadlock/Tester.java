package uge1.Day2.deadlock;

import java.util.logging.Level;
import java.util.logging.Logger;

//Svar a: Der opstår en deadlock
//ResourceUser1 låser på lock2
//ResourceUser2 låser på lock1

//De 3 føste er vigtige:
//Holder flere låse på en gang. 
//deler resoucer
//cykliske låsereferance
//programmet kan ikke løse deadlock.

//Svar c2: Begge run metoder starter med at gå efter lock1, og derefter lock2
public class Tester {
  public static void main(String[] args) {
    
    try {
      ResourceContainer resources = new ResourceContainer();
      ResourceUser1 t1 = new ResourceUser1(resources);
      ResourceUser2 t2 = new ResourceUser2(resources);
      DeadLockDetector detectDeadlock = new DeadLockDetector();
      t1.start();
      t2.start();
     // detectDeadlock.start();
          
      t1.join();
      t2.join();
      
      System.out.println("Done");
      System.out.println("Words produced: "+resources.getResourceWords().size());
      System.out.println("Numbers produced: "+resources.getResourceNumbers().size());
    } catch (InterruptedException ex) {
      Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
