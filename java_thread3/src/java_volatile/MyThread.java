package java_volatile;

public class MyThread extends Thread{
	volatile private boolean isRunning = true;
	public void setRun(boolean a ){
		this.isRunning = a;
	}
	
	public void run(){
		
		System.out.println("进入线程");
		
		System.out.println(isRunning);
		while(isRunning){
			
		}
		System.out.println("结束");
		
	}

}
