package ex04controlstatement;

public class Senario_04 {

	public static void main(String[] args) 
	{
		
		/*
		시나리오1] 사용자가 입력한 문자가 숫자인지 판단하는 프로그램을
			if문을 이용해서 작성하시오 (E01If01)
		 */
		
		
		
		
		
		
		/*
		시나리오2] 국,영,수 점수의 평균값을 구하여 학점을 출력하는
			프로그램을 작성하시오. 90점 이상 A, 60점 미만은 F학점 (E01If03)
		 */
		
		
		
		
		
		
		/*
		시나리오3] 1~10까지의 합을 구하는 프로그램을
		while문으로 작성하시오.(E03While)
		 */
		
		
		
		
		
		
		/*
		시나리오4] 1~100까지의 정수중 3의 배수이거나 4의 배수인
		정수의 합을 구하는 프로그램을 while문을 이용해서 작성하시오. (E03While)
		*/
		
		
		
		
		
		/*
		시나리오5] 구구단을 출력하는 프로그램을 작성하시오.
		단 while문을 사용하시오.(E03While)
		*/
		
		
		/*
		시나리오6] E03 예제의 1~10까지 더하는 수열문제를 do~while문으로
		변경하여 구현하시오. (E04DoWhile)
		*/
		
		
		
		/*
		시나리오7] 1부터 1000까지의 정수 중 4의 배수이거나
		7의 배수인 합을 구하여 출력하는 프로그램을 작성하시오.
		단 do~while 문을 사용해야한다. (E04DoWhile)
		*/
		
		
		
		/*
		시나리오8] 국어, 영어, 수학 점수를 사용자로부터 입력받은 후 
		평균을 구해 A-F학점을 판단하여 출력하는 프로그램을 작성하시오
		단. 사용자가 X,x (대소문자 구분없음)를 입력하면 프로그램이 종료되어야
		하며 do~while문으로 구현해야한다. (E04DoWhile)
		 */
		
		
		/*
		시나리오] 구구단을 출력하는 프로그램을 작성하시오.
		단 for문을 사용하시오.(E05For)
		*/
		
		System.out.println("[for문으로 제작한 구구단]");
		for(int a=2; a<=9;a++) {
			
			for(int b=1;b<=9;b++) {
				System.out.printf("%dx%d=%2d%n",a,b,(a*b));
			}
			System.out.println("");
		}
				
		/*
		시나리오] 다음의 출력결과를 보이는 for문 작성		
			0 0 0 1
			0 0 1 0
			0 1 0 0
			1 0 0 0
		해법: x와 y를 더해서 5가 될 때 1을 출력한다.
		*/
				
		System.out.println("\n[for문으로 바둑판 출력하기]");
		
		for(int x=1; x<=4; x++) {
			for(int y=1; y<=4; y++) {
				if(x+y==5) {
					System.out.print("1 ");
				}
				else {
					System.out.print("0 ");
				}
			}
			System.out.println("");
		}
		
	}

}
