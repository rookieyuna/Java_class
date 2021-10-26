package ex05method;

public class E08RecursiveError
{

	public static void main(String[] args)
	{
		showHi(3);
	}
	/*
	재귀메서드의 오류코드
	1. 감소연산자로 인해 cnt의 값은 차감되지만..
	2. 조건식의 위치가 잘못되어
	3. 재귀호출을 하기전에 종료체크를 할 수 있도록 수정해야한다.
	 */
	public static void showHi(int cnt)
	{
		System.out.println("Hi~~!");
		System.out.println("cnt="+cnt);
		
		//showHi(--cnt); //=> 해당위치에서는 무한루프 에러발생됨
		if(cnt==1)
			return; //메서드의 종료 조건
		
		showHi(--cnt); // 정상적으로 실행되는 위치. 재귀호출전 조건 체크해야함
	}
}
