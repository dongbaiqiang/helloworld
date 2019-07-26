package Rpc.small_rpc;


public class HelloServiceImpl implements HelloService {


   public String hello() {
       return "Hello";
   }


   public String hello(String name) {
       return "Hello," + name;
   }

}

