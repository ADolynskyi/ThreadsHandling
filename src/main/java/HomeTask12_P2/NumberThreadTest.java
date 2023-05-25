package HomeTask12_P2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class NumberThreadTest {
static CopyOnWriteArrayList<String> list =new CopyOnWriteArrayList<>();
    public static void main(String[] args) {
        int maxNumber=35;
        ProcessThread fizzbuzz = new ProcessThread((n) -> {
            if(n%5==0 && n%3==0){
                list.add(n-1,"fizzbuzz");
            }
        });

        ProcessThread fizz = new ProcessThread((n) -> {
            if(n%3==0 && n%5!=0){
                list.add(n-1,"fizz");
            }
        });

        ProcessThread buzz = new ProcessThread((n) ->{
            if(n%5==0 && n%3!=0){
                list.add(n-1,"buzz");
            }
        });
        ProcessThread number = new ProcessThread((n) -> {
            if(n%5!=0 && n%3!=0){
                list.add(n-1,String.valueOf(n));
            }
        });

        List<ProcessThread> threads = new ArrayList<>();
        threads.add(fizzbuzz);
        threads.add(fizz);
        threads.add(buzz);
        threads.add(number);


        for (ProcessThread thread: threads){
            thread.start();
        }

        for (int i = 1; i <=maxNumber ; i++) {
            for (ProcessThread thread : threads) {
                thread.process(i);
            }


            while (true) {
                int processedCounter = 0;
                for (ProcessThread thread : threads) {
                    if (thread.isProcessed()) {
                        processedCounter++;
                    }
                }
                if (processedCounter == threads.size()) {
                    break;
                }
            }
        }
        System.out.println(list);
    }
}
