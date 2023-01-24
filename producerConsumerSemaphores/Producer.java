package producerConsumerSemaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private  Queue<Object>  queue ;

    Semaphore producerSemaphore ;
    Semaphore consumerSemaphore ;
    String name ;

    Producer( Queue<Object> queue , Semaphore producerSemaphore, Semaphore consumerSemaphore , String name ){
        this.queue = queue ;
        this.producerSemaphore = producerSemaphore ; 
        this.consumerSemaphore = consumerSemaphore ;
        this.name = name ;
    }

    @Override
    public void run() {
        while(true){
            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            queue.add(new Object()) ;

            System.out.println(name + " : created an object and size " + queue.size() );

            consumerSemaphore.release();
        }
    }
    
}
