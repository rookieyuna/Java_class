package ex08class;

/*
추상화: 현실세계의 사물을 클래스로 형상화 하는 것을 추상화라고 한다.
	person 클래스는 "사람"의 일반적인 사항을 추상화하고 있다.
 */
class Person
{
	/*
	멤버변수 : 클래스에서 주로 데이터(속성)을 표현한다.
	 */
	String name = "정우성";
	int age = 47;
	String gender = "남자";
	String job = "영화배우";
	
	/*
	멤버메소드 : 클래스에서 객체의 동작(행위)를 표현한다.
		클래스 외부에서 호출할 때는 객체의 참조변수를 통해서 호출한다.
		
		멤버변수는 멤버메서드 내에서 즉시 사용 가능하다.
	 */
	void eat() {
		System.out.printf("%s이(가) 식사를 한다.\n", name);
	}
	void sleep() {
		System.out.printf("나이가 %d인 %s이(가) 잔다.\n", age, name);
	}
}
public class E01PersonMain 
{
	public static void main(String[] args) 
	{
		/*
		Person클래스를 통해 객체(인스턴스)를 생성한다.
		생성 시 할당된 주소값을 반환한다.
		 */
		Person person = new Person();
		
		//객체의 참조변수(person)를 통해 멤버메서드를 호출할 수 있다.
		person.eat();
		person.sleep();
		
		//객체 생성 후 참조변수에 저장하지않고 즉시 멤버메서드 호출 가능
		new Person().eat();
		new Person().sleep();

		
	}
}
