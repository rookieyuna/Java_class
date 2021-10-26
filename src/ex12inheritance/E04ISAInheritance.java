package ex12inheritance;
/*
Is-A 관계
	: X is a Y => X는 Y의 일종이다로 표현가능
	-노트북은 컴퓨터의 일종이다.
	-휴대폰은 전화기의 일종이다
	이와같이 Is-A 관계가 성립하는 개체를 상속으로 표현하기에 적합하다.
 */

//컴퓨터: 기본적인 컴퓨팅 환경을 제공하여 입력된 내용을 계산한다.
class Computer {
	String owner;
	
	//public Computer() {}
	//생성자를 개발자가 추가하면 디폴트 생성자는 생성되지 않는다.
	public Computer(String name) {
		owner = name;
	}
	/*
	private로 선언된 멤버메서드는 외부에서 접근불가하므로
	public으로 선언된 메서드를 통해 간접 호출
	상속관계라면 protected로 선언된 메소드로 호출
	 */
	private void keyboardTouch() {
		System.out.print("키보드를 통해서 입력한 ");
	}
	private void calculate() {
		System.out.println("요청된 내용을 계산한다");
	}
	public void calculateFunc() {//캡슐화
		keyboardTouch();
		calculate();
	}
}
/*
컴퓨터를 상속한 노트북 컴퓨터
	: 컴퓨터가 가진 기본기능에 휴대성을 확장하여 정의하고 배터리변수 추가
 */
class NotebookComputer extends Computer {
	
	//자식클래스에서 확장한 변수
	int battary; //배터리 충전량
	
	/*
	부모생성자 호출을 위해 사용하는 super()는 생략 가능하지만
	-super() 앞에 다른문장이 먼저오면 오류가 발생되므로 주의
	-부모클래스에 인자생성자를 만든경우 디폴트생성자는 생성되지않으므로
	super()생략할 경우 오류발생
	 */
	public NotebookComputer(String name, int initcharge) {
		super(name);
		battary = initcharge;
	}
	//배터리 충전을 표현한 메서드
	public void charging() {
		battary += 5;
		System.out.println("배터리 5 충전");
	}
	//휴대하면서 컴퓨터하는 것을 표현한 메서드
	public void movigCal() {
		if(battary < 1) { //배터리 잔량 확인
			System.out.println("배터리가 방전되어 사용불가");
			return;
		}
		System.out.println("이동하면서 ");
		
		//private 메서드로 선언한 멤버메서드는 직접호출불가
		//keyboardTouch(); =>에러발생
		//calculate();=>에러발생
		calculateFunc();
		
		battary -= 1;
	}
}

/*
태블릿 노트북 : 컴퓨터의 기본인 계산기능, 휴대이용기능, 여기에
	펜으로 드로잉할 수 있는 기능까지 추가
 */
class TabletNotebook extends NotebookComputer{
	
	//태블릿을 사용하기 위한 펜슬 표현
	String registPencil;
	
	public TabletNotebook(String name, int initCharge, String pen) {
		super(name, initCharge);
		registPencil = pen;
	}
	//태블릿 사용을 위해 배터리양 체크 및 등록된 펜인지 확인
	public void write(String penInfo) {
		if(battary<1) {
			System.out.println("배터리가 방전되어 사용불가");
			return;
		}
		//compareTo: 문자열이 같으면 0을 반환하는 String 클래스 메서드
		if(registPencil.compareTo(penInfo)!=0) {
			System.out.println("등록된 펜이 아닙니다.");
			return;
		}
		movigCal();
		System.out.println("스크린에 펜으로 그림을 그린다.");
		battary -= 1;
	}
}

public class E04ISAInheritance 
{
	public static void main(String[] args) 
	{
		NotebookComputer noteBook = new NotebookComputer("공유", 5);
		TabletNotebook tablet = new TabletNotebook("이동욱", 5, "ISE-1234");
		
		System.out.println("==노트북컴퓨터사용==");
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.charging();
		noteBook.movigCal();
		
		System.out.println("==ISE-1234 펜으로 테블릿 사용==");
		tablet.write("ISE-1234");
		
		System.out.println("==XZY-9876 펜으로 테블릿 사용==");
		tablet.write("XZY-9876");
	}
}
