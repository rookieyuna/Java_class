package ex04controlstatement;

public class Qu_04_08 
{
	/*
	문제3) 다음과 같은 모양을 출력하는 프로그램을 for문으로 작성하시오.
		실행결과]
			* * * * *
			* * * *
			* * *
			* *
			*
	*/
	public static void main(String[] args) 
	{
		for(int i=5; i>=1; i--) {
			
			for(int star=1; star<=i; star++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
		
		//쌤 풀이 1
		
		/*
		ROW(행의개수) - x + 1
			: 변수 x가 증가함에 따라 점점 감소하는
			y를 표현하기 위한 일반식 정의
		x가 1일때 : 5 - 1 + 1 = 5
		.
		.
		x가 5일때 : 5 - 5 + 1 = 1
		 */
		final int ROW = 5;
		for(int x=1; x<=ROW; x++) {
			for(int y=1; y<=ROW-x+1; y++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
		
		// 쌤 풀이 2
		
		/*
		n과 m의 크기비교를 통해 반복횟수를 제한한다.
		*/
		for(int n=1; n<=5; n++) {
			for(int m=1; m<=5; m++) {
				if(n<=m)
				System.out.print("* ");
			}
			System.out.println("");
		}
		
		
		//별 반대로그리기 시도 ㅎㅎ
		for(int n=1; n<=5; n++) {
			for(int m=5; m>=1; m--) {
				if(n<m)
				System.out.print("  ");
				else
				System.out.print(" *");
			}
			System.out.println("");
		}
	}
}
