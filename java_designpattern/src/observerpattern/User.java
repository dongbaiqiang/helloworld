package observerpattern;


/**
 * 观察者
 * 实现了update方法
 * @author jstao
 *
 */
public class User implements Observer {

    private String name;
    private String message;
    private int price; 
    
    public User(String name) {
        this.name = name;
    }
    
    @Override
    public String getname() {
        return name;
    }
    
    @Override
    public void update(String message , int price) {
        this.message = message;
        this.price = price;
        System.out.println(name + " 收到推送消息： " + message + "价格：" + price);
    }
}