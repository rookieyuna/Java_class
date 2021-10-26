package ex15usefulclass;

public class E01WrapperClass2 {

	public static void main(String[] args) {
		/*
		Integer.parseInt() : 숫자형식의 "문자열"을 숫자(정수)로 변경한다.
		Double.parseDouble(): 숫자형식의 "문자열"을 숫자(실수)로 변경한다.
		-"문자열"에 숫자가아닌 문자가 있을 경우 변경불가 ->예외발생
		-숫자로된 문자열을 실수로 변경할 때는 parseInt()를 사용불가
		 */
		String strNumber = "1000";
		System.out.println("10+strNumber=" +(10+strNumber));//숫자+문자열
		System.out.println("10+strNumber를 숫자로변경: "+
				(10 + Integer.parseInt(strNumber))); //숫자+숫자
		System.out.println("10+strNumber를 숫자로변경: "+
				(10 + Integer.valueOf(strNumber)));	 //숫자+숫자
		
		String money = "120원";
		//System.out.println("120원: "+Integer.parseInt(money));//예외발생
		
		String floatString = "3.14";
		
		//System.out.println(Integer.parseInt(floatString));//예외발생
		System.out.println("실수형(float)으로 변경: "+
				Float.parseFloat(floatString));		
		System.out.println("실수형(Double)으로 변경: "+
				Double.parseDouble(floatString));
		
		/*
		codePointAt(String, index): 문자열에서 해당 index 문자의 아스키코드값 반환
		 */
		System.out.println("##ABCD에서 Index3(=D)의 아스키코드");
		System.out.println(Character.codePointAt("ABCD", 3));
		
		/*
		isDigit(): 인자로 전달된 것이 숫자일 경우 true 반환		
		 */
		System.out.println("##isDigit()을 통한 숫자판단");
		System.out.println(Character.isDigit('A')? "숫자임":"숫자아님");
		System.out.println(Character.isDigit(50)? "숫자임":"숫자아님");
		System.out.println(Character.isDigit('7')? "숫자임":"숫자아님");
		
		/*
		isLetter(): 인자로 전달된 것이 문자일 경우 true 반환
				단, 특수기호나 숫자일때에는 false반환
		 */
		System.out.println("##isLetter()를 통한 문자판단");
		System.out.println(Character.isLetter('가')); //true
		System.out.println(Character.isLetter('A')); //true
		System.out.println(Character.isLetter('#')); //false
		System.out.println(Character.isLetter('9')); //false
		
		/*
		isWhitespace(): 인자로 전달된 것이 공백일 경우 true 반환
		 */
		System.out.println("##isWhitespace()로 공백문자 판단");
		System.out.println(Character.isWhitespace('A'));
		System.out.println(Character.isWhitespace(' '));
		
		/*
		isLowerCase(): 인자로 전달된 것이 영어 소문자일 경우 true 반환
		isUpperCase(): 인자로 전달된 것이 영어 대문자일 경우 true 반환
		 */
		System.out.println("##isLowerCase()/isUpperCase()로 알파벳 대소문자 판단");
		System.out.println(Character.isLowerCase('A'));
		System.out.println(Character.isUpperCase('z'));
		System.out.println(Character.isLowerCase('a'));//true
		System.out.println(Character.isUpperCase('Z'));//true
		System.out.println(Character.isUpperCase('가'));
		
		
		/*
		[시나리오] 주어진 문자열 안에 몇개의 공백문자(스페이스)가
		있는지 판단하는 프로그램을 작성하시오
			참고) toCharArray(): 문자열을 char형 배열로 반환해주는
			String 클래스에 정의된 메소드
		 */
		
		
		String whiteString = " H E L  L O ";
		int whiteCnt=0;
		char[] chArr = whiteString.toCharArray();
		for(int i=0; i<chArr.length; i++) {
			if(Character.isWhitespace(chArr[i])) {
				whiteCnt++;
			}
		}
		System.out.println("총공백수="+whiteCnt);
		
		
	}	
	
}
