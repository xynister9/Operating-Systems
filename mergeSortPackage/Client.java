package mergeSortPackage ;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Client {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool() ;

        List<Integer> list1 = List.of(7, 3, 4, 1, 9, 8, 2, 6);

        MergeSorter listSorter = new MergeSorter(list1 , executorService ) ;

        Future<List<Integer>> sortedListFuture  = executorService.submit(listSorter);

        List<Integer> sortedList = sortedListFuture.get(); // this is code stopping / waiting line  

        System.out.println(sortedList);

        executorService.shutdown();

    }
}

