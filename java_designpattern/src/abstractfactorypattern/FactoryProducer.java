package abstractfactorypattern;

public class FactoryProducer {
	public static Factory getFactory(String a){
		
		if(a=="学生"){
			return new StudentFactory();
		}
		else if(a=="老师"){
			return new TeacherFactory();
		}
		else{
			return null;
		}	
	}
}
