package c.mars;

import sun.jvm.hotspot.jdi.ThreadReferenceImpl;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * Created by mars on 3/3/15.
 */
public class Consumer implements Runnable {
    Vector<Integer> vector;

    public Consumer(Vector<Integer> vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        int d = 0;

        do {
            synchronized (vector) {
//                we should call .notify() to ping producer to produce some data. otherwise it will lock forever
//                we choose condition when we don't notify producer - so deadlock will happen
                if (d < Main.MAX * 0.2) {
                    System.out.println("c: notify");
                    vector.notify();
                }
                //                else {
//                    System.out.println("c: no notify");
//                }


                if (!vector.isEmpty()) {
                    d = vector.get(0);
                    vector.remove(0);
                    System.out.println("c: pop=" + d + ", v.size=" + vector.size());

                }
//                else {
//                    System.out.println("v.isEmpty");
//                }

            }
        } while (d != Main.TRIGGER);
        System.out.println("c.complete");
    }
}
