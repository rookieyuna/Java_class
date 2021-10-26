package ex08class;

/*
생성자(Constructor)
-클래스를 객체화(인스턴스)할 때 자동으로 호출되는 메서드
-자동으로 호출되며 개발자가 임의로 호출할 수 없다.
-반환 값이 없다. 즉 특정 연산 후 값을 반환할 수 없다. void 등 타입 사용불가
-그 외는 메서드가 가진 모든 특성을 가진다 (인자전달,오버로딩 등)
 */

public class PersonConstructor
{
	String name;
	int age;
	String addr;
	
	/*
	디폴트 생성자 : 해당 클래스에 생성자를 정의하지 않으면 아래와 같이
		매개변수. 실행부가 없는 생성자가 자동으로 삽입된다.
	 */
	//public PersonConstructor() {} 
	
	//생성자1 : 디폴트생성자와 같이 매개변수가 없는 형태로 정의함
	public PersonConstructor() {
		name = "이름없음";
		age = 0;
		addr = "미상";
		System.out.println("나는 생성자1 입니다.");
	}
	
	//인자생성자1
	public PersonConstructor(String name) {
		/*
		this는 현재 클래스를 지칭함.
		멤버변수와 매개변수를 구분하기 위한 용도 //멤버변수 = 매개변수;
		 */
		this.name = name;
		age = 1;
		addr = "출처불명";
		System.out.println("나는 인자생성자[1] 입니다");
	}
	
	//인자생성자2
	public PersonConstructor(String name, int age) {
		/*
		this()는 생성자 내에서 다른 생성자를 호출할 때 사용한다.
		단, 생성자 내에서만 사용할 수 있고, 일반메서드에서는 불가능하다.
		 */
		this(name, age, "미상");
		System.out.println("나는 인자생성자[2] 입니다");
	}
	
	//인자생성자3
	public PersonConstructor(String _name, int age, String addr) {
		//멤버변수와 매개변수명이 다르면 this를 쓰지 않아도 된다.
		name = _name;
		//둘의 변수명이 동일한 경우에는 this를 쓰도록 권고하고있다.
		this.age = age;
		this .addr = addr;
		System.out.println("나는 인자생성자[3] 입니다");
	}
	
	//초기화를 담당하는 멤버메서드
	void initialize(String name, int age, String addr) {
		//this(name, age, "미상;") => 에러발생,this()는 생성자내에서만 사용가능
		
		//단, 멤버변수 구분을 위한 this는 멤버메서드에서도 사용 가능
		this.name = name;
		this.age = age;
		this .addr = addr;
	}
	void showPersonInfo() {
		System.out.printf("%s 님의 정보 \n", this.name);
		System.out.printf("나이:%d\n", age);
		System.out.printf("주소:%s\n", addr);
	}
}
