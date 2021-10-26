package ex12inheritance;

public class E07RideAndLoad02
{

	public static void main(String[] args)
	{
		/*
		자식참조변수로 자식객체를 참조하는 가장 일반적인 형식
		 */
		System.out.println("Child형 참조변수로 Child객체 참조");
		DeChild child = new DeChild("율곡이이", 49, "00학번");
		/*
		오버라이딩 처리된 메서드이므로 참조변수에 상관없이
		무조건 자식쪽 메서드가 호출된다.
		 */
		child.exercise();
		child.sleep();
		child.printParent();
		
		child.study(); //자식에서 확장한 메서드(부모에는 없음)
		child.walk();	//부모 메서드
		child.walk(25); //자식에서 확장한 오버로딩 메서드
		/*
		정적메서드는 클래스명을 통해 호출한다. static의 기본규칙을 따르므로
		오버라이딩의 대상이 될 수 없다.
		 */
		DeChild.staticMethod();
		
		/////////////////////////////////////////
		/*
		부모타입의 참조변수로 자식객체를 참조. 상속관계가 있어서 가능.
		 */
		System.out.println("Parent형 참조변수로 Child객체 참조");
		DeParent parent = new DeChild("퇴계이황", 30, "98학번");
		
		/*
		오버라이딩 처리된 메서드이므로 참조변수에 상관없이
		무조건 자식쪽 메서드가 호출된다. (위 child와 동일)
		 */
		parent.exercise();
		parent.sleep();
		parent.printParent();
		
		//parent.study(); //자식에서 확장한 메서드이므로 접근 불가
		parent.walk();
		//parent.walk(25);//자식쪽에 정의된 오버로딩 메서드이므로 접근불가
		
		
		DeParent.staticMethod();
		

	}

}
