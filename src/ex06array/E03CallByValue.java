package ex06array;

public class E03CallByValue
{
/*
Call by value(값에 의한 호출)
	: 메소드 호출과 관련된 개념으로 매개변수를 통해 값을 전달할 때
	메모리의 '복사'를 통해 값이 전달된다.
	그래서 다른 메소드(지역)에서 값의 변경이 있더라도 호출한 메소드의
	값에는 전혀 영향을 미치지않는다.
	
	메모리적 관점에서 보면 스택(stack)영역만 사용하는 케이스로
	main메서드와 호출된 메서드는 서로 다른지역이므로 영향을 미치지 않는다.
 */
	public static void main(String[] args)
	{
		int first=100, second=200;
		System.out.println("[main메소드안-호출전]");
		System.out.println("first="+first+", second"+second);
		
		callByValue(first,second);
		System.out.println("[main메소드안-호출후]");
		System.out.println("first="+first+", second"+second);
	}
	
	public static void callByValue(int fNum, int sNum)
	{
		/*
		Swap(교환) : 두개의 변수가 할당받은 값을 서로 교환하는 것을
		말한다. 교환시에는 임시변수(temp) 하나가 추가로 필요하다.
		 */
		int temp;
		temp = fNum;
		fNum = sNum;
		sNum = temp;
		
		System.out.println("[callByValue메소드안]");
		System.out.println("first="+fNum+", second"+sNum);
	}

}
