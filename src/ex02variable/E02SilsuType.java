package ex02variable;

public class E02SilsuType 
{

	public static void main(String[] args) 
	{
		/*
		[실수자료형]
		-정수형보다는 실수형이 더 큰 자료형이다.
		(0과1사이에 무수이 많은 실수가 존재하기 때문)
		-따라서 long과 float를 연산하면 결과는 float로 자동형변환 된다.
		 */
		
		long long1 = 100;
		float float1 = 200;
		float result1 = long1 + float1;
		System.out.println("long1 + float1 = "+ result1);
		
		/*
		float와 long 연산 결과를 long으로 받고싶다면..
		-방법1 : float를 long으로 형 변환 후 연산하거나
		-방법2 : 계산결과 전체를 long형으로 강제(명시적)형변환 한다.
		 */
				
		long result2 = long1 + (long)float1;
		System.out.println("형변환후 연산="+result2);
		long result3 = (long)(long1 + float1);
		System.out.println("계산후 형변환="+result3);
		
		/*
		-실수형에서 기본형은  double이다.
		-소수점이 있는 데이터를 컴파일러는 무조건 double로 인식한다.
		-단, 소수점이 없는 데이터는 float에 대입할 수 있다.
		-소수점이 있는 데이터를 float에 대입하려면 접미사 f/F를 입력
		-형변환도 가능하지만 Java에서는 권장하지 않는다. 공간차지함..
		 */
		
		float f3 = 100;
		
		//float f4 = 3.14; => 3.14를 double로 인식하여 오류 발생
		float f4 = (float)3.14; // 강제형변환 후 대입 가능(권장 안함)
		System.out.println("f4="+ f4);
		
		float f5 = 3.14F; // 접미사 f를 통해 float 자료임을 표현(권장)
		System.out.println("f5="+ f5);
		
		float f6 = f3 + f4;
		System.out.println("f6="+ f6);
		
		double d1 = 3.14;
		double d2 = f6 + d1; // float+double=double(큰쪽을 따라감)
		System.out.println("d2="+ d2); //d2=106.27999938..
		
		/*
		CPU 는 실수 계산에 있어 기본적인 오차를 가지고 있다.
		이는 JAVA만의 문제가 아니라 컴퓨터 자체의 문제이므로
		정확한 계산을 위해서는 약간의 보정을 필요로한다.
		->실수를 완벽하게 표현할 수 없는 컴퓨터의 한계..
		 */
	
	}

}
