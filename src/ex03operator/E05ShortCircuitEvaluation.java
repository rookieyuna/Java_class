package ex03operator;

public class E05ShortCircuitEvaluation 
{

	public static void main(String[] args) 
	{
		/*
		SCE (Short Circuit Evaluation)
			: 하나의 조건검사만으로 결과를 알 수 있는 경우 java 컴파일러는
			뒤의 조건을 수행하지 않고 건너뛰게 된다. 이 경우 변수의 값이 
			변경되는 코드가 있다면 실행되지 않으므로 주의해야한다.
		 */
		
		int num1=0, num2=0;
		boolean result;
		
		/*
		논리 AND의 경우 둘 중 하나만 false이면 무조건 false를 반환하므로 
		첫 번째 조건이 false일 경우 두 번째 조건은 검사(실행)하지 않는다.
		 */
		
		result = (num1+= 10)<0 && (num2+=10)>0;
		System.out.println("result="+ result);
		System.out.printf("num1=%d, num2=%d%n", num1, num2);
		
		/*
		논리 OR의 경우 둘 중 하나만 true면 무조건 true를 반환하므로
		첫 번째 조건이 true일 경우 두 번째 조건은 검사(실행)하지 않는다.
		 */
		
		result = (num1+= 10)>0 || (num2+=10)>0;
		System.out.println("result="+ result);
		System.out.printf("num1=%d, num2=%d%n", num1, num2);
		
		/*
		num2는 조건이 있음에도 실행되지 않아 초기값인 0을 그대로 유지
		따라서 주의해야한다.
		 */

	}

}
