package miscellaneous;

public class TestInterfaceMethod implements TestInterface {

	public static void main(String[] args) {
		TestInterfaceMethod tim=new TestInterfaceMethod();
		tim.newMethod();
	}
	@Override
	public void newMethod() {
		System.out.println("Run it up");
	}
	

}
