package ex12inheritance;
/*
static(정적) 타입의 멤버도 상속이 되고, 하위클래스에서 접근시에는
멤버변수의 이름만으로 접근이 가능한다.
단, 외부클래스에서 접근할 경우 객체생성없이 클래스명으로도
접근할 수 있다. 즉 static이 가진 기본적인 규칙을 따른다.
 */
class Adder {
	public static int val = 0;
	/*
	static으로 선언된 멤버변수는 실제로는 외부(메서드영역)에 생성되어
	있으므로 클래스명을 통한 접근이 허용된다.
	코드레벨에서 보면 해당 클래스의 멤버변수이므로 변수명만으로
	접근하는 것도 가능하다. 즉 둘다 허용된다.
	 */
	public void add(int num) {
		val += num;
		Adder.val += num;
	}
}
//하위클래스의 멤버메소드는 모두 실행가능한 코드
class AdderFriend extends Adder {
	public void friendAdd(int num) {
		val += num; //상속받은인자
		Adder.val += num;//상위클래스명.변수 (static이므로 가능. 권장)
		super.val += num;//상위클래스호출.변수
	}
	public void showVal() {
		System.out.println("val="+val);
		System.out.println("val="+ Adder.val);
	}
}

public class E03StaticInheritance 
{
	public static void main(String[] args) 
	{
		Adder ad = new Adder();
		AdderFriend adFriend = new AdderFriend();
		
		ad.add(1);//상위클래스 메소드 호출
		adFriend.friendAdd(3);//하위클래스 메소드 호출
		Adder.val += 5; //상위클래스 static 변수 호출하여 직접 연산
		AdderFriend.val += 7;//하위가 상속받은 static 변수 호출하여 직접연산
		
		/*
		멤버변수 val은 static이므로 프로그램 시작 시 하나만 생성되어
		메서드영역에 로드된다. 따라서 연산은 누적되어 더해지게 된다.
		*/
		adFriend.showVal(); //출력
	}
}
