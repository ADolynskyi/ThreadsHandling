package org.example;

public class MyThread extends Thread{
    @Override
    public void run(){

    while (true) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("5 seconds left");
    }
    }
}
