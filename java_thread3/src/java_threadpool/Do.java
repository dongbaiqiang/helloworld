package java_threadpool;

public class Do implements Runnable{

	private String name;
	public Do(String name){
		this.name = name;
	}
	@Override
	public void run() {
		for(int i = 0; i < 10; i++ ){
			System.out.println("thread" + name + "   :" + i);
		}
		
	}

}
