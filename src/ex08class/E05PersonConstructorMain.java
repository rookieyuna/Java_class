package ex08class;

public class E05PersonConstructorMain
{

	public static void main(String[] args)
	{
		PersonConstructor person1 = new PersonConstructor();
		
		System.out.println("[멤버변수 초기화용 메소드 호출전]");
		person1.showPersonInfo();
		System.out.println("[멤버변수 초기화용 메소드 호출후]");
		person1.initialize("홍길동", 20, "논현동");
		person1.showPersonInfo();
		
		System.out.println("[이름만 전달한 값으로 초기화하기]");
		PersonConstructor person2 = new PersonConstructor("박길동");
		person2.showPersonInfo();
		
		System.out.println("[이름과 나이만 전달한 값으로 초기화하기]");
		PersonConstructor person3 = new PersonConstructor("최길동",40);
		person3.showPersonInfo();
		
		System.out.println("[모든 매개변수 전달한 값으로 초기화하기]");
		PersonConstructor person4 = new PersonConstructor("박길동",50,"가산동");
		person4.showPersonInfo();
		
	}

}
