package quiz;

import java.util.Random;
import java.util.Scanner;

public class QuBaseballGame2
{

	public static void main(String[] args)
	{
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		
		//게임에서 사용할 변수
		int com1, com2, com3;
		int user1, user2, user3;
		int randomCnt=0;//난수생성카운트
		int gameCnt=0; //게임카운트
		int strikeCnt=0, ballCnt=0;// 스트라이크,볼카운트
		
		while(true) {
			//몇번만에 난수가 생성되는지 확인
			randomCnt++;
			com1 = random.nextInt(100) % 9 + 1;
			com2 = random.nextInt(100) % 9 + 1;
			com3 = random.nextInt(100) % 9 + 1;
			
			//방법1
//			if(com1==com2 || com2==com3 || com3==com1) {
//				//난수생성실패
//				continue;
//			}
//			else {
//				//생성 성공
//				break;
//			}
			
			//방법2
			if(!(com1==com2 || com2==com3 || com3==com1)) {
				//중복되지 않는 난수에 성공하면 루프탈출
				break;
			}
		}////랜덤생성 while문 종료
		
		// 난수확인
		System.out.println(randomCnt+"회"+com1+com2+com3);
		
		while(true) {
			strikeCnt=0;
			ballCnt=0;
			
			System.out.print("숫자입력하세요:");
			user1 = scan.nextInt();
			user2 = scan.nextInt();
			user3 = scan.nextInt();
			
			gameCnt++;
			
			//판단1 - 스트라이크(숫자와 위치까지 일치)
			if(com1==user1) strikeCnt++;
			if(com2==user2) strikeCnt++;
			if(com3==user3) strikeCnt++;
			
			//판단2 - 볼(숫자는 일치하나 위치가 다를 때)
			if(com1==user2 || com1==user3) ballCnt++;
			if(com2==user1 || com2==user3) ballCnt++;
			if(com3==user1 || com3==user2) ballCnt++;
			
			//게임종료판단
			if(strikeCnt==3) {
				System.out.println("3스트라이크 게임종료");
				break;
			}
			else {
				//하나도 못맞추는 경우
				if(strikeCnt==0 && ballCnt==0) {
					System.out.println("아웃입니다.");
				}
				else {
					System.out.println("스트라이크:"+strikeCnt+", 볼:"+ballCnt);
				}
			}
		}////게임 while문 종료
	}
}
