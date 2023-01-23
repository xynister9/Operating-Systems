package producerConsumerProblemPackage ;

import java.util.Queue;

public class Consumer implements Runnable {

    private  Queue<Object>  queue ;
    private int maxSize ;

    Consumer( Queue<Object> queue , int maxSize ){
        this.queue = queue ;
        this.maxSize = maxSize ;
    }

    @Override
    public void run() {
        if(maxSize>0){}
        
        while(true){
            if(queue.size()>0){
                queue.remove() ;
            }
        }
    }

}