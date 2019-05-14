package java_threadlocal;



public class Run {

	public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest test = new ThreadLocalTest();

        test.set();
        
        // 在这里新建了一个线程
        
        test.set("fsdfg",12);
        System.out.println(test.getLong());
        System.out.println(test.getString());
        
        Do b = new Do(test);
		Thread a = new Thread(b);
		a.start();
        
        
        a.join();

    }

}
