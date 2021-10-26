package ex02variable;

public class E03CharBooleanType 
{

	public static void main(String[] args) 
	{
		/*
		char형 : 하나의 문자를 저장할 수 있는 자료형으로 값을 저장할 때
		'(single quotation)으로 감싸서 표현한다.
		만약 "(double quotation)으로 감싸면 문자열로 인식하므로 
		String으로 선언해야 한다.
		 */
		
		char ch1 = '가';
		//char chStr = '가나다라'; //문자열로 인식하여 에러발생
		String chStr = "가나다라"; //String으로 선언해야함.
		System.out.println("ch1="+ ch1);
		System.out.println("chStr="+ chStr);
		
		/*
		아스키코드: 1byte로 표현할 수 있는 문자(영문, 숫자)를 십진수로
			정의한 것을 말한다.
			Ex) A=> 65로 표현됨, a=> 97로 표현됨
		유니코드: 1byte로 표현할 수 없는 문자(한글,한자,일본어 등)를 
			2byte로 표현한 것을 말한다. 주로 16진수로 표현한다.
		 */
		
		char ch2 = 'A'; // 아스키코드ㅡ 숫자65로 저장됨
		int num1 = 2;
		int num2 = ch2 + num1; // 65+2=67
		System.out.println("num2="+ num2); //따라서 67 출력됨
		System.out.println("(char)num2="+ (char)num2); // C 출력됨
		
		char ch3 = (char)(ch2+num1); 
		//ch2+num1는 char+int이므로 int로 인식됨 => (char)을 통해 문자형변환
		System.out.println("ch3(문자출력)=>"+ ch3);
		System.out.println("ch3(아스키코드출력)=>"+ (int)ch3);
		
		char ch4 = '1'; // 숫자가 아니라 문자 1이므로 49로 저장
		char ch4_1 = '1' + 1; //문자 1과 숫자 1을 더하는 것
		System.out.println("ch4="+ ch4
				+", ch4_1="+ ch4_1
				+", ch4_1="+ (int)ch4_1);
		
		/*
		boolean형: true 혹은 false 두 가지의 값만 가질 수 있는 자료형으로
			산술연산 (+,-)이나 비교연산 (<,=, >=)에서는 사용할 수 없고,
			논리연산(&&, ||)에서 사용할 수 있다.
		 */
		
		boolean bn1 = true;
		boolean bn2 = false;
		System.out.println("bn1="+ bn1 +", bn2="+ bn2);
		
		/*
		&&(논리And) : 엠퍼센트. 양쪽 모두 참일 때만 참을 반환하는 연산자.
			그 외에는 모두 거짓을 반환한다.		
		||(논리Or) : 파이프. 둘 중 하나만 참이어도 참을 반환하는 연산자.
			둘 다 거짓일 때만 거짓을 반환한다.
		 */
		
		boolean bn3 = bn1 && bn2;
		System.out.println("bn3(and)="+ bn3);
		bn3 = bn1 || bn2;
		System.out.println("bn3(or)="+ bn3);
		
		bn3 = '가' > 30000; //'가'는 유니코드 44032므로 true
		//bn3 = '가' //bn3는 boolean으로 선언되었으므로 다른자료형 사용불가
		System.out.println("bn3="+ bn3);
		
		
		//문자자료형 연산 연습
		
		char ch5='A';
		int num5=2;
		int new1=ch5+num5;
		System.out.println((char)new1);
		
		char ch8 = '1';
		char ch9 = 1;
		int ch10 = ch8 + ch9;
		System.out.println(ch8+ch9);
		System.out.println((char)ch8+ch9);
		System.out.println((char)ch10);
				
		
		}

}
