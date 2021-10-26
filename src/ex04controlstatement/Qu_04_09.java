package ex04controlstatement;

public class Qu_04_09 
{
	/*
	문제4] 구구단을 이중 for문을 이용해서 다음과 같이 출력하시오
		실행결과]
		2*1=2   3*1=3 ~~~~~~~~~~ 9*1=9
		2*2=4   ~~~~~~~~~~~~~~~ 9*2=18
			~~~~~~~~~~~~~
		2*8=16~~~~~~~~~~~~~~~~9*8=72
		2*9=18~~~~~~~~~~~~~~~~9*9=81
	*/
	
	public static void main(String[] args) 
	{
		//b가 고정된 상태에서 a가 증가하는 형태로 구성
		for (int b=1; b<=9; b++) {
			for(int a=2; a<=9; a++) {
				System.out.printf("%d*%d=%2d ", a, b, (a*b));
			}
			System.out.println("");
		}
	}
}
