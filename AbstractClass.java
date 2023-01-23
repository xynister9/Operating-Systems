
abstract class  phone{
    phone(){
        System.out.println( "constructor called" );
    }
    
    abstract  void switchOn() ;
}

class vivo extends phone {
    @Override
    void switchOn() {
        System.out.println( "Switched on" );
    }
}
public class AbstractClass{

    public static void main(String[] args ){
        
        vivo v = new vivo() ;
        v.switchOn(); 
    }
}