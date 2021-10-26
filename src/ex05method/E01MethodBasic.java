package ex05method;

import java.util.Scanner;

/*
메서드의 규칙
-Java에서는 main 메서드는 무조건 public static void로 선언하기로 약속됨
-static으로 선언된 메서드는 static으로 선언된 메서드만 호출 가능
-메서드 호출 후 반환값은 항상 호출한 위치로 반환. 
	(이때 메서드는 메모리에서 소멸)
-반환값이 없는 void 형 메서드도 실행이 완료되면 호출한 위치로 돌아온다.
*/

public class E01MethodBasic 
{
	/*
	메서드 정의1 : 반환형 O(int타입), 매개변수 O 형태
		=> 두개의 정수를 전달 받아 합의 결과를 int로 반환하는 메서드
	 */
	public static int simpleFunc(int a, int b) {
		int sum = a + b;
		return sum; //결과값을 호출한 지점으로 반환한다.
	}
	
	/*
	메서드 정의2 : 반환형 X(void), 매개변수 X 형태
		=> 전달되는 값 없이 이름을 입력받은 후 namePrint()메서드를
		호출한다.
	 */
	public static void menuPrint() {
		System.out.println("당신의 이름은 무엇인가요?");
		Scanner scanner = new Scanner(System.in);
		//문자열을 입력받는다. 입력받은 값은 name에 저장됨
		String name = scanner.nextLine();
		
		//여기서 namePrint() 호출하는데 입력받은 name값을 전달
		namePrint(name);
	}
	
	/*
	메서드 정의3 : 반환형 X(void), 매개변수 O 형태
		=> 매개변수 값을 받아 메서드 실행 후 반환값이 없기때문에
		실행이 종료되면 호출했던 지점으로 다시 돌아간다.
	 */
	public static void namePrint(String n) {
		System.out.println("제 이름은 " + n + "입니다.");
	}
	
	/*
	메서드를 호출할 때는 함수의 원형을 그대로 기술하면 된다.
	매개변수가 있다면 해당 개수만큼 포함하면 된다. 
	매개변수의 개수가 다르거나 타입이 맞지 않는 경우 
	호출되지 않고 에러가 발생한다.
	 */
	public static void main(String[] args) 
	{
		int result = simpleFunc(1, 2);
		System.out.println("1과2를 전달한 결과"+result);
		System.out.println("10과20을 전달한 결과"+ simpleFunc(10,20));
		
		menuPrint();
		
		/*
		Java에서 main()메서드의 끝을 만나면 프로그램 자체가 종료된다.
		*/
	}

}
