package java_threadlocal;

public class Do implements Runnable{

	 ThreadLocalTest test = null;
	 public Do(ThreadLocalTest test){
		 this.test=test;
	 }
	@Override
	public void run() {
		test.set(); // 当这里调用了set方法，进一步调用了ThreadLocal的set方法是，会将ThreadLocal变量存储到该线程的ThreadLocalMap类型的成员变量threadLocals中，注意的是这个threadLocals变量是Thread线程的一个变量，而不是ThreadLocal类的变量。
		test.set("dsaf",2);
		System.out.println(test.getLong());
        System.out.println(test.getString());
      
	}

}
