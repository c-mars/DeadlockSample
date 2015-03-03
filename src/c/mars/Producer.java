package c.mars;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * Created by mars on 3/3/15.
 */
public class Producer implements Runnable {
    private Vector<Integer> vector;

    public Producer(Vector<Integer> vector) {
        this.vector = vector;
    }

    @Override
    public void run() {

            for (int i = 0; i < Main.MAX; i++) {

                try {
                    int sleep = new Random().nextInt(Main.MAX);
                    System.out.println("p: sleep("+sleep+")");
                    TimeUnit.MILLISECONDS.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (vector) {
                    try {
//                        should wait until .notify() will come. here deadlock can happen if consumer don't call .notify()
                        System.out.println("p: wait");
                        vector.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    vector.add(i);
                    System.out.println("p: add(" + i + "), v.size=" + vector.size());
                }
            }
            vector.add(Main.TRIGGER);
            System.out.println("p.complete");

    }
}
