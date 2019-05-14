package java_thread3;

public class Do implements Runnable{

	private int num =1000;
	private String name;
	public Do(String name){
		this.name = name;
	}
	@Override
	public void run() {
		for(; num > 0; num--){
			System.out.println(this.name + num);		
		}	
	}
}
