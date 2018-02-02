package uge1.Day1;

/**
 *
 * @author Bo
 */
public class ThreadDay1Ex2 {
    
    public static void main(String[] args) {

        //Function tager en integer
        //for loop med antal integers
        //Start en tråd i loopet
        //sout thread id(n): 1 til n * 100
        //ThreadDay1Ex2.createThreads(4);
                int numberOfThreads = 5;
        
                for (int i = 0; i < numberOfThreads; i++) {
        
                    int number = i * 100;
                    System.out.println("Nummeret er " + number);
        
                    Thread t = new Thread(() -> {
        
                        for (int j = 0; j < number; j++) {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                System.out.println("Fejl!");
                            }
                            System.out.println("Id " + j);
        
                        }
        
                    });
        
                    t.start();
                }
            }

//    public static void createThreads(int n) {
//        
//        Thread[] threadList = new Thread[n];
//        
//        for (int i = 0; i < n; i++) {
//            final int j = i;
//            threadList[j] = new Thread(() -> {
//                int number = n * 100;
//                for (int k = 0; k < number; k++) {
//                    try {
//                        Thread.sleep(500);
//                        System.out.println(threadList[j].getName() + " k");
//                    } catch (InterruptedException e) {
//                        System.out.println("Fejl i createThreads!");
//                    }
//                }
//            });
//            threadList[i].start();
//        }
//        
//    }
    
}

//A: Numrene fra trådene kommer blandet f.eks tråd 1 nummer 1 til 25, tråd 2 nr. 1 - 2 osv
//B: Hvert nummer kommer skiftevis fra hver tråd.
