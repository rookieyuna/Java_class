package ex03operator;

public class E03BeekyoOperator 
{

	public static void main(String[] args) 
	{
		
		/* 
		비교연산자 : 좌우측항의 값이 크거나, 같은지 비교하는 연산자
		 */
		
		int num1 = 10, num2 = 20;	
		System.out.printf("num1: %d, num2: %d%n", num1, num2);
		
		/*
		num1이 클 때 true를 반환하므로, if 조건은 false를 반환한다.
		따라서 else 블럭이 실행된다.
		 */
		if(num1 > num2) {
			System.out.println("num1이 더 큽니다.");
		}
		else {
			System.out.println("num2가 더 큽니다.");
		}
		
		/*
		num1과 num2가 다를 때 true를 반환하므로, if문의 블럭이 실행된다.
		 */
		if(num1 != num2) {
			System.out.println("num1과 num2는 다르다.");
		}
		else {
			System.out.println("num1과 num2는 같다.");
		}
	}

}
