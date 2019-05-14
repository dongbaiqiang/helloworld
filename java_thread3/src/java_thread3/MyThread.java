package java_thread3;

public class MyThread extends Thread {
	private String name;
	
	public MyThread(String name){
		this.name = name;
	}
	
	public void run(){
		for(int i = 0; i < 100; i++){
			System.out.println(this.name + i);		
		}
	}
	
	public static void main1(String[] args) {
		Thread a = new MyThread("小明");
		Thread b = new MyThread("小红");
		a.start();
		b.start();
	}

}
