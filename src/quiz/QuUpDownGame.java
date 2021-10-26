package quiz;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
/*
[업다운게임 만들기]
1. 컴퓨터는 1~100사이의 숫자 하나를 생성한다.
2. 총 시도횟수는 7번을 부여한다.
3. 사용자는 7번의 시도안에 숫자를 맞춰야 한다.
4. 사용자가 숫자를 입력했을때 컴퓨터는 높은지/낮은지 알려준다.
5. 7번안에 맞추면 성공, 맞추지 못하면 실패라고 출력한다.
6. 성공/실패 후 계속 할지를 물어보고 1이면 게임 재시작, 0이면 프로그램을 종료한다.
7. 함수를 사용하여 구현한다.
※ 무한루프에 빠지게 된다면 scan.nextLine()을 활용하여 버퍼에 남아있는 Enter키를 제거해주도록 하자.

 */

class NumberRangeException extends Exception {
	public NumberRangeException() {
		super("[예외]1부터 100까지의 숫자를 입력하세요!\n");
	}
}

public class QuUpDownGame {
	public static void upDownGame(int userNum, int gameNum) {
		Scanner scan = new Scanner(System.in);
		
		if(userNum==gameNum) {
			System.out.println("성공!!");
			System.out.println("정답입니다.");
			return;
		}
		else if(userNum<gameNum) {
			System.out.println("UP");
		}
		else {
			System.out.println("DOWN");
		}
	}
	
	public static void reGame() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("실패입니다. 다시하시겠습니까?");
		System.out.print("게임재시작(1), 종료(0):");
		int restart = scan.nextInt();
		if(restart==0) {
			System.out.println("==게임종료==");
			System.exit(0);
		}
		else {
			System.out.println("==게임재시작==");
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		int gameNum = random.nextInt(100)+1;
		int gameCnt = 0;
		int userNum = 0;
		
		while(true) {
			if(gameCnt<7) {
				try {
					System.out.print("숫자를 입력하세요:");
					userNum=scan.nextInt();
					
					if(userNum<1||userNum>100){
						NumberRangeException wrong = new NumberRangeException();
						throw wrong;
					}	
					upDownGame(userNum, gameNum); gameCnt++;
					
				}
				catch (InputMismatchException e) {
					scan.nextLine();
					System.out.println("[예외]문자입력오류. 숫자로 입력하세요");
				}
				catch (NumberRangeException e) {
					System.out.println(e.getMessage());
				}
			}
			else {
				reGame();
				gameCnt = 0;
			}
		}
	}
}

