package lab3;

import java.util.Random;

public class Main {

    static Integer storage = 0;
    final static Object mutex = new Object();

    public static void main(String[] args) {
        final int argument = Integer.parseInt(args[0]);
        class producerThread extends Thread
        {
            public void run(){
                //System.out.println("producer runs");
                for (int i = 0; i < argument; i++) {
                    synchronized (mutex) {
                        addProduct();
                        System.out.println("Thread name: producer");
                        System.out.println("Storage = " + storage);
                        mutex.notify();
                        try{
                            mutex.wait();
                        }
                        catch (InterruptedException e){
                            e.printStackTrace();
                        }  //TODO try to change code, ha
                    }
                }


            }

            public void addProduct()
            {
                Random random = new Random();
                int temp = random.nextInt(100);
//                while (temp == 0) {
//                    temp = random.nextInt(100);
//                }
                storage = temp;
            }
        }

        class consumerThread extends Thread
        {
            public void run() {
                //System.out.println("consumer runs");
                for (int i = 0; i < argument; i++) {
                    synchronized (mutex) {
                        try {
                            mutex.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //if (storage != 0) {
                            getProduct();
                            System.out.println(i+" iteration");
                        //}
                        mutex.notify();
                    }
                }

                //getProduct(1);
                //System.out.println("get = "+storage);
            }

            public void getProduct()
            {
                System.out.println("Thread name: consumer");
                System.out.println("Storage = "+storage);
                //System.out.println("      11           ");
            }
        }

        consumerThread consumer = new consumerThread();
        producerThread producer = new producerThread();

        consumer.start();
        producer.start();


        //++storage;
//        try{
//            Thread.sleep(1000);
//        }
//        catch (InterruptedException e){
//        }
//
//        System.out.println("storage = "+storage);
    }
}