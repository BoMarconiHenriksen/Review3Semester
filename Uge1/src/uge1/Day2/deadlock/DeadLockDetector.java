package uge1.Day2.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 *
 * @author Bo
 */
public class DeadLockDetector extends Thread{
    
    ThreadMXBean bean = ManagementFactory.getThreadMXBean();
    
  public void run() {
    while (true) {
      long[] threadIds = bean.findDeadlockedThreads();
        System.out.println("Deadlock detected!");
    }
  }
}

    

