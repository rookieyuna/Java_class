package ex16exception;

import java.io.IOException;
/*
예외처리방법2
	: 예외가 발생된 지점에서 예외를 직접 처리한다
	개발시 가장 많이 사용되는 방법이다. try~catch문을 통해
	예외가 발생될 수 있는 지점을 명시적으로 알 수 있다. 
	(if문 사용시 예외발생지점인지 한눈에 이해하기 어려움)
 */
public class Ex03ExceptionCase2
{
	static void compileFunc() {
		/*
		예외가 발생하는 지점을 try로 묶을 때 너무 작은 단위로 묶게되면
		프로그램 가독성이 떨어지므로 적당한 블럭을 정한다. 
		(자동 완성시 예외발생지점만 감싸므로 아주 별로임)
		 */
		try {
			System.out.print("하나의 문자를 입력하세요: ");
			int userChr = System.in.read();
			System.out.println("입력한 문자는: "+(char)userChr);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		compileFunc();
	}
}
