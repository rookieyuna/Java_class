package ex15usefulclass;

/*
Wrapper 클래스
	: 기본자료형의 데이터를 인스턴스화(객체화)할 때 사용하는
	클래스로 Boxing 혹은 Unboxing을 통해 기본자료를 객체화한다.
 */
public class E01WrapperClass1 {

	public static void main(String[] args) {
		
		//1. 일반적인 기본자료형(정수) 연산
		int num1 = 10;
		int num2 = 20;
		int result = num1 + num2;
		System.out.println("result= "+result);
		
		//2. JDK1.4이전 버전에서의 코딩형태
		//기본자료형을 박싱처리한 개체를 산술연산 시 다시 언박싱 진행
		Integer n10Obj= new Integer(10);//현재는 지원하지 않는 생성자로
		Integer n20Obj= new Integer(num2);//디플리케이트 됨(deprecated)
		int result2= n10Obj.intValue() + n20Obj.intValue();
		System.out.println("result2= "+result2);
		
		Integer resultObj = new Integer(result2);
		System.out.println("결과값을 byte형 값으로 변경: "+
				resultObj.byteValue());
		System.out.println("결과값을 이진수로 변경: "+
				Integer.toBinaryString(result2));
		
		//3. JDK1.5 이후 버전에서의 코딩형태
		//오토박싱(언박싱)이 지원되어 개체생성 시 기본자료형 선언처럼 사용
		//Boolean, Character, Integer, Long, Double 등 가능
		Integer numObj1 = 100;
		Integer numObj2 = 200;
		int num3 = numObj1;
		int result3 = numObj1-numObj2;
		System.out.println("오토언박싱 후 연산결과: "+result3);
		
		/*
		Wrapper클래스를 통해 진법변환이나 해당 자료형의 최대/최소값 파악가능
		 */
		System.out.println("int형의 최대값: "+Integer.MAX_VALUE);
		System.out.println("int형의 최소값: "+Integer.MIN_VALUE);
		
		System.out.println("10을 2진수로: "+Integer.toBinaryString(10));
		System.out.println("10을 8진수로: "+Integer.toOctalString(10));
		System.out.println("10을 16진수로: "+Integer.toHexString(10));
		
		/*
		자바의 모든 클래스는 Object클래스를 상속받는다
		그러므로 아래 메소드를 사용할 수 있다.
		
		toString() : 인스턴스 변수를 출력할 때 참조값이 아니라
			실제 저장된 값을 문자열로 반환해주는 메서드
		hashCode() : 객체를 구별하기 위해 참조값을 고유한 정수값으로
			반환해주는 메서드
		 */
		Integer numObj = new Integer(99);
		System.out.println("numObj= "+ numObj);
		System.out.println("numObj.toString()= "+ numObj.toString());
		System.out.println("numObj.hashCode()= "+ numObj.hashCode());
		System.out.println(numObj+1);// 99+1 = 100
		System.out.println(numObj.toString()+1);//"99"+1 = 991
	
		//츄라이
		Integer numObj4 = 30;
		System.out.println("\n==츄라이==");
		System.out.println(numObj4);
		System.out.println(numObj4.MAX_VALUE);
		System.out.println(numObj4.toString()+30);
		System.out.println(numObj4.doubleValue());
		System.out.println(numObj4+numObj1);
		System.out.println(Integer.min(num3, num1));
	}
}
