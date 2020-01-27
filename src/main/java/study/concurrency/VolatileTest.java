package study.concurrency;

/**
 * Created by EricWang on 2020/1/2 2:28 PM.
 */
public class VolatileTest {

    private volatile int counter = 0;

    public static void main(String[] args) {

        VolatileTest sharedObj = new VolatileTest();


        Thread r1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 1000; i++){
                    ++sharedObj.counter;
                    System.out.println("r1, increase counter to "+ sharedObj.counter);
                }



            }
        });

        Thread r2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000;i ++){
                    System.out.println("r2, read counter as: " + sharedObj.counter);
                }
            }
        }) ;

        r1.start();;

        r2.start();


    }
}
