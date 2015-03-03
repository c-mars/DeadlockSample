package c.mars;

import java.util.Queue;
import java.util.Vector;

public class Main {
    public static final int TRIGGER = -1;
    public static final int MAX = 100;

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<Integer>();

        new Thread(new Consumer(vector)).start();
        new Thread(new Producer(vector)).start();
    }
}
