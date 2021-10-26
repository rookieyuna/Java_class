package quiz;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

//개발자 정의 예외 클래스
class WrongNumberException extends Exception {
	public WrongNumberException() {
		super("[예외발생]정해진 숫자만 입력하세요.");
	}
}

public class QuRockPaperScissors3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		int gameCount = 0;
		
		while(true) {
			//1. 난수생성 -컴퓨터입장
			int com = random.nextInt(10000)%3+1;
			
			//2. 사용자입력
			int user = 0;
			System.out.println("==게임시작==");
			try {
				System.out.println("가위바위보를 입력하세요.");
				System.out.print("가위(1),바위(2),보(3)=>");
				user = scan.nextInt();
				/*
				숫자외에 문자를 입력하면 메서드 내에서 예외가 발생하므로
				문자는 거부하고 엔터키가 버퍼에 남게된다. => 무한루프발생
				 */
				//사용자가 1~3 이외의 숫자를 내는 경우 사용자 예외 발생
				if(user<1 || user>3) {
					WrongNumberException wrong = new WrongNumberException();
					throw wrong;
				}
			}
			catch(InputMismatchException e){
				//user에 남아있는 엔터키를 버퍼에서 제거한다.
				scan.nextLine();
				System.out.println("가위바위보 입력오류! 숫자만입력하세요.");
			}
			catch(WrongNumberException e){
				System.out.println(e.getMessage());
			}
			
			
			//3. 승부판단
			if(!(user<1||user>3)) { //사용자가 정상적으로 입력
				gameCount++;//게임카운트 증가
				
				System.out.printf("사용자:%s, 컴퓨터:%s%n",displayRPS(user),displayRPS(com));
				switch(user - com) {
				case 0:
					System.out.println("비겼습니다.");break;
				case 1: case -2:
					System.out.println("이겼습니다.");break;
				case 2: case -1:
					System.out.println("졌습니다.");break;
				}
			}
			
			//4.게임재시작여부 확인
			if(gameCount==5) {
				int restart = -1;
				while(true) {
					try {
						System.out.print("게임재시작(1), 종료(0):");
						restart = scan.nextInt();
						
						if(restart!=1 && restart!=0) {
							WrongNumberException wrong = new WrongNumberException();
							throw wrong;
						}
					}
					catch (InputMismatchException e) {
						scan.nextLine();
						System.out.println("[예외발생]숫자만 입력하세요");
					}
					catch (WrongNumberException e) {
						System.out.println(e.getMessage());
					}
					
					if(restart==0) {
						//게임종료를 위해 while루프
						break;
					}
					else {
						
						gameCount = 0;
					}
				}	
			}
		}
	}
	
	public static String displayRPS(int n) {
		String str = "";
		switch(n) {
		case 1: str="가위";break;
		case 2: str="바위";break;
		case 3: str="보"; break;
		}
		return str;
	}
}
