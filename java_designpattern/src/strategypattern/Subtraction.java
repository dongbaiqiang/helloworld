package strategypattern;

public class Subtraction implements Strategy{

	@Override
	public int calc(int value1, int value2) {
		return value1 - value2;
	}

}
