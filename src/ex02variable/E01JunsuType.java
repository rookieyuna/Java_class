package ex02variable;

public class E01JunsuType 
{

	public static void main(String[] args) 
	{
		/*
		[정수자료형]
		-byte, short, int, long 타입(형)이 있다.
		-각 자료형의 표현범위는 교안을 참조한다(외울필요없음)
		-일반적으로 CPU(중앙처리장치)는 정수형 연산을 할 때 int형을
			가장 빠르게 처리한다.
		-즉, 정수형 변수를 쓸 때는 거의 대부분 int 형을 사용한다.
		 */
		
		int int1 = 100;
		int int2 = 200;
		int result1 = int1 + int2; // 100 + 200
		System.out.println("int1 + int2 = "+ result1); // 결과: 300
		
		/*
		정수와 정수를 연산하면 정수의 결과가 나온다.
		/ 연산자는 두 수를 나눠서 몫을 구하는 연산자
		% 연산자는 두 수를 나눠서 나머지를 구하는 연산자
		 */
		
		result1 = int1 / int2;
		System.out.println("int1 / int2 ="+ result1);
		
		/*
		-int형보다 작은 자료형(byte, short)을 연산하면 컴파일러는
		int형으로 자동으로 변환하여 연산한다.
		-CPU가 int형의 연산에 최적화 되어있기 때문
		-byte, short형은 게임캐릭터 움직임이나 음원정보등을 표현 시 사용
		*/
		
		byte byte1 =50, byte2 = 55;
		int result2 = byte1 + byte2; // byte + byte = int 결과 출력
		System.out.println("byte1 + byte2 ="+ result2);
		
		short short1 = 60, short2 = 70;
		int result3 = short1 + short2; // short로 선언시 오류 발생
		System.out.println("short1 + short2 ="+ result3);
				
		/*
		-동일자료형끼리의 연산은 동일자료형이 되는 것이 기본원칙
		-하지만 큰 자료형과 작은 자료형을 연산하면 큰 자료형으로 자동변환
		(이유는 데이터 손실을 막기 위해)
		-단, bite형과 short형은 예외적인 상황으로 생각하면 된다.
		 */
		
		long long1 = 1000, long2 = 2000;
		long result4 = int1 + long1; // int + long => long
		System.out.println("int1 + long1 ="+ result4);
		
		//long 끼리의 연산은 기본규칙을 따른다.		
		result4 = long1 + long2;
		System.out.println("long1 + long2 ="+ result4);
		
		/*
		자바컴파일러는 정수형 상수를 기본적으로 int형으로 간주하기 때문에
		위 정수를 메모리에 올리는 순간 에러가 발생한다.
		이때는 literal 접미사 L or l을 붙여서 int형 자료가 아닌 long형 
		자료임을 알려줘야한다.
		이와같이 대입을 위해 입력되는 숫자도 자료형을 기반으로 메모리에
		저장되고, 이를 '리터럴'이라고 한다.
		 */
		
		//long long3 = 2200000000; => 에러발생되는 변수
		long long4 = 2200000000L; //접미사를 붙여야만
		long long5 = 2200000000l; //에러가 발생하지 않음.
		
		System.out.println("long4 = "+ long4);
		System.out.println("long5 = "+ long5);

	}

}
