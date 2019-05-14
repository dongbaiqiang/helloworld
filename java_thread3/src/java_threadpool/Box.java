package java_threadpool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Box {

	private int i = 0;
	
	Lock l = new ReentrantLock();
	
	public void add1(String a){
		l.lock();
		i++;
		System.out.println(a + ":" + i);
		l.unlock();
	}
	public void add2(String a){
		l.lock();
		i++;
		System.out.println(a + ":" + i);
		l.unlock();
	}
	public void delete(){
		
		l.lock();
		i--;
		l.unlock();
	}
	public void add(){
		l.lock();
		i++;
		l.unlock();
	}
}
