package ex06array;

import java.util.Scanner;

public class QuSungJuk
	/*
	문제6-4] 
	1] 학생수를 사용자로부터 입력받는다.
		-Scanner클래스 사용
	2] 입력받은 학생수만큼 국영수 점수를 저장할 수 있는 int형 배열을 선언한다.
	3] 다시 학생수만큼 각 학생의 국영수 점수를 입력받아 2]에서 생성한 배열에 저장
		-Scanner클래스 사용
	4] 각 학생의 국영수 점수 및 총점 그리고 평균을 출력하여라. 
	5] 이 문제는 2차원 배열을 활용하는 문제이다.
	
	[실행결과]
	학생수를 입력하세요?3
	학생수:3
	[1번째 학생의 점수 입력]
	국어점수 입력?77
	영어점수 입력?78
	수학점수 입력?79
	[2번째 학생의 점수 입력]
	국어점수 입력?82
	영어점수 입력?83
	수학점수 입력?84
	[3번째 학생의 점수 입력]
	국어점수 입력?97
	영어점수 입력?98
	수학점수 입력?99
	==========================
	NO KOR ENG MAT TOT AVG
	==========================
	1  77  78  79  234 78.00
	2  82  83  84  249 83.00
	3  97  98  99  294 98.00
	==========================
	 */
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학생수를 입력하세요?");
		int stdCnt = scanner.nextInt();
		int[][] score= new int[stdCnt][3];
		for(int i=0; i<score.length; i++)
		{
			System.out.print("국어점수 입력?");
			score[i][0] = scanner.nextInt();
			System.out.print("영어점수 입력?");
			score[i][1] = scanner.nextInt();
			System.out.print("수학점수 입력?");
			score[i][2] = scanner.nextInt();
		}
		
		System.out.println("======================");		
		System.out.println("NO KOR ENG MAT TOT AVG");
		System.out.println("======================");
		
		int total=0;
		for(int i=0; i<score.length; i++)
		{
			total=0;
			System.out.print((i+1)+"  ");
			for(int j=0; j<score[i].length; j++)
			{
				System.out.print(score[i][j]+"  ");
				total += score[i][j];
			}
			System.out.printf("%3d ", total);
			System.out.printf("%2.2f", total/3.0);
			System.out.println();
		}
	}
}
