package ex05method;

import java.util.Scanner;

/*
메서드 형식4] 매개변수도 있고 반환값도 있는 형식으로
	4가지 형식중 가장 많이 사용되는 형태의 메서드이다.
 */

public class E05MethodType04_1 
{
	/*
	시나리오]인원수를 매개변수로 전달받아 인원수 만큼 나이를 입력받고
	그 나이의 합을 반환하는 메소드를 작성하시오.
	 */
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("인원수를 입력하시오:");
		int person = scanner.nextInt();
		
		//나이를 합할 사람의 수를 입력받아 인자를 전달
		int sumOfAge = getTotalAge(person);
		System.out.printf("나이의 합은 %d입니다.", sumOfAge);	
	}
	
	static int getTotalAge(int personCnt)
	{
		Scanner scanner = new Scanner(System.in);
		
		int sumAge = 0; //나이의 누적합을 저장할 변수
		
		//main()메서드에서 전달한 인자(값)만큼 나이를 입력받음
		for(int i=1; i<=personCnt; i++) {
			System.out.print(i+"번째 사람의 나이:");
			int age = scanner.nextInt();
			sumAge += age;
		}
		//나이의 합을 반환한다.
		return sumAge;
	}
}
