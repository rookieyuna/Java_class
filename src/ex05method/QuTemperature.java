package ex05method;

import java.util.Scanner;

public class QuTemperature 
{
/*
문제5-3] 섭씨(Celsius)를 입력받아서 화씨(Fahrenheit)로 변환하여 
리턴하는 함수와 화씨를 입력받아서 섭씨로 변환하여 리턴하는 함수를 만들어라.
	공식]
	화씨 = 1.8 * 섭씨 + 32
	섭씨 = (화씨 - 32) / 1.8
 */
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("입력할 온도: 1. 섭씨 2. 화씨");
		int i=scanner.nextInt();
		System.out.print("온도입력: ");
		double degree=scanner.nextInt();
		
		if(i==1)
			System.out.println("화씨로 변환:" + celToFah(degree));
		else
			System.out.println("섭씨로 변환:" +fahToCel(degree));
	}
	
	static double celToFah(double cel)
	{
		double fah = 1.8 * cel + 32;
		return fah;
	}
	
	static double fahToCel(double fah)
	{
		double cel = (fah - 32) / 1.8;
		return cel;
	}

}
