package producerConsumerProblemPackage ;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Client {
    
    public static void main(String[] args) {
        Queue<Object> queue = new ConcurrentLinkedDeque<>() ;

        Producer p1 = new Producer(queue, 6) ;
        Producer p2 = new Producer(queue, 6) ;
        Producer p3 = new Producer(queue, 6) ;

        Consumer c1 = new Consumer(queue, 6) ;
        Consumer c2 = new Consumer(queue, 6) ;
        Consumer c3 = new Consumer(queue, 6) ;
        Consumer c4 = new Consumer(queue, 6) ;
        Consumer c5 = new Consumer(queue, 6) ;

        Thread t1 = new Thread(p1) ;
        t1.start();
        Thread t2 = new Thread(p2) ;
        t2.start();
        Thread t3 = new Thread(p3) ;
        t3.start();


        Thread t4 = new Thread(c1) ;
        t4.start(); 
        Thread t5 = new Thread(c2) ;
        t5.start(); 
        Thread t6 = new Thread(c3) ;
        t6.start(); 
        Thread t7 = new Thread(c4) ;
        t7.start(); 
        Thread t8 = new Thread(c5) ;
        t8.start(); 

    }
    
}
