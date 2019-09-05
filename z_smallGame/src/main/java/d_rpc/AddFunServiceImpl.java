package d_rpc;

public class AddFunServiceImpl implements AddFun{


	@Override
	public String add(String h) {
		String[] sum = h.split(" "); 
		int s = Integer.valueOf(sum[0]) + Integer.valueOf(sum[1]);
		return String.valueOf(s);
	}
}
