package ex15usefulclass;

class MyClass {
	int data;
	public MyClass(int data) {
		this.data = data;
	}
	/*
	toString() : 실제 저장된 데이터가 반환되도록 Object클래스로부터
		상속받아 오버라이딩한 메서드
	String.valueof(숫자)=> 숫자를 String 형태로 바꿔주는 String 메서드
	 */
	@Override
	public String toString() {
		return String.valueOf(data);
	}
	/*
	MyClass타입 객체 비교를 위해 boolean equals(Object obj) 오버라이딩한 메서드
	객체가 가지고있는 멤버변수의 비교를 통해 동일여 판단.
	 */
	@Override
	public boolean equals(Object obj) {
		/*
		1. 매개변수로 전달된 객체를 Object타입으로 받은 후 MyClass 타입인지
			instanceof 연산자를 통해 파악
		2. 상속관계가 있다고 판단되면 비교를 위해 MyClass타입으로 다운캐스팅
			(Object타입으로 받아서 들어왔으므로 업캐스팅이 되었기 때문)
		3. 만약 객체가 MyClass 타입이 아니면 비교대상이 될 수 없으므로 false반환
		 */
		if(obj instanceof MyClass) { //1
			MyClass mc = (MyClass)obj;//2
			
			if(mc.data == this.data) {//두 MyClass 객체의 멤버변수 값을 비교
				System.out.println("MyClass-멤버 동일함");
				return true;
			}
			else {
				System.out.println("MyClass-멤버 다름");
				return false;
			}
		}
		else {//3
			System.out.println("MyClass 객체아님");
			return false;
		}
	}
}


class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/*
	객체 1,2의 x,y 값을 동시에 비교해서 둘 다 일치할 때 같은 객체로 판단!
	만약 하나의 값만 비교하고 싶다면 조건을 한 개로 수정하면 된다.
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point pos = (Point)obj;
			
			if(this.x==pos.x && this.y==pos.y) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			System.out.println("다른 객체는 비교대상 아님");
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "x="+String.valueOf(x)+", y="+String.valueOf(y);
	}
}


public class E04Object3Equals {

	public static void main(String[] args) {
		
		MyClass mc1 = new MyClass(10);
		MyClass mc2 = new MyClass(10);
		
		System.out.println("[두 객체를 equals()메소드로 비교]");
		
		if(mc1==mc2) {
			System.out.println("인스턴스 참조값(주소값)이 같다");
		}
		else {
			System.out.println("인스턴스 참조값(주소값)이 다르다");			
		} //[0]
		
		System.out.println(mc1.equals(mc2)? "같다":"다르다");//[같다]
		
		/*
		println()은 출력 전 항상 객체의 toString()메서드를 자동으로
		호출하므로 아래 mc1.toString과 mc2의 출력결과는 동일하다
		 */
		System.out.println("[두 객체의 toString() 메소드 호출]");
		System.out.println("mc1.toString()=>"+ mc1.toString());
		System.out.println("mc2.toString()=>"+ mc2);
		
		
		Point pos1 = new Point(10, 20);
		Point pos2 = new Point(10, 30);
		System.out.print("두 점의 비교결과: ");
		//둘 다 Point 객체이므로 비교 가능함
		System.out.println(pos1.equals(pos2)? "같다":"다르다");
		//서로 다른 객체이므로 비교의 대상이 될 수 없음
		System.out.println(pos1.equals(mc1));
		
		
		//아래출력결과는 동일하다.
		System.out.println("pos1.toString()=>"+pos1.toString());
		System.out.println("pos2.toString()=>"+pos2.toString());
		System.out.println(pos1);
		System.out.println(pos2);		
	}
}
