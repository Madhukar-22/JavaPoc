package com.java8.basics;

/** Basic Thread use via different ways*/
public class BasicThreadUse {
    public static void main(String[] args) {


        // Extending Thread but using main thread
        ThreadClass mainThread = new ThreadClass();
        mainThread.run();

        // Extending Thread
        ThreadClass usingThread = new ThreadClass();
        usingThread.start();

        //Implementing Runnable
        Thread usingRunnable = new Thread(new RunnableClass());
        usingRunnable.start();

        //Using Thread constructor
        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " - Inside Thread Constructor Class");
            }
        }).start();

        //Using Lambda
        new Thread(()-> {
            int i=0;
            while(i<4){
            System.out.println(Thread.currentThread().getName() +" - Using Lambda Expression ");
            i++;
            }
        }
        ).start();
    }
}

class RunnableClass implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName() + " - Inside Runnable Class");
    }
}

class ThreadClass extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - Inside Thread Class");
    }
}
