package ex02variable;

public class E05ConstantVar 
{

	public static void main(String[] args) 
	{
		
		/*
		상수 : 저장된 값이 변하지 않는 메모리의 종류
			선언방법 : final 자료형 상수명 = 초기값;
			
		-상수는 딱 한번만 초기화되고 중간에 값을 변경하면 에러 발생
		-선언시 전체를 대문자로 선언하고, 연결되는 단어가 있는 
		경우 _(언더바)를 사용한다
		-주로 프로그램에서의 코드 가독성을 높여주기 위해 활용된다
		 */
		
		final double PI = 3.14; //상수 PI 선언 및 초기화
		System.out.println("PI(원주율)="+ PI);
		
		//PI = 3.141592; -> 에러발생. 상수는 한번 초기화하면 변경 불가
		
		final String NICK_NAME;
		//System.out.println("우리는 " + NICK_NAME);
		//-> 에러발생. 상수는 초기화되지 않은 상태에서 사용할 수 없음
		NICK_NAME = "코스모";
		System.out.println("우리는 " + NICK_NAME);
		
		/*
		가위 바위 보 게임을 제작하기 위해 개발자는 아래와 같이 설정하였다.
		가위:1, 바위:2, 보:3
		 */
				
		final int SCISSOR = 1;
		final int ROCK = 2;
		final int PAPER = 3;
		
		int computer, user;
		/*
		1과 3은 개발자 본인만 알 수 있는 내용이므로, 가독성이 떨어지는
		코드로 작성되었다. 만약 다른 개발자가 해당 코드를 본다면 확인절차를
		거쳐야 할 것이다.
		 */
		computer = 1;
		user = 3;
		System.out.println("컴퓨터가 이겼습니다.");
		
		/*
		PAPER와 같은 단어는 누가 보더라도 이해할 수 있으므로, 가독성이
		높은 명시적인 코드가 되었다. 
		 */
		
		computer = SCISSOR;
		user = PAPER;
		System.out.println("Computer Win");
		
		
	}

}
