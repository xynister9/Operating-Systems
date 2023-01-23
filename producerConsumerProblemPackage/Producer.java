package producerConsumerProblemPackage;

import java.util.Queue;

public class Producer implements Runnable {
    private  Queue<Object>  queue ;
    private int maxSize ;

    Producer( Queue<Object> queue , int maxSize ){
        this.queue = queue ;
        this.maxSize = maxSize ;
    }
    @Override
    public void run() {
        while(true){
            if(queue.size()<maxSize){
                queue.add(new Object()) ;
            }
        }
    }
    
}
