package ex05method;

public class E02MethodType01 
{

/*
Method(메서드, 함수)
	:객체지향 프로그램에서 행동 또는 동작을 의미한다.
	즉 어떤 하나의 업무를 처리하는 모듈(부속품)이라 정의할 수 있다.
[규칙]
	-메서드는 반드시 class안에 정의해야한다.
	-메서드 안에 또다른 메서드를 정의할 수 없다.
	-반환타입이 없다면 반드시 void를 명시해야한다.
	-이름의 규칙은 변수명과 동일하다. (Ex: addCalculate())

Java의 Naming Rule (이름 규칙) ex) simple func
	-패키지명: simple.func => 모두 소문자로쓰고 마침표(.)로 단어 연결
	-클래스명: SimpleFunc => 첫글자&연결되는단어 첫글자 대문자 = 카멜 케이스
	-메서드&변수: simpleFunc => 연결단어 첫글자만 대문자 = 변형된 카멜케이스
	-상수: SIMPLE_FUNC => 모두 대문자로 쓰고 언더바(_)로 단어 연결


*/
	
	//반환타입, 매개변수 둘 다 없는 타입의 메서드 정의
	static void noParamNoReturn() {
		System.out.println("==메뉴를 선택하세요==");
		System.out.println("1.열기, 2.계속하기, 3.종료");
		System.out.println("=====================");
	}
	
	
	//필요에 따라 실행부가 없는 메서드를 정의하는 경우가 있다.	
	static void noParamNoReturn2() {
		System.out.println("매개변수 없는애");
	}
	//메서드 이름이 동일해도 매개변수의 개수가 다를경우 다른메서드로 정의
	//이를 "메서드 오버로딩"이라고 한다.
	static void noParamNoReturn2(int a) {
		System.out.println("매개변수 있는애");
	}
	
	static void noParamNoReturn3() {
		int returnValue = 89;
		System.out.println("[Return문 이전]");
		
		//return;=> 에러발생
		/*
		위와 같이 메서드 중간에 return을 쓰면 함수가 즉시 종료되므로
		아래문장은 실행되지 않는 쓰레기 코드가 됨.
		따라서 하위실행문장이 있을 경우 반드시 조건문과 함께 사용!
		단, return이 마지막 라인일 경우에는 상관 없다.
		 */
		
		if(returnValue%2==0) {
			System.out.println(returnValue + "는 짝수");
			return;
		}
		System.out.println(returnValue + "는 홀수");
		System.out.println("[return문 이후]");
	}
	
	public static void main(String[] args) 
	{
		//메서드 호출시에는 메서드의 원형을 그대로 사용하면 된다.
		noParamNoReturn();
		noParamNoReturn2();
		noParamNoReturn3();
	}
}
