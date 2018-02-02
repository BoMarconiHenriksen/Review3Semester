package uge1.Day1;

/**
 *
 * @author Bo
 */
public class ThreadDay1Ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
           long sum = 0;

            for (int i = 1; i < 5e10; i++) {
                sum += i;
            }
            System.out.println("t1: " + sum);

        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Fejl i t2 - Thread sleep");
                }
                System.out.println("t2: " + i);
            }

        });

        Thread t3 = new Thread(() -> {

            long startTime = System.currentTimeMillis();
            long endTime = startTime + 10000L;
            Boolean isRunning = true;

            while (System.currentTimeMillis() < endTime) {

                for (int i = 10; isRunning == true; i++) {
                    final int j = i;//Volatile eller synkronized ????
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println("Fejl i t3");
                    }
                    System.out.println("t3: " + j);
                    if (System.currentTimeMillis() > endTime) {
                        isRunning = false;
                    }
                }
            }
        });

        //Når man laver en lamba refer ikke variable udefra
        //Kan rykke variablerne udfra main og gøre dem static
//        Thread[] threads = new Thread[10];
//        for (int i = 0; i < 10; i++) {
//            final int j = i; //Denne her skal indsættes
//            threads[i] = new Thread(() -> {
//                System.out.println(j); 
//            });
//            
//        }
//        
//        for (Thread t : threads) {
//            t.start();
//        }
        t1.start();
        t2.start();
        t3.start();

    }

    //Svar A: Det ser rigtigt ud. Tråd 1 skrives ud først, hvilket er fint, og tråd 2 og 3 skrives ud skiftesvis pga sleepen.
    //Svar B: 
    //Svar C:
    //Excercie 3: https://j2eereference.com/difference-volatile-synchronized-keyword/
}
