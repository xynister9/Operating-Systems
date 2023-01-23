package quickSortPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class QuickSorter implements Callable<List<Integer>> {

    private List<Integer> toSortList ;

    private ExecutorService executorService ;

    QuickSorter(List<Integer> toSortList , ExecutorService executorService ){
        this.toSortList = toSortList ;
        this.executorService = executorService ;
    }

    @Override
    public List<Integer> call() throws Exception {
        
        if(toSortList.size()<=1){
            return toSortList ;
        }

        System.out.println("Sorting going on " + toSortList + " by : " + Thread.currentThread().getName());

        List<Integer> left_arr  = new ArrayList<Integer>() ;
        List<Integer> right_arr = new ArrayList<Integer>() ;

        int pivot = toSortList.get(0);

        for(int i=1;i<toSortList.size();i++){
            if(toSortList.get(i)<=pivot){
                left_arr.add(toSortList.get(i)) ;
            }
            else{
                right_arr.add(toSortList.get(i)) ;
            }
        }

        QuickSorter leftQuickSorter = new QuickSorter(left_arr , executorService ) ;
        QuickSorter rightQuickSorter = new QuickSorter(right_arr , executorService ) ;
        
        Future<List<Integer>> leftFuture = executorService.submit(leftQuickSorter) ; // code will not go to the next line until this completes 
        Future<List<Integer>> rightFuture = executorService.submit(rightQuickSorter) ;

        int i = 0 ;
        int j = 0 ;
        List<Integer> sortedList = new ArrayList<>(); 

        List<Integer> left = leftFuture.get();
        List<Integer> right = rightFuture.get();
            
        
        while(i<left.size() ){
            sortedList.add(left.get(i)) ;
            i++;
        }
        sortedList.add(pivot) ;
        while(j<right.size() ){
            sortedList.add(right.get(j)) ;
            j++;
        }

        return sortedList ; 
    }

}
