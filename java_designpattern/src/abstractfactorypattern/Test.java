package abstractfactorypattern;

public class Test {

	public static void main(String[] args) {
		System.out.println("老师申请得到工厂类型");
		Factory factory = FactoryProducer.getFactory("老师");
		System.out.println("老师得到工厂后创建工具");
		factory.getpen().fun();
		factory.getRubber().fun();
		
		System.out.println("学生申请得到工厂类型");
		Factory factory2 = FactoryProducer.getFactory("学生");
		System.out.println("学生得到工厂后创建工具");
		factory2.getpen().fun();
		factory2.getRubber().fun();
	}

}
