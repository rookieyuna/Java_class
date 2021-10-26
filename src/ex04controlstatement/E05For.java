package ex04controlstatement;

public class E05For 
{
/*
for문 : while문과 같은 반복문으로 초기값, 조건식, 증감식이
	한줄에 있어 반복의 횟수를 명시적으로 알수있는 반복문이다. 
	형식]
		for(초기값 ; 조건식 ; 증감식){
			실행문;
		}
	실행순서]
		초기값 -> 조건식 확인 -> 참일때 실행 -> 증감식
			-> 조건식 확인 -> 반복실행
			-> 조건이 거짓일때 for문 탈출
 */
	
	public static void main(String[] args) 
	{
		/*
		for문의 실행순서
		1. 반복을 위한 변수 i를 1로 초기화
		2. 조건을 검사. 
		3. 조건이 참일때 실행문을 실행한다. 
		4. 증가(감소)식 실행
		5. 조건을 검사(3,4,5번을 반복횟수만큼 실행)
		6. 조건이 false면 탈출
		*/
		
		for(int i=1; i<=5; i++) {
			System.out.println("i=" +i);
		}
		
		/*
		시나리오] 1~100까지의 합을 구하는 프로그램을 for문을 
			이용하여 작성하시오. 
		 */
		int sum = 0;
		for(int j=1; j<=100; j++) {
			sum += j;
		}
		System.out.println("1~100까지의 합:" +sum);
		
		
		/*
		시나리오] for문을 이용하여1~10 사이의 정수 중 2의 배수 합을
		구하는 프로그램을 작성하시오 (E05For)
		*/
		
		int total = 0;
		//방법1 : 10번 반복에서 if문을 통해 2의배수를 찾은 후 누적합
		for(int k=1; k<=10; k++) {
			if(k%2==0) {
				total += k;
			}
		}
		System.out.println("1~10사이의 2의 배수합:"+total);
		
		//방법2 : if문 없이 2씩 증가하면서 누적합
		total = 0;
		for(int k=0; k<=10; k+=2) { //복합대입연산자 사용가능
			total += k;
			
		}
		System.out.println("1~10사이의 2의 배수합:"+total);
		
		
		//for문으로 무한루프를 만들때 사용. 일반적으로 while문을 사용함.
//		int a = 1;
//		for(;;) {
//			System.out.println("나는 for문으로 만든 무한루프입니다.")			
//		}
		
		
		/*
		for문의 끝에 ;을 사용하면 반복할 문장이 없는것으로 간주되어
		for문과 상관없이 한번만 실행된다. (주의!!)
		 */
		
		for (int j=0; j<=5; j++); {
			System.out.println("어랏..나는 누구? 여긴 어디?");
		}
		
		
		/*
		for문의 초기식에서 선언된 변수 j는 for문이 종료되는 순간
		메모리에서 소멸된다. 여기서 사용된 변수 j는 지역변수(local variable)
		라고한다. 지역변수는 해당 지역을 벗어나면 즉시 소멸되는 특징을
		가지고있다. 
		*/
		
		//System.out.println("위 for문에서 선언한 변수 j=" +j);
		System.out.println("위 메인함수 지역에서 선언한 변수 total="+total);
		
		
		
		/*
		for문의 초기값을 외부(넓은지역)에서 선언하면 해당변수는 for문의
		안쪽(좁은지역)에서 사용할 수 있다. 즉 아래에 선언한 변수 i는
		main 메소드의 지역변수가 된다. 
		*/
		int i=0;
		for( ; i<=5; i++) {
			System.out.println("for문 안에서의 i값:"+i);
		}
		System.out.println("for문밖에서의 i값:"+i);
		
		
		/*
		시나리오] 구구단을 출력하는 프로그램을 작성하시오.
		단 for문을 사용하시오.(E05For)
		*/
		
		System.out.println("[for문으로 제작한 구구단]");
		for(int a=2; a<=9;a++) {
			
			for(int b=1;b<=9;b++) {
				System.out.printf("%dx%d=%2d%n",a,b,(a*b));
			}
			System.out.println("");
		}
				
		/*
		시나리오] 다음의 출력결과를 보이는 for문 작성		
			0 0 0 1
			0 0 1 0
			0 1 0 0
			1 0 0 0
		해법: x와 y를 더해서 5가 될 때 1을 출력한다.
		*/
				
		System.out.println("\n[for문으로 바둑판 출력하기]");
		
		for(int x=1; x<=4; x++) {
			for(int y=1; y<=4; y++) {
				if(x+y==5) {
					System.out.print("1 ");
				}
				else {
					System.out.print("0 ");
				}
			}
			System.out.println("");
		}
		
	}

}
