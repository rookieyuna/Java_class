package quiz;

import java.util.Scanner;

/*
Quiz1] 가위바위보게임
게임설명 : 가위바위보 게임을 메소드를 통해 구현한다.
1. 난수생성기를 이용하여 1, 2, 3중 하나의 숫자를 생성한다.
2. 사용자가 가위(1),바위(2),보(3) 중 하나를 낸다.
3. 승부를 판단하여 출력한다.
4. 1,2,3 이외의 숫자를 입력하면 잘못된 입력을 알려주고 재입력을 요구한다.
5. 숫자입력을 잘못한 경우는 게임횟수에 포함하지 않는다.
6. 게임은 5번 진행하고 5번째 게임을 끝내면 다시할지 물어본다. 재시작(1), 종료(0)
7. 0, 1 이외의 숫자를 입력하면 재입력을 요구해야 한다.

 */
public class QuRockPaperScissors
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		while(true) 
		{
			int i=1;
			while(i<=5) {//게임 5회제한
				System.out.print("무엇을 내겠습니까?(1: 가위, 2:바위, 3:보):");
				int user = scan.nextInt();//사용자의 선택
				int computer = (((int)(Math.random()*10)%3)+1); //랜덤1,2,3
				
				if(user==1) {
					System.out.print("사용자: 가위, "); i++;
					switch(computer) {
					case 1: 
						System.out.println("컴퓨터: 가위");
						System.out.println("비겼습니다.");
						break;
					case 2: 
						System.out.println("컴퓨터: 바위");
						System.out.println("졌습니다.");
						break;
					case 3: 
						System.out.println("컴퓨터: 보");
						System.out.println("이겼습니다.");
						break;
					}
				}	
				else if(user==2) {
					System.out.print("사용자: 바위, "); i++;
					switch(computer) {
					case 1: 
						System.out.println("컴퓨터: 가위");
						System.out.println("이겼습니다.");
						break;
					case 2: 
						System.out.println("컴퓨터: 바위");
						System.out.println("비겼습니다.");
						break;
					case 3: 
						System.out.println("컴퓨터: 보");
						System.out.println("졌습니다.");
						break;
					}
				}
				else if(user==3) {
					System.out.print("사용자: 보, "); i++;
					switch(computer) {
					case 1: 
						System.out.println("컴퓨터: 가위");
						System.out.println("졌습니다.");
						break;
					case 2: 
						System.out.println("컴퓨터: 바위");
						System.out.println("이겼습니다.");
						break;
					case 3: 
						System.out.println("컴퓨터: 보");
						System.out.println("비겼습니다.");
						break;
					}
				}
				else {
					System.out.println("가위바위보 못하니? 바보야!");
				}
			}
			
			while(true) 
			{
				System.out.print("5번의 게임이 끝났습니다. "
						+ "게임을 계속 하시겠습니까? 재시작(1), 종료(0):");
				int gameover = scan.nextInt();
				
				if(gameover==1) {
					System.out.println("==게임재시작==");break;}
				else if (gameover==0) {
					System.out.println("==게임종료==");	return;}
				else {
					System.out.println("재시작(1), 종료(0)중 입력하세요..");}
			}	
		}
	}
}
