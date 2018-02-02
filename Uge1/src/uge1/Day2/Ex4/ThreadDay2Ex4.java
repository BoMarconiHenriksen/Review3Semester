package uge1.Day2.Ex4;

/**
 *
 * @author Bo
 */
public class ThreadDay2Ex4 {
    
    //2 statiske variabler som trådene skal bruge til at synkroniserer
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();
    
    public static void main(String[] args) {
        
        new Thread1().start();
        new Thread2().start();
        
    }
    
    //Tråd et låser på objekt lock1, og tråd 2 låser på objekt lock2.
    //Tråd et prøver at tage objekt lock2 men det kan den ikke da tråd 2 har låst object lock2
    //Samtidig prøver tråd 2 at tage objektet lock1, men tråd 1 holder låsen på objekte lock1
    //Der opstår nu en deadlock da de 2 tråde står, og venter på hinanden. 
    //Først når en tråd tager et nyt objekt releaser den locken.
    
    
}
