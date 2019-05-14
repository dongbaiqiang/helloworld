package homework2;

public class Consumer implements Runnable { 
    private PublicBox box; 
 
    public Consumer(PublicBox box) { 
        this .box = box; 
    } 
 
    @Override 
    public void run() { 
       
        for( int i=0;i<10;i++)
       {
             
       
            box.decreace(); 
        } 
 } 
}