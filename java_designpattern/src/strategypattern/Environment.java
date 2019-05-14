package strategypattern;

public class Environment {
	private Strategy s;
	public Environment(Strategy s){
		this.s=s;
	}
	public int calculate(int value1 , int value2){
		return s.calc(value1, value2);
	}
}
