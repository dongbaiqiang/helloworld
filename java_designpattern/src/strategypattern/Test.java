package strategypattern;

public class Test {
	public static void main(String[] arg0){
		Environment e = new Environment(new Division());
		System.out.println(e.calculate(7, 5));
		
		
	}

}
