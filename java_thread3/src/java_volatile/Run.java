package java_volatile;

public class Run {

	public static void main(String[] arg) {
		
		MyThread t1 = new MyThread();
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.setRun(false);
	}
}
