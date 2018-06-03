package lab4;

public class Main {

    public static void pick(){
        for (int i = 0; i < 10000; ++i) {
            //
        }
    }

    public static final Object mutex = new Object();
    public static int basketNumber = 0;
    public static int doneBaskets = 0;

    public static void main(String[] args) {

        basketNumber = Integer.parseInt(args[1]);

        class worker implements Runnable{
            private Thread t_;
            private String name_;

            worker(String name){
                name_ = name;
                t_ = new Thread(this, name);
                t_.start();
            }

            public void run(){
                System.out.println("Thread "+name_+"'s  started.");
                while(basketNumber > 0) {
                    synchronized (mutex) {
                        try{
                            mutex.wait();
                        }
                        catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        //pick();
                        basketNumber -= 1;
                        if(basketNumber < 0) {
                            break;
                        }
                        System.out.println("Thread " + name_ + " picked " + basketNumber + "th basket.");

                    }
                }

            }
        }

        class extraWorker implements Runnable{
            private Thread t_;
            private String name_;

            extraWorker(String name){
                name_ = name;
                t_ = new Thread(this, name);
                t_.start();
            }

            public void run(){
                System.out.println("Thread "+name_+"'s  started.");
                while(basketNumber > 0) {
                    synchronized (mutex) {
                        mutex.notify();
                        doneBaskets += 1;
                    }
                }
            }
        }

        worker workers[] = new worker[Integer.parseInt(args[0])];
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            workers[i] = new worker("w"+i);
        }

        extraWorker ew = new extraWorker("extra1");
    }
}
