package producerConsumerSemaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

    private  Queue<Object>  queue ;
    private int maxSize ;
    
    Semaphore producerSemaphore ;
    Semaphore consumerSemaphore ;
    String name ;

    Consumer( Queue<Object> queue , int maxSize , Semaphore producerSemaphore, Semaphore consumerSemaphore , String name ){
        this.queue = queue ;
        this.maxSize = maxSize ;
        this.producerSemaphore = producerSemaphore ; 
        this.consumerSemaphore = consumerSemaphore ;
        this.name = name ;
    }
    @Override
    public void run() {
        while(true){
            try {
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(queue.size()>0){ //size not needed now Semaphore keeps check
                queue.remove() ;
                System.out.println(name + " : removed an object and size " + queue.size() );

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            producerSemaphore.release();
        }
    }

}