package HomeTask12_P1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(Thread.currentThread().getName());
        int second=0;
        Thread myThread=new MyThread();
        myThread.start();

        while (true){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            second++;
            if(second<2) {
                System.out.println(second + " second from start");
            }else {
                System.out.println(second + " seconds from start");
            }
        }
    }
}