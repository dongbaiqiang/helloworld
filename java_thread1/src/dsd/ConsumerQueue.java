package dsd;

import java.util.concurrent.BlockingQueue;

public class ConsumerQueue implements Runnable {

    private final BlockingQueue conQueue;
   
    public ConsumerQueue(BlockingQueue conQueue)
   {
           this .conQueue =conQueue;
   }

    @Override
    public void run() {
           // TODO Auto-generated method stub
           for (int i=0;i<10;i++)
          {
                  try {
                       System. out .println("消费者 ：" +conQueue .take());
                       Thread. sleep(3000);  //在这里sleep是为了看的更加清楚些
                       
                 } catch (InterruptedException e) {
                        // TODO: handle exception
                       e.printStackTrace();
                 }
          }
   }
   
   
}
