package ex03operator;

public class E01ArithOperator 
{

	public static void main(String[] args) 
	{
	
		/* 
		산술연산자 : 사칙연산에 관련된 +,- 등의 연산자가 있다.
		단, 나누기를 할 때는 /는 몫을, %는 나머지를 구하는 연산자이다.
		 */
		
		int num1 = 7;
		int num2 = 3;
		double num3 = 7;
		double num4 = 3;
		
		System.out.println("덧셈:"+(num1+num2));//10
		System.out.println("뺄셈:"+(num1-num2));//4
		System.out.println("곱셈:"+(num1*num2));//21
		System.out.println("int나눗셈(몫):"+(num1/num2));//2
		System.out.println("int나눗셈(나머지):"+(num1%num2));//1
		
		System.out.println("double나눗셈(몫):"+(num3/num4));//2
		System.out.println("double나눗셈(나머지):"+(num3%num4));//1
		
		
		int result = 3 * 2 + 5 % 2 - 6 / 3 * 5;
		System.out.println("결과는? "+ result);
		
		
		

	}

}
