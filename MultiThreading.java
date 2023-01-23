

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class HelloLelo implements Runnable{

    public void doSomething(){
        System.out.println("Hello World!!  by doSomething" + Thread.currentThread().getName());
    }
    @Override
    public void run() {
        System.out.println("Hello World!!  by run" + Thread.currentThread().getName());
      
        doSomething();
    }
}

// class PrinterNumber implements Runnable{
//     int toPrint ;
//     String s ; 
//     PrinterNumber(int toPrint , String s){
//         this.toPrint = toPrint ;
//         this.s = s ;
//     }
//     public void doSomething(){
//         System.out.println("Hello World!!  by " + Thread.currentThread().getName());
//     }
//     public void printTill(){
//         for(int i=1;i<=toPrint;i++){
//             System.out.println( s+" "+i);
//         }
//     }
//     @Override
//     public void run() {
//         doSomething();
//         printTill();
//     }

// }


class NumberPrinter implements Runnable {
    private int numberToPrint;

    NumberPrinter(int numberToPrint) {
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        System.out.println("Printing " + this.numberToPrint + ". Printed by thread: " + Thread.currentThread().getName());
    }
}

class MultiThreading{

    public static void main( String[] args ){
        System.out.println("Hello World!!  by  " + Thread.currentThread().getName());

        HelloLelo helowalla = new HelloLelo() ;
        Thread t  = new Thread(helowalla) ;
        t.start() ;

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 100; ++i) {
            if (i == 5 || i == 11 || i == 20) {
                System.out.println("Debug");
            }
            NumberPrinter numberPrinter = new NumberPrinter(i);
            executor.execute(numberPrinter);
        }

        executor.shutdown();

        // PrinterNumber pt1 = new PrinterNumber(27 , "K") ;
        // PrinterNumber pt2 = new PrinterNumber(66,"S") ;
        // Thread t1 = new Thread(pt1) ;
        // Thread t2 = new Thread(pt2) ;

        // t1.start(); 
        // t2.start(); 
    }
}