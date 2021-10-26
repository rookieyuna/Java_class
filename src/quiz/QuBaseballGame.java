package quiz;
/*
Quiz3] 야구게임(Baseball Game)
게임설명 : 야구게임을 메소드를 이용하여 구현한다.
1. 중복되지 않는 3개의 정수를 생성한다.(1~9)
2. 사용자는 3개의 숫자를 입력한다.
3. 생성된 3개의 숫자를 맞추는데 위치까지 정확히 맞춰야 한다.
4. 숫자와 숫자의 위치까지 일치하면 strike 로 판정한다.
5. 숫자는 맞지만 위치가 틀렸다면 ball 로 판정한다.
6. 숫자3개가 모두 일치하지 않으면  out 으로 판정한다.
7. 3 strike 가 되면 게임은 종료된다.
8. 시도한 횟수를 표시한다.
9. 계속할지 종료할지 여부를 물어보고 다음 진행을 한다.

위 문제의 변수들은 아래와 같이 생성하여 구현해본다.
   int com1, com2, com3;
   int user1, user2, user3;
아니면 
   int[] com = new int[3];
   int[] user = new int[3];
와 같이 배열을 사용해도 된다. 
 */

import java.util.Random;
import java.util.Scanner;

class RandomCom {
	int[] com = new int[3];
	
	public RandomCom() {
		Random random;
		for(int i=0; i<3; i++) {
			random = new Random();
			com[i] = random.nextInt(9)+1;
			while(true) {
				if(i==1 && com[i]==com[i-1])
					com[i] = random.nextInt(9)+1;
				if(i==2 && (com[i]==com[i-1] || com[i]==com[i-2]))
					com[i] = random.nextInt(9)+1;
				else
					break;
			}
			System.out.print(com[i]+" ");//랜덤번호 확인용출력
		}
	}
	public int[] getCom() {
		return com;
	}
}

class BallGame {
	RandomCom random;
	Scanner scan = new Scanner(System.in);
	private int[] com;
	private int[] user= new int[3];

	public void gameSet() {
		random = new RandomCom();
		com = random.getCom();
		
		int gameCnt=0;
		int strikeCnt, ballCnt, outCnt;

		while(true) {
			strikeCnt = 0;
			ballCnt = 0;
			outCnt = 0;
			
			System.out.print("숫자3개 입력하세요:");
			user[0] = scan.nextInt(); 
			user[1] = scan.nextInt(); 
			user[2] = scan.nextInt(); 
			gameCnt++;
			
//			//strike 파악 for문
//			for(int i=0; i<3; i++) {
//				if(com[i]==user[i]) {
//					strikeCnt++;
//				}
//			}
//			//ball 파악 for문
//			for(int i=0; i<3; i++) {
//				for(int j=0; j<3; j++) {
//					if(i!=j && com[i]==user[j]) {
//						ballCnt++;
//					}
//				}
//			}
			
			//strike 및 ball 파악 for문 (확인필요)
			for(int i=0; i<com.length; i++) {
				for(int  j=0; j<user.length; j++) {
					if(com[i]==com[j]) {
						if(i==j) strikeCnt++;
						else ballCnt++; 
					}
				}
			}
			
			
			
			//out 파악 if문
			if(strikeCnt==0&&ballCnt==0) {
				outCnt = 1;
				System.out.println("out입니다 ㅠㅠ");
			}
			else {
				System.out.println("=> strike:"+strikeCnt+", ball:"+ballCnt);
			}	
			if(strikeCnt==3) {				
				System.out.printf("***게임 %d회에 strike승리***%n", gameCnt);				
				gameOver();
			}
		}
	}
	public void gameOver() {
		System.out.println("게임을 다시 시작하시겠습니까?");
		System.out.print("재시작(1), 게임종료(0): ");
		int reGame = scan.nextInt();
		
		if(reGame==0)
			System.exit(0);
		else
			gameSet();
	}
}

public class QuBaseballGame {

	public static void main(String[] args) {
		
		BallGame game = new BallGame();
		game.gameSet();
	}
}
