package ex05method;

public class E08RecursiveMethod
{
/*
재귀함수(Recursive Method)
	: 하나의 함수에서 자신을 다시 호출하여 작업을 수행하는 방식으로
	문제를 해결하는 함수를 말한다. 순환호출이라고 표현하기도 한다.
 */
	static int factorial(int number) 
	{
		int result;
		if(number==1)
		{
			result=1;
		}
		else
		{
			result=number*factorial(number-1);
		}
		System.out.println("계산과정:number="+number+", result="+result);
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println("재귀함수를 이용한 팩토리얼 구하기");
		System.out.println("4factorial:"+ factorial(4));
		System.out.println("10factorial:"+ factorial(10));
	}

}
