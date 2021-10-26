package ex05method;

import java.util.Scanner;

public class QuCircleCalculator 
{
/*
문제5-2]원의 반지름을 파라메타로 전달하면 원의넓이와 둘레를 계산하여 
반환하는 메소드를 각각 정의하자. 이를 호출하는 main 메소드를 정의하라.
메소드명 : circleArea() > 원의넓이, circleRound() > 원의둘레
	-넓이공식 : 3.14 * 반지름 * 반지름
	-둘레공식 : 2 * 3.14 * 반지름

	실행결과]
		원의 둘레(5.5) : 34.54
		원의 넓이(5.5) : 94.985
 */
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("반지름입력:");
		double r = scanner.nextDouble();
		
		System.out.println("%n원의 둘레 :" + circleRound(r));
		System.out.println("원의 넓이 :" + circleArea(r));
	}
	
	static double circleRound(double a)
	{
		final double PI = 3.14; 
		double round = 2 * PI * a;
		return round;
	}
	
	static double circleArea(double a) 
	{
		final double PI = 3.14; 
		double area = PI * a * a;
		return area;
	}
	
}
