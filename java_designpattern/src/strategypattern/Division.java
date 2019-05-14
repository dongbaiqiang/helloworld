package strategypattern;

public class Division implements Strategy{

	@Override
	public int calc(int value1, int value2) {
		// TODO Auto-generated method stub
		return value1 / value2;
	}

}
