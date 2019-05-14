
package homework2;


public class Producer implements Runnable { 
    private PublicBox box; 
 
    public Producer(PublicBox box) { 
        this .box = box; 
    } 
 
    @Override 
    public void run() { 
       
        for( int i=0;i<10;i++)  
       {
              
       
            box.increace(); 
       }
        
    } 
}