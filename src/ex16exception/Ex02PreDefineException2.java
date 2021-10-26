package ex16exception;

import java.util.Scanner;

public class Ex02PreDefineException2
{

	public static void main(String[] args) {
		
		System.out.println("### NumberFormatException ###");
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("나이를 입력하세요:");
			String strAge = sc.nextLine();
			//10살과 같이 입력하면 숫자로 변환시 예외 발생
			int ageAfter10 = Integer.parseInt(strAge)+10;
			System.out.println("당신의 10년 후 나이는"+ageAfter10);
		}
		catch(NumberFormatException e) {
			System.out.println("나이는 숫자로만 입력하세요");
			System.out.println("예외메세지: "+ e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("### NumberFormatException 이후 ###");
	}

}
