package ex12inheritance;
/*
상속(Inheritance)
	: 기존에 정의된 클래스에 메서드와 변수를 추가하여 새로운 클래스를
	정의하는 것을 말한다. 부모(상위)클래스를 자식(하위)클래스가 
	상속할 때 extends 키워드를 사용한다.
	ex)	상위= class Man {}
	 	하위= class BusinessMan extends Man {}
 */

//부모클래스(상위클래스) : 사람의 일반적인 형태를 추상화
class Man {
	private String name; //private로 선언되어 클래스내에서만 접근가능
	
	//생성자는 오버로딩으로 2개 정의함
	public Man() {
		System.out.println("Man클래스 디폴트 생성자 호출");
	}
	public Man(String name) {
		this.name =name;
		System.out.println("Man클래스 인자 생성자 호출");
	}
	public void tellYourName() {
		System.out.println("내 이름은 "+ name +"입니다.");
	}
}
//자식클래스(하위클래스) : Man클래스를 상속받아 회사원을 표현
class BusinessMan extends Man {
		
	private String company;
	private String position;
	
	public BusinessMan(String name, String company, String position ) {
		/*
		super : 부모클래스의 변수/메서드를 호출하는 역할
		-자식클래스는 부모클래스의 생성자를 호출하여 객체가 생성되도록 함
		-아래는 super(name)이므로 인자생성자를 호출하며 만약 이를 
		기술하지 않으면 디폴트 생성자가 호출된다.
		(그러나, 인자생성자만 만든 경우 디폴트생성자가 없어 오류 발생) 
		 */
		super(name); 
		//★만약 상위클래스의 name이 protected로 선언되었다면 
		//super.name = name; 으로도 초기화 가능한 것 확인!!
		this.company = company;
		this.position = position;
		System.out.println("BusinessMan 생성자 호출");
	}
	
	public void tellYourInfo() {
		System.out.println("회사명은 "+ company +"입니다.");
		System.out.println("직급은 "+ position +"입니다.");
		/*
		부모쪽의 멤버변수 name이 private로 선언되어 자식도 접근불가
		private는 무조건 자신의 클래스 내에서만 접근할 수 있다.
		 */
		//System.out.println("이름은 "+ name +"입니다."); //[접근불가에러]
		tellYourName();
	}
}

public class E01BusinessManMain 
{
	public static void main(String[] args) 
	{
		BusinessMan man1 = new BusinessMan("김천국", "naver", "팀장");
		BusinessMan man2 = new BusinessMan("이낙원", "daum", "부장");
		
		man1.tellYourInfo();
		man1.tellYourName();
		
		man2.tellYourInfo();
		man2.tellYourName();
		
		
		
		
	}
}
