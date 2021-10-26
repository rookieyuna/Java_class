//package quiz;
//
//import java.util.Random;
//import java.util.Scanner;
//
//public class QuRockPaperScissors2
//{
//
//	public static void main(String[] args)
//	{
//		Scanner scan = new Scanner(System.in);
//		Random random = new Random();
//		int gameCount = 0;
//		
//		while(true) {
//			//1. 난수생성 -컴퓨터입장
//			int com = random.nextInt(10000)%3+1; //1~3사이
//			
//			//2. 사용자입력
//			int user = 0;
//			System.out.println("가위바위보를 입력하세요.");
//			System.out.print("가위(1),바위(2),보(3)=>");
//			user = scan.nextInt();
//			
//			//3. 승부판단
//			if(!(user<1||user>3)) { //사용자가 정상적으로 입력
//				gameCount++;//게임카운트 증가
//				
//				//승부판단 로직1
//				if(user==1&&com==1) System.out.print("사용자:가위, 컴퓨터:가위\n비겼습니다.\n");
//				if(user==1&&com==2) System.out.print("사용자:가위, 컴퓨터:바위\n졌습니다.\n");
//				if(user==1&&com==3) System.out.print("사용자:가위, 컴퓨터:보\n이겼습니다.\n");
//				if(user==2&&com==1) System.out.print("사용자:바위, 컴퓨터:가위\n이겼습니다.\n");
//				if(user==2&&com==2) System.out.print("사용자:바위, 컴퓨터:바위\n비겼습니다.\n");
//				if(user==2&&com==3) System.out.print("사용자:바위, 컴퓨터:보\n졌습니다.\n");
//				if(user==3&&com==1) System.out.print("사용자:보, 컴퓨터:가위\n졌습니다.\n");
//				if(user==3&&com==2) System.out.print("사용자:보, 컴퓨터:바위\n이겼습니다.\n");
//				if(user==3&&com==3) System.out.print("사용자:보, 컴퓨터:보\n비겼습니다.\n");
//				
//				//승부판단 로직2
//				System.out.printf("사용자:%s, 컴퓨터:%s%n",displayRPS(user),displayRPS(com));
//				switch(user - com) {
//				case 0:
//					System.out.println("비겼습니다.");break;
//				case 1: case -2:
//					System.out.println("이겼습니다.");break;
//				case 2: case -1:
//					System.out.println("졌습니다.");break;
//				}	
//			}
//			else {
//				System.out.println("가위바위보 못하니?");
//			}
//			
//			//4.게임재시작여부 확인
//			if(gameCount==5) {
//				System.out.print("게임재시작(1), 종료(0):");
//				int restart = scan.nextInt();
//				if(restart==0) {
//					//게임종료를 위해 while루프
//					break;
//				}
//				else {
//					System.out.println("게임재시작");
//					gameCount = 0;
//				}
//			}
//		}
//	}
//	
//	public static String displayRPS(int n) {
//		String str = "";
//		switch(n) {
//		case 1: str="가위";break;
//		case 2: str="바위";break;
//		case 3: str="보"; break;
//		}
//		return str;
//	}
//}
