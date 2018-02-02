package uge1.Day1.Ex4Even;

/**
 *
 * @author Bo
 */
public class Even {
    
    private int n = 0;
    
    public synchronized int next() {
        n++;
        n++;
        
        return n;
    }
    
}
