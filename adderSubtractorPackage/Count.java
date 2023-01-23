package adderSubtractorPackage;

public class Count {
    Integer value ;

    Count( Integer c ){
        value = c ;
    }

    synchronized void incrementBy (int val){
        value+=val ;
    }

    Integer getValue(){
        return value ;
    }
}
