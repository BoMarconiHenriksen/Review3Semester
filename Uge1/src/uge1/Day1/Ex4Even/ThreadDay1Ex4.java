package uge1.Day1.Ex4Even;

/**
 *
 * @author Bo
 */
public class ThreadDay1Ex4 {

    //public static volatile int number;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            Even e1 = new Even();

            for (int i = 0; i < 1000000; i++) {
                int number = e1.next();
                if (number % 2 == 0) {
                    System.out.println("t1 " + number);
                } else {
                    System.out.println("Nummeret er ikke lige! " + number);
                    break;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            Even e1 = new Even();

            for (int i = 0; i < 1000000; i++) {
                int number = e1.next();
                if (number % 2 == 0) {
                    System.out.println("t2 " + number);
                } else {
                    System.out.println("Nummeret er ikke lige! " + number);
                    break;
                }
            }

        });

        t1.start();
        t2.start();
        //t1.start();
    }

}

//Første gang du kalder t1 kommer den hen og jvm kører run metoden, når det sker kalder t1 start metoden. Det giver java.lang.IllegalThreadStateException
// da den nu kører 2 tråde samtidig. Den ene returner fra start metoden og den anden kører run metoden.
