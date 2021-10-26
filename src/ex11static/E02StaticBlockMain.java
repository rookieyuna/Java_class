package ex11static;

/*
static 블럭
	:동일 클래스안의 main메서드보다 먼저 실행되는 블럭으로
	main메서드의 실행코드가 없어도 먼저 실행된다.
	또한 생성자 메서드보다 static블럭이 먼저 실행된다.
 */
public class E02StaticBlockMain
{
	//인스턴스형 멤버변수 및 메서드
	int instanceVar;
	void instanceMethod() {}
	
	//정적 멤버변수 및 메서드
	static int staticVar;
	static void staticMethod() {
		int localVar;
		System.out.println("정적메소드");
	}

	//static블럭
	static {
		//블럭내에서 정적멤버에 접근가능
		staticVar = 1000;
		
		/*
		블럭내에서만 사용할 수 있는 변수로서, 블럭내에서는 일반적인
		변수를 생성할 수 있다.
		 */
		int localVar; 
		localVar = 1000;
		System.out.println("localVar="+localVar);//사용가능
		
		/*
		static블럭내에서는 인스턴스형 멤버에 접근할 수 없다.
		 */
		//System.out.println("instanceVar="+ instanceVar);
		//instanceMethod();//에러발생
		
		//정적멤버에는 접근할 수 있다.
		System.out.println("staticVar="+ staticVar);
		staticMethod();
		System.out.println("===static block 끝===");	
	}
	
	//생성자메소드
	public E02StaticBlockMain() {
		staticVar = -1;
		System.out.println("==StaticBlock의 생성자==");
	}

	public static void main(String[] args)
	{
		System.out.println("==메인메소드==");
		
		
		//static블럭내에서 선언된 지역변수로 main메서드에서는 사용 불가
		//System.out.println("localVar="+ localVar);
		
		E02StaticBlockMain id = new E02StaticBlockMain();
		System.out.println(E02StaticBlockMain.staticVar);
	}

}
