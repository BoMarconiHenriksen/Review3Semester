package uge1.Day1.turnstiles;

public class TurnstileCounter {

  static final long DELAY_VAL = 10000;
  long count = 0;

  public long getValue() {
    return count;
  }

  //Svar b: Der opstår en racing condition. Den kan springe counts over i forloopet i run metoden.
  
  //Svar c:Skal synkroniseres da der opstår race condition på metoden incr(), dvs problemet kommer til at blive count++, da trådene
  //ikke nødvendigvis kommer i den rigtige rækkefølge vil tællingen blive forkert.
  public synchronized void incr() {
//   If the program initially does "never" fail, replace the count line with the lines below
//    long n = count;
//    //Spend some time to force preemtion
//    for(long a=0; a<LockDemo.DELAY_VAL; a++);
//    n = n + 1;
//    count = n;

    count++;
  }
}