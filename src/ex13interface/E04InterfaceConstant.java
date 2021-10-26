package ex13interface;

import java.util.Scanner;
/*
인터페이스에 변수를 정의하면 무조건 상수(static final)로
선언되므로 주로 인터페이스형 상수라고 표현한다. 
->설정값이나 명시적인 코드를 위해 사용된다.
 */
interface Game {
	int SCISSORS=1, ROCK=2, PAPER=3;
}

public class E04InterfaceConstant {
	
	public static void main(String[] args) {
		
		System.out.println("가위(1) 바위(2) 보(3) 게임입니다.");
		System.out.print("선택하세요(정수입력): ");
		
		Scanner sc = new Scanner(System.in);
		int sel = sc.nextInt();
		
		switch(sel) {
		/*
		가위,바위,보를 1,2,3으로 설정했으나 설정값이 많은 경우
		기억하기 어려우므로 명시적인 단어를 통해 상수를 표현했다.
		 */
		case Game.SCISSORS:
			System.out.println("가위를 냈습니다.");
			break;
		case Game.ROCK:
			System.out.println("바위를 냈습니다.");
			break;
		case Game.PAPER:
			System.out.println("보자기를 냈습니다.");
			break;
		default:
			System.out.println("잘못 냈습니다.");
		//만약 문자를 입력하면 예외에러가 생김 => 예외처리 필요
		}
	}
}
