package ex06array;

import java.util.Scanner;

public class QuFillArray
{
/*
문제6-3] 홀수/짝수 구분하여 배열채우기
1. 길이가 10인 배열을 선언한후 총 10개의 정수를 입력받아 순서대로 저장한다. 
(첫번째배열)
2. 그리고 순서대로 저장된 숫자들을 홀수는 배열의 앞에서부터 채워나가고 짝수는 
배열의 끝에서부터 채워나간다.(두번째배열)


 */
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int[] intArr1 = new int[10];
		int[] intArr2 = new int[10];
		for(int i=0; i<intArr1.length; i++)
		{
			System.out.printf("%d번째 정수를 입력하세요:", (i+1));
			intArr1[i] = scanner.nextInt();
		}
		System.out.println("순서대로 입력된 결과");
		for(int i=0; i<intArr1.length; i++)
		{
			System.out.print(intArr1[i] + " ");
		}
		int j=0, k=1;
		for(int i=0; i<intArr1.length; i++)
		{
			if(intArr1[i]%2!=0)
			{ //홀수일때: 배열의 처음부터 채우기
				intArr2[j] = intArr1[i];
				j++;
			}
			else
			{	//짝수일때: 배열의 끝부터 채우기
				intArr2[intArr2.length-k] = intArr1[i];
				k++;
			}
		}
		System.out.println("\n홀수/짝수 구분 입력 결과");
		for(int i=0; i<intArr2.length; i++)
		{
			System.out.print(intArr2[i] + " ");
		}
	}
}
