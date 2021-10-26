package ex06array;

import java.util.Scanner;

public class QusungJuk2 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학생수를 입력하세요?");
		int stdCnt = scanner.nextInt();
		int[][] scoreArr = new int[stdCnt][5];
		
		//입력받은 학생 수만큼 반복
		for(int i=0; i<stdCnt; i++)
		{
			//배열에 점수를 입력받는다
			System.out.print("국어점수 입력?");
			scoreArr[i][0] = scanner.nextInt();
			System.out.print("영어점수 입력?");
			scoreArr[i][1] = scanner.nextInt();
			System.out.print("수학점수 입력?");
			scoreArr[i][2] = scanner.nextInt();
			for(int j=0; j<3; j++)
			{
				scoreArr[i][3] += scoreArr[i][j];
			}
			scoreArr[i][4] = scoreArr[i][3]/3;
		}
		
		for(int i=0; i<scoreArr.length; i++)
		{
			System.out.print((i+1)+"  "); //학생의 순번
			for(int j=0; j<scoreArr[i].length; j++)
			{
				System.out.printf("%3d  ", scoreArr[i][j]);//출력
			}
			System.out.println();
		}
	}
}
