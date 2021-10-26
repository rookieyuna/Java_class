package ex04controlstatement;

public class Qu_04_06 
{
 
	/*
	문제1) 다음과 같은 모양을 출력하는 프로그램을 while문으로 작성하시오.
		실행결과]
			*
			* *
			* * *
			* * * *
			* * * * *
	*/
	
	public static void main(String[] args) 
	{
		
		int i=1;
		int star;
		
		while(i<=5) {
			star=1;
			while(star<=i) {
				System.out.print("* ");
				star++;
			}
			i++;
			System.out.println("");
		}
	}
}
