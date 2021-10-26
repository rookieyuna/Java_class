package ex04controlstatement;

public class E06BreakContinue 
{
/*
break문: 반복문이나 switch문에서 주로 사용되며 블럭내에서
	break문을 만나면 해당 블럭을 탈출한다.
	만약 중첩된 반복문이라면 가장 가까운 블럭 하나만 탈출
continue문: 반복문에서 continue를 만나면 처음으로 돌아가서
	조건을 확인한다. 따라서 continue 아래 문장은 실행되지 않는다.
*/
	
	public static void main(String[] args) 
	{
		int i=0;
		while(true) {
			/*
			반복문 내에서 break, continue문을 사용할 때는 반드시
			조건문과 같이 사용해야 한다.
			그렇지 않으면 Unreachable Code에러가 발생한다.
			*/
			i++;
			System.out.printf("i가 %d일때]\n", i);
			
			System.out.println("continue이전 출력문");
			if(i%2==0) continue;
			System.out.println("continue이후 출력문");
			
			System.out.println("break이전 출력문");
			if(i%3==0) break;
			System.out.println("break이후 출력문");	
		}
		
		/*
		중첩된 반복문 안에서 break문을 만나면 가장 가까운
		반복문하나만 탈출한다.
		*/
		for(int x=1; x<=5; x++) {
			System.out.println("x="+x);
			
			for(int y=1; y<=5; y++) {
				System.out.println("y="+y);
				if(y==3)
					break;
			}
		}	
	}
}
