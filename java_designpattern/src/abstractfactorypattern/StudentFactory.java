package abstractfactorypattern;

public class StudentFactory implements Factory{

	@Override
	public Pen getpen() {
		return new Gelpen();
	}

	@Override
	public Rubber getRubber() {
		
		return new Whiteout();
	}

}
