package ex12inheritance;
/*
상속관계에서 오버로딩 vs 오버라이딩
- 오버로딩 : 메서드명은 같으나 매개변수의 개수, 타입, 순서가 다른 경우를
	말한다. 즉, 서로 다른 메서드이므로 상속받은 하위클래스에서는 
	오버로딩된 모든 메서드가 포함된다.
- 오버라이딩 : 메서드명, 매개변수, 반환형까지 모두 동일한 메서드를
	상속관계에 있는 하위클래스에서 재정의 한 것을 말한다.
	이 경우 하위클래스에서 정의한 메서드가 상위클래스의 메서드를
	가리게 되므로, 항상 최하위 클래스의 메서드가 호출된다. 
	즉, 오버라이딩은 참조변수의 타입에 영향을 받지 않는다.
 */
class A {
	public void rideMethod() {
		System.out.println("A의 rideMethod");
	}
	public void loadMethod() {
		System.out.println("A의 loadMethod");
	}
}

class B extends A {
	/*
	rideMethod()는 오버라이딩 처리된 메서드로 상위클래스에 정의된
	반환형, 메서드명, 매개변수의 개수가 모두 동일하다.
	 */
	@Override
	public void rideMethod() {
		System.out.println("B의 rideMethod");
	}
	/*
	loadMethod()는 오버로딩 처리된 메서드로 상위클래스에 정의된
	메서드와 매개변수의 개수, 타입이 서로 다르다.
	 */
	public void loadMethod(int num) {
		System.out.println("B의 loadMethod");
	}
	/*
	따라서 C클래스로 객체를 생성하면 오버라이딩된 메서드는
	모두 가려지게 되므로 C클래스에서 정의된 메서드 하나만 남게된다.
	오버로딩된 메서드는 서로 다르므로 3개 모두 존재하게 된다.
	 */
}

class C extends B {
	@Override
	public void rideMethod() {
		System.out.println("C의 rideMethod");
	}
	public void loadMethod(double num) {
		System.out.println("C의 loadMethod");
	}
}

public class E07RideAndLoad01
{
	public static void main(String[] args)
	{
		/*
		부모타입의 참조변수로 자식객체를 참조할 수 있으므로 아래 문장은
		모두 성립한다.,
		 */
		A ref1 = new C();
		B ref2 = new B();
		C ref3 = new C();
		
		/*
		참조변수에 상관없이 항상 최하위에 오버라이딩된 메서드가 호출된다.
		즉, 아래부분은 모두 C클래스에 성생된 rideMethod() 메서드 호출.
		 */
		System.out.println("오버라이딩 처리된 메소드");
		ref1.rideMethod();
		ref2.rideMethod();
		ref3.rideMethod();
		
		/*
		ref3은 C타입의 참조변수로 해당객체를 C로 간주하고 참조한다.
		따라서 접근범위는 C객체 전체가 되므로 아래의 호출문장은 모두 실행된다.
		 */
		System.out.println("오버로딩 처리된 메소드");
		ref3.loadMethod();
		ref3.loadMethod(1);
		ref3.loadMethod(1.1);
		
		//ref2는 B타입이므로 접근범위가 B까지로 제한된다.
		ref2.loadMethod();
		ref2.loadMethod(1);
		//ref2.loadMethod(1.1); //-> C클래스 영역은 접근 불가
		
		//ref2는 A타입이므로 접근범위가 A까지로 제한된다.
		ref1.loadMethod();
		//ref1.loadMethod(1); // -> B클래스 영역은 접근불가
		//ref1.loadMethod(1.1); //-> C클래스 영역은 접근 불가
		
		
		////////////추가영역 (하위클래스는 상위클래스를 참조할수 없음) 
		
		A refNum1 = new B(); //가능
		A refNum2 = new C(); //가능
		B refNum3 = new C(); //가능
		
		C refAddr1 = new C(); //가능
		B refAddr2 = refAddr1; //가능: B타입이 C타입 참조
		A refAddr3 = refAddr1; //가능: A타입이 C타입 참조
		
		A refId1 = new C(); //가능: A타입이 C타입 참조
		//B refId2 = refId1; //불가능 B타입이 A타입을?? 에러
		//C refId3 = refId1; //불가능 C타입이 A타입을?? 에러
		
		/*
		참조변수 refID1이 C객체를 참조하고 있으므로 C타입이라고 착각할
		수 있으나, A타입으로 선언되었으므로 A타입의 참조변수이다.
		자식으로 부모를 참조하는 것은 불가능하므로 에러가 발생한다.
		
		그러나 위와 같은 에러는 다운캐스팅(강제형변환)으로 참조가 
		가능하다. 클래스가 상속관계에 있을때만 가능하며 부모타입의 
		객체를 자식타입으로 변경한다.
		 */
		
		B refId2 = (B)refId1;
		C refId3 = (C)refId1;
		
		
	
	}
}
