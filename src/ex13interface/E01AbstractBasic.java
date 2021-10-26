package ex13interface;

//추상클래스1: 추상메서드를 포함하지않은 클래스
abstract class AbsClass1 {
	//int형으로 표현할 수 있는 최대값을 반환하는 Wrapper클래스의 상수
	public static final int MAX_INT = Integer.MAX_VALUE;
	
	int  instanceVar;
	static int staticVar;
	
	void instanceMethod() {}
	static void staticMethod() {}
}

class AbsClassChild1 extends AbsClass1 {
	int newVar;
	void newMethod() {}
	/*
	추상메서드를 포함하지않은 추상클래스를 상속하면 오버라이딩은
	강제사항이 아닌 선택사항이다. 즉 필요한경우에만 오버라이딩하자
	 */
	
	@Override
	void instanceMethod()
	{
		System.out.println("필요없다면 오버라이딩 하지않아도 상관 없당");
	}
}

/*
추상클래스2 : 추상메서드를 포함한 클래스
	추상메서드를 멤버로 포함한 클래스는 반드시 abstract로 선언해야
	한다. 그렇지않으면 에러가 발생한다.
 */
abstract class AbsClass2 {
	//추상메서드는 실행부 즉 {}을 쓰지않는다
	abstract void absMethod(int number);
}
/*
위 클래스를 상속하면 부모가 가진 추상메서드를 그대로 상속받게 되므로
해당클래스도 abstract로 선언해야한다. 단, 이경우 해당클래스로도
객체를 생성할 수 없게 된다. 만약 객체를 생성해야한다면 추상메서드를
자식에서 오버라이딩하면된다.
 */
class AbsClassChild2 extends AbsClass2 {
	@Override
	void absMethod(int number)
	{
		System.out.println("부모클래스에서 오버라이딩한 메소드로"
				+ "없을땐 에러발생한당");	
	}
	void newMethod() {
		System.out.println("자식클래스에서 새롭케 확장한 메소드");
	}
}


public class E01AbstractBasic
{
	public static void main(String[] args)
	{
		//추상클래스는 객체를 생성할 수 없다.
		//AbsClass1 absClass1= new AbsClass1();
		
		//추상클래스를 상속한 하위클래스는 객체생성이 가능하다.		
		AbsClassChild1 absClassChild1 = new AbsClassChild1();
		
		/*
		추상클래스로 인스턴스 생성은 할 수없지만, 참조변수로
		사용하는 것은 가능하다.
		 */
		AbsClass2 absClass2 = new AbsClassChild2();
		absClass2.absMethod(100);
		//부모타입으로 자식객체에 접근하려면 다운캐스팅 해야한다.
		((AbsClassChild2)absClass2).newMethod();
		
		/*
		추상클래스내에 선언된 정적멤버메서드는 오버라이딩의 대상이
		아니므로 static의 기본규칙을 따른다. 즉, 클래스명으로 접근하면
		된다.
		 */
		AbsClass1.staticMethod();
		AbsClassChild1.staticMethod();
	}
}
