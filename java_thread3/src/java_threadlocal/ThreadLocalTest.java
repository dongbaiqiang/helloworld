package java_threadlocal;

public class ThreadLocalTest {
    

    
	public ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    public ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public void set(String a,int b) {
        longLocal.set((long) b);
        stringLocal.set(a);
    }
    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

}
