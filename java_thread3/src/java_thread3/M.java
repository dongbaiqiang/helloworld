package java_thread3;



	
public class M{
	

	public static void main(String[] arg){
		Do a = new Do("小红");
		Do b = new Do("明");
		Thread a1 = new Thread(a);
		Thread b1 = new Thread(b);
		a1.start();
		b1.start();
	} 
	
}
	

