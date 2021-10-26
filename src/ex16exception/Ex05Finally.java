package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
finally절
	:예외발생과 상관없이 try문에 진입했을 때 반드시 실행해야 할
	코드가 있는 경우 기술하는 블럭이다. 
	즉, try문으로 진입하지 않는다면 finally절은 실행되지 않는다.
 */
public class Ex05Finally
{
	/*
	런타임(runtime)예외가 발생되는 메소드
	예외발생 시 무시하기 위해 throws 하고 있다. 하지만 이와 같은 예외는
	어디서든 반드시 예외처리 되어야 한다.
	 */
	static void runtime() throws NumberFormatException {
		Integer.parseInt("백");
	}
	
	static void tryCatchFinally() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("나이를 입력하세요:");
		int age =  Integer.MAX_VALUE;
		try {
			age = scan.nextInt();// "30살"입력시 예외발생
			System.out.println("당신은 5년 후 "+(age+5)+"살 입니다.");
			return;
		}
		
		catch(InputMismatchException e){
			System.out.println("나이는 숫자만 쓰세오");
		}
		
		finally {
			/*
			try문 진입 후 예외발생 여부와 상관 없이 반드시 실행
			try문에서 return을 만나게 되더라도 상관 없이 실행된다.
			 */
			System.out.println("try진입시 반드시 실행되는 finally절!!");
			
			//프로그램 자체가 종료된다. 호출지점으로 넘어가지 않고 terminate 됨
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		
		/*
		만약 runtime()을 호출한 이지점에서도 try~catch로 예외처리를 하지않고
		예외던지기를 하면 프로그램이 끝까지 실행되지 않고 중지되버린다.
		따라서 runtime에러와 같은 것은 반드시 예외처리를 해주어야 한다. 
		 */
		try {
			runtime();
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		tryCatchFinally();
		System.out.println("메인메소드 끝");
	}

}
