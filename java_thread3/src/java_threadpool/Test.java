package java_threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {

	public static void main(String[] arg){
		
		
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		Box box = new Box();
		
		Do2 a = new Do2("       1",box);
		Do2 b = new Do2("2       ",box);

		Future future1 = service.submit(a);
		Future future2 = service.submit(b);

		service.shutdown();
	}
}
