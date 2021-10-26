package ex03operator;

public class E04LogicOperator 
{

	public static void main(String[] args) 
	{
		/*
		논리연산자
			&& : 논리 AND. 양쪽 모두가 true 일때만 true 반환.
			 	나머지는 false를 반환하는 연산자
			|| : 논리 OR. 한쪽만 true여도 true를 반환하고,
				양쪽모두 false일 때만 false를 반환하는 연산자
			 ! : 논리 NOT. 반대의 논리를 반환하는 연산자
		 */
		
		int num1=10, num2=20;
		System.out.printf("num1: %d, num2: %d%n", num1, num2);
		
		boolean result1 = (num1==100 && num2==20);
		boolean result2 = (num1<12 || num2>30);
		
		System.out.println("result1의 결과:"+ result1);
		System.out.println("result2의 결과:"+ result2);
		
		// num1과 num2가 다를 때 true를 반환하므로 if문 블럭 실행		
		if(!(num1==num2)) {
			System.out.println("num1과 num2는 다르다");
		}
		else {
			System.out.println("num1과 num2는 같다");
		}
	}

}
