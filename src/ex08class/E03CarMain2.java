package ex08class;

class Car {

	String carModel;//모델명
	Human owner; //Human 타입, 소유주를 표현한 객체형 멤버변수(필드)
	
	/*
	초기화 메서드1: 매개변수가 없는 형태로 항상 고정된 값으로만
		객체를 초기화 할 수 있다. 확장성이 없어 잘 쓰이진 않는다.
	 */
	void initialize() {
		carModel = "람보르기니";
		owner = new Human();
		owner.name = "스티브로져스";
		owner.age = 30;
		owner.energy = 10;
	}	
	/*
	초기화메서드2 : 매개변수가 있는 형태로 호출시 다른 값을 전달함으로써
		확장이 용이한 메서드이다
		
		Car클래스이 멤버변수로  Human클래스를 가지고 있으므로
		초기화메서드 내에서 Human 객체를 생성한 후 초기화해야한다.
	 */
	void initialize(String model, String name, int age, int energy) {
		carModel = model;
		
		owner = new Human();
		owner.name = name;
		owner.age = age;
		owner.energy = energy;
	}	
	void drive() {		
		System.out.println(owner.name +"이(가) "+ carModel +"을 운전한다.");
	}
	void showCarInfo() {
		System.out.println("[차량정보]");
		System.out.printf("모델명:%s\n", carModel);
		owner.showState();
	}
}////end of Car Class

public class E03CarMain2 {

	public static void main(String[] args) {
		 
		//자동차1 객체 생성
		/*
		매개변수가 없는 초기화메서드를 호출해서 초기화 하므로
		항상 동일한 값으로 초기된다. 확장성이 없기 때문에 실무에서는 사용안함
		 */
		Car car1 = new Car();
		car1.initialize();  
		car1.showCarInfo();

		//자동차2 객체 생성
		/*
		객체생성 후 멤버변수에 직접 접근하여 초기화한다. 만약 2개 이상의
		객체를 생성해야 한다면 아래의 초기화 코드를 중복사용해야하므로
		이와 같은 방법은 사용하지 않는 것이 좋다.
		 */
		Car car2 = new Car();
		car2.carModel = "밴틀리";
		car2.owner = new Human();
		car2.owner.name = "토니스타크";
		car2.owner.age = 52;
		car2.owner.energy = 8;		
		car2.showCarInfo();

		//자동차3 객체 생성
		/*
		매개변수가 있는 초기화 메서드를 이용하므로 확장도 용이하고 코드가
		훨씬 짧고 간결해졌다.
		 */
		Car car3 = new Car(); 
		car3.initialize("스포츠카", "성유겸", 8, 10);
		car3.showCarInfo(); 
		
		//자동차4 객체 생성
		/*
		Car 객체를 생성하면 멤버변수인  Human 참조변수만 먼저 생성되고
		Human 객체의 생성을 위해 new Human()이 필요하다.
		아래의 경우 Human객체가 없는 상태에서 호출이 되고 있으므로 
		NullPointerException이 발생하게 된다.
		 */
		Car car4 = new Car();
		car4.showCarInfo();
	}
}