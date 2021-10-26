package ex06array;

import java.util.Random;

public class E01OneDimArray02
{

	public static void main(String[] args)
	{
		/*
		난수생성방법1
			: Math.random()은 0~1사이의 실수를 랜덤하게 반환하는 메소드로
			정수형태의 난수를 생성하길 원할때는 100을 곱해주면 된다.
		 */
		double rndNumber = Math.random();
		System.out.println("생성된난수1[실수]:"+rndNumber);
		int intNumber = (int)(Math.random()*100);
		System.out.println("생성된난수1[정수]:"+intNumber);
		
		/*
		난수생성방법2
			: Random 클래스를 사용한다. 사용법은 Scanner와 동일하게
			nextInt()메서드를 사용하면 된다.
		 */
		Random random = new Random();
		System.out.println("생성된난수2[정수]:" + random.nextInt());
		System.out.println("생성된난수2[실수]:" + random.nextDouble());
		System.out.println("==============================");
		
		/*
		(#)로또번호처럼 1~45사이의 난수를 생성하는 방법
			1. 0.xxxx의 형태의 난수를 생성한 후 정수로 변경하기 위해
				100을 곱한 후 정수(int)로 변환한다. (소수점절삭)
			2. 45로 % 연산하여 나머지를 구한다. (모든 정수는 45로 나누면
				나머지가 0에서 44까지 나옴)
			3. 0은 구간에 포함되지 않으므로 2번의 결과에 숫자1을 더한다.
				결과적으로 1~45 사이의 난수를 생성함.
		 */
		System.out.print("1~45사이의 난수생성: ");
		System.out.println((int)((Math.random()*100)%45)+1);
		System.out.println("==============================");
		
		System.out.println("크기가 6인 배열에 난수 입력");
		int[] lottoNum = new int [6];
		for(int i=0; i<6; i++)
		{
			lottoNum[i] = (int)((Math.random()*100)%45)+1;
			System.out.printf("%d ", lottoNum[i]);
		}
	}
}
