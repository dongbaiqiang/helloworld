package c_myServer;

public enum Type {
	ECHO(0),
	ADD(1),
	REGISTER(1000),
	SIGNIN(1001),
	SIGNOUT(1002),
	TALK(2001),
	ADDFRIENT(2002),
	DELETEFRIENT(2003),
	;

	private int value;
	
	Type(int v){
		this.value = v;
	}
	
	public int getValue(){
		return value;
	}
}
