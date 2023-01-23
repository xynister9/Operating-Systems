package mergeSortPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class MergeSorter implements Callable<List<Integer>> {

    private List<Integer> toSortList ;

    private ExecutorService executorService ;

    MergeSorter(List<Integer> toSortList , ExecutorService executorService ){
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

        int mid = toSortList.size()/2 ;

        for(int i=0;i<toSortList.size();i++){
            if(i<mid){
                left_arr.add(toSortList.get(i)) ;
            }
            else{
                right_arr.add(toSortList.get(i)) ;
            }
        }

        MergeSorter leftMergeSorter = new MergeSorter(left_arr , executorService ) ;
        MergeSorter rightMergeSorter = new MergeSorter(right_arr , executorService ) ;
        
        // ExecutorService executorService = Executors.newCachedThreadPool() ;

        Future<List<Integer>> leftFuture = executorService.submit(leftMergeSorter) ; // code will not go to the next line until this completes 
        Future<List<Integer>> rightFuture = executorService.submit(rightMergeSorter) ;

        int i = 0 ;
        int j = 0 ;
        List<Integer> sortedList = new ArrayList<>(); 

        List<Integer> left = leftFuture.get();
        List<Integer> right = rightFuture.get();
            
        // executorService.shutdown();

        while(i<left.size() && j<right.size()){
            if(left.get(i)<=right.get(j)){
                sortedList.add(left.get(i)) ;
                i++;
            }else{
                sortedList.add(right.get(j)) ;
                j++;
            }
        }

        while(i<left.size() ){
            sortedList.add(left.get(i)) ;
            i++;
        }
        while(j<right.size() ){
            sortedList.add(right.get(j)) ;
            j++;
        }

        return sortedList ; 
    }

}
