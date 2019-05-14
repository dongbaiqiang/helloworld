package abstractfactorypattern;

public class TeacherFactory implements Factory{

	@Override
	public Pen getpen() {
		// TODO Auto-generated method stub
		return new Chalk();
	}

	@Override
	public Rubber getRubber() {
		// TODO Auto-generated method stub
		return new Eraser();
	}
	
}
