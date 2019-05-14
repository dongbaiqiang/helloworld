package observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者，也就是微信公众号服务
 * 实现了Observerable接口，对Observerable接口的三个方法进行了具体实现
 * @author jstao
 *
 */
public class WechatServer implements Observerable {
    
    //注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private List<Observer> list;
    private String name;
    private int price;
    
    public WechatServer() {
        list = new ArrayList<Observer>();
    }
    
    @Override
    public void registerObserver(Observer o) {
        
        list.add(o);
        System.out.println(o.getname() + "订阅成功");
    }
    
    @Override
    public void removeObserver(Observer o) {
        if(!list.isEmpty()){
            list.remove(o);
            System.out.println(o.getname() + "取消订阅");
        }
    }

    //遍历
    @Override
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            list.get(i).update(name,price);
        }
    }
    
    public void setInfomation(String s, int p) {
        this.name = s;
        this.price = p;
        System.out.println(name + "价格为" + p);
        notifyObserver();
    }
}
