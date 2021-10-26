package ex01start;

public class E02SystemOutPrintln 
{
	/*
	System.out.println
		: 내용을 출력한 후 자동으로 줄바꿈 처리한다.
	System.out.print
		: 출력 후 줄바꿈 처리를 하지 않는다. 필요시 /n 추가
	System.out.printf
		: 출력내용을 서식에 맞춰 출력한다. 또한 자체적인 줄바꿈이
		없으므로 /n 혹은 %n을 이용해서 줄바꿈 처리한다
		서식문자에는 %d, %f 등이 있다. (%n 은 printf에서만 가능)
	 */
	public static void main(String[] args) 
	{
		//정수형 변수를 선언한 후 100으로 초기화한다.
		int num1 = 100;
		
		//문자열과 변수를 출력한다.
		System.out.println("num1="+ num1);
		System.out.print("num1="+ num1 +"\n");
		System.out.printf("num1=%d%n", num1);
		
		//정수, 실수를 단순히 출력한다.
		System.out.println(7);
		System.out.println(3.14);
		System.out.println(7 + 3.14);
		
		/*
		Print()문에서의 + 기호의 역할
		-숫자끼리는 실제 덧셈 연산을 한다.
		-문자열, 숫자, 변수 등 서로 성격이 다른 데이터끼리는
		단순 연결만해서 출력한다.
		 */
		
		
		//숫자와 숫자로 인식하여 실제 덧셈연산의 결과를 출력한다.
		System.out.println(3 + 5); //8
		System.out.println(3.5 + 5.1); //8.6
		
		//숫자와 문자열 혹은 문자열과 문자열을 단순 연결하여 출력한다.
		System.out.println("3+5="+ 8);
		System.out.println(3.15 +"는 실수입니다.");
		System.out.println("3+5" + "의 연산결과는 8입니다.");
		
		//정수형으로 선언한 변수를 이용해서 출력한다.
		System.out.println("num1 은 "+ num1 +" 입니다.");

	}

}
