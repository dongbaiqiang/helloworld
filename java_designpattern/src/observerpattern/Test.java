package observerpattern;

public class Test {
    
    public static void main(String[] args) {
        WechatServer server = new WechatServer();
        
        Observer userM = new User("小明");
        Observer userH = new User("小红");
        Observer userB = new User("小白");
        
        server.registerObserver(userH);
        server.registerObserver(userM);
        server.registerObserver(userB);
        server.setInfomation("苹果", 5);
        
       
        server.removeObserver(userB);
        server.setInfomation("苹果", 6);
        
    }
}