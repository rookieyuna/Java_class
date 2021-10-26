package ex04controlstatement;

public class Qu_04_07 
{
	/*
	1~100까지의 숫자중 3의배수 이거나 7의배수인 숫자의 합을 
	구하는 프로그램을 작성하시오. 
	단, 3과 7의 공배수인 경우 합에서 제외해야 한다. 
	출력의 결과는 누적되는 모든 수를 콘솔에 print한다.
		실행결과]
		3+6+7+~~~~~~=????
	*/
	public static void main(String[] args) 
	{
		int total = 0;
		
		for(int i=1; i<=100; i++) {
			
			if((i%3==0 || i%7==0)&&(!(i%3==0 && i%7==0))) {
				total += i;
				System.out.print(i);
				
				if(i<99) {
					System.out.print("+");
				}
			}
		}
		System.out.println("="+total);
		
		//쌤 풀이
		
		int sum = 0;
		for(int k=1; k<=100; k++) { //1~100까지 반복
			if((k%3==0 || k%7==0)&&(k%(3*7)!=0)) {
				sum += k; //누적합
				//방법1
//				if(k!=99)
//					System.out.print(k+"+");
//				else
//					System.out.print(k);
				
				//방법2
				System.out.print(k);
				if(k!=99) System.out.print("+");
			}
		}
		System.out.println("=" + sum); //결과출력
	}	
}

