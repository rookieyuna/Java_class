package ex02variable;

/*
반지름이 10인 원의 넓이를 구해 출력하시오.
단, 넓이의 타입을 int, double형 두가지로 선언하여 각각 출력해야한다.
변수명] 
	int형 : area_int
	double형 : area_double
공식]
	원의넓이 = 반지름 * 반지름 * 3.14
 */

public class Qu_02_03 
{

	public static void main(String[] args) 
	{
		int radian = 10;
		final double PI = 3.14;
			
		double area_double = (radian*radian*PI);
		int area_int = (int)(area_double);
		
		System.out.println("int형 넓이:"+area_int);
		System.out.printf("double형 넓이:%.1f", area_double);

	}

}
