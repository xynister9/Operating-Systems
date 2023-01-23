
package quickSortPackage ;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> mylist = List.of(7, 3, 4, 1, 9, 8, 2, 6) ;

        ExecutorService executorService = Executors.newCachedThreadPool() ;

        QuickSorter quickSorter = new QuickSorter(mylist, executorService) ;

        Future<List<Integer>> sortedFuture = executorService.submit(quickSorter) ;

        List<Integer> actualSortedList = sortedFuture.get() ; //  this line is code stopping line , halt execution 

        executorService.shutdown(); 
        
        System.out.println(actualSortedList);
    }
}