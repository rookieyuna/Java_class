package ex02variable;

public class E07TypeCasting 
{

	public static void main(String[] args) 
	{
		/*
		자동형변환 : 작은 상자의 데이터를 큰 상자에 대입할 때 자동으로
			형변환이 일어난다.
		 */
				
		byte b1 = 65;
		short s1;
		s1 = b1; // byte형이 short형보다 작으므로 자동형변환 발생
		System.out.printf("b1은 %d, s1은 %d%n", b1, s1);
		
		/*
		아래코드는 technically 자동형변환이 아님.
		CPU는 int 보다 작은자료형을 int로 간주하고 연산을 진행한 후 결과도
		int로 반환. CPU의 특성이라 생각하면된다.
		 */
		
		int num1 = b1 + s1;
		System.out.println("num1은 " + num1);
		
		/*
		char형에 byte형을 바로 대입할 수 없다.
		성질이 다르므로 명시적 형변환 후 대입해야 한다.
		 */
		//char ch1 = b1; //에러발생
		char ch2 = (char)b1;
		System.out.println("b1= "+ b1 +", ch2= "+ ch2);
		
		/*
		명시적 형변환: 큰 상자의 자료를 작은상자의 자료형에 할당해야할 때, 
			사용한다. 단, 자료의 손실이 있을 수 있으므로 필요한 경우에만 
			사용해야 한다.
		 */
		
		short s2 = 100;
		byte b2 = (byte)s2;
		System.out.printf("데이터미손실:b2=%d, s2=%d%n", b2, s2);
		
		/*
		소수점 아래부분이 버려지므로 데이터 손실이 있는 경우임.
		따라서 특수한 경우가 아니라면 사용에 주의해야 함
		 */
		int num3;
		double dl = 3.14;
		num3 = (int)dl;
		System.out.printf("데이터손실:num3=%d, dl=%.2f %n", num3, dl);
		
		/*
		서식문자 사용시 %.2f : 정수부는 모두 표현하고 소수이하 2자리까지 표현
		 */
		
		char ch3 = 'A', ch4;
		int num4 = 2;
		
		/*
		 char와 int를 연산하면 결과는 int형이므로 char형 변수에 결과를
		 대입하려면 반드시 명시적 형변환을 한 후 진행해야한다.
		 (예시)char와 int의 연산은 int로 변환->char인 ch4에 대입불가
		 */
		//ch4 = ch3 + num4; //에러발생
		ch4 = (char)(ch3 + num4);
		System.out.println("ch4="+ ch4);
				
	}

}
