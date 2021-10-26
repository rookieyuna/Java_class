package ex05method;

import java.util.Scanner;

/*
메서드 형태] 매개변수는 있으나, 반환값이 없는 경우
	: 값을 전달받은 후 연산하고 해당결과를 즉시 출력하는 경우 주로 사용
 */

public class E04MethodType03_1 
{
	/*
	시나리오] 사용자가 입력한 2개의 시작값과 끝값 사이에
	수를 모두 더하여 출력하는 프로그램을 작성하시오
		(출력결과)
			시작값:6
			종료값:9
			결과: 6+7+8+9	
	 */
	public static void main(String[] args) 
	{
		//Scanner 클래스를 통해 2개의 정수를 입력받음
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("시작값: ");
		int s = scanner.nextInt();
		System.out.print("종료값: ");
		int e = scanner.nextInt();
		
		if(s<=e)
			yesParamNoReturn(s,e); 
			//입력받은 2개의 정수를 인자(argument)로 전달
		else
			System.out.println("잘못된 값입니다.");
	}
	
	/*
	1에서 10까지의 합을 구하는 프로그램의 시작과 종료값만 변수로
	변경하여, 원하는 구간의 합을 구하는 프로그램으로 커스터마이징 ok	
	 */
	static void yesParamNoReturn(int startNum, int endNum) {
		int sum=0;
		for(int i=startNum; i<=endNum; i++) {
			sum += i;
			System.out.print(i);
			if(i!=endNum)
				System.out.print("+");
		}
		//계산의 결과를 출력한다.
		System.out.printf("%n%d에서 %d까지의 합: %d",startNum,endNum,sum);
	}
}
