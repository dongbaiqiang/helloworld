package d_rpc;

public class RpcServer {
	public static void main(String[] rag) throws Exception{
		System.out.println("rpc启动成功");
		AddFun fun = new AddFunServiceImpl();
        MyProxy.export(fun, AddFun.class, 9000);
	}
}
