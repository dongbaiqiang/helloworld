package java_threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Do2 implements Callable<Object>{


	//Lock l = new ReentrantLock();
	private Box box;
	private String name;
	
	public Do2(String name,Box box){
		this.name = name;
		this.box = box;
	}
	
	@Override
	public Object call() throws Exception {
	

		for(int i = 0; i < 1000; i++ ){
			box.add1(name);
			box.add();
			box.delete();
		}
		return null;
	}

}
