package bokang;

import java.util.Scanner;

public class R04Array
{

	public static void main(String[] args)
	{
		/*
		시나리오 ] 정수5개를 저장할 수 있는 배열을 생성한 후
		숫자를 입력받아 저장한다.
		단, 숫자가 짝수일 때만 저장해야하고 5개 모두 입력되면
		프로그램을 종료한다.*/

		Scanner scan = new Scanner(System.in);
		
		int[] arr3 = new int[5];
		int i=0;
		while(true) {
			System.out.print("숫자를 입력하세요:");
			int input = scan.nextInt();
			if(input % 2 ==0) {
				arr3[i++] = input;
			}
			if(i==5) break;
		}
		for(Object obj:arr3) {
			System.out.print(obj + " ");
		}
	}
}
