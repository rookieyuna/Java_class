package ex12inheritance;
/*
오버라이딩(Overriding)
	:클래스가 상속관계에 있을 때 하위클래스에서 상위클래스의
	멤버메서드와 완전히 동일한 모양으로 재정의 하는 것을 말한다.
	오버로딩과 다른점은 두 메서드의 매개변수의 개수, 반환타입 등이
	완전히 똑같은 형태라는 것이다.
	하위클래스에서 오버라이딩한 메서드는 상위클래스의 메서드를 가리므로
	항상 최하위 클래스에서 오버라이딩한 메서드가 호출된다. 
*/
//일반적인 스피커 추상화
class Speaker {
	private int volumnRate; //볼륨
	//볼륨(private변수)을 외부에서 설정하기 위한 setter메서드
	public void setVolumn(int vol) {  
		volumnRate = vol;
	}
	//상속관계에서 오버라이딩을 목적으로 정의한 메서드
	public void showState() {
		System.out.println("스피커의 볼륨크기:"+volumnRate);
	}
}
//일반적인 스피커 기능에 베이스음 관리확대 스피커 추상화
class BaseSpeaker extends Speaker {
	//베이스 기능 확장
	private int baseRate;
	public void setBase(int bas) {	
		baseRate = bas;
	}
	/*
	@Override: '어노테이션'. 오버라이딩 된 메서드에 추가하여
		컴파일러에게 알려주는 역할을 한다. (java는 이것뿐. C++에는 다양함)
	 */
	@Override
	public void showState() {
		/*
		super를 통해 부모클래스에 정의된 멤버메서드를 호출.
		특히, 오버라이딩 된 메서드를 호출할 때 super가 없으면
		재귀호출이 되어 무한루프가 되므로 반드시 기술!
		 */
		super.showState();
		System.out.println("베이스의 볼륨크기:"+baseRate);
	}
}

public class E06Overriding {

	public static void main(String[] args) {
		
		//하위클래스의 객체 생성
		BaseSpeaker baseSpeaker = new BaseSpeaker();
		baseSpeaker.setVolumn(10);
		baseSpeaker.setBase(20);
		//하위객체로 호출했으므로 하위클래스의 오버라이딩 메서드가 호출됨
		baseSpeaker.showState();
		
		System.out.println();
		
		/*
		부모클래스의 참조변수로 자식클래스의 객체를 참조할 수 있다.
		상속관계가 있으므로 가능하다. 반대로 참조하는 것은 불가능!
		
		부모타입으로 자식객체를 참조하면 접근범위가 부모객체로 제한.
		즉, 자식타입에서 선언된 멤버메서드(setBase())는 호출 불가.
		그러나 오버라이딩된 메서드는 접근 가능하다.
		 */
		Speaker speaker = new BaseSpeaker();
		speaker.setVolumn(30);
		//speaker.setBase(40); //[에러발생]
		speaker.showState();
		
		
	}

}
