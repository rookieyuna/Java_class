package ex12inheritance;
/*
가변인자(Variable Argument)
	: 메서드 오버로딩을 대체할 수 있는 문법.
	하나의 메서드로 여러가지 호출형식을 대체할 수 있다.
	형식]
		메서드명(자료형...매개변수명) {
			실행문장
		}
	-필요에 따라 매개변수를 가변적으로 조정할 수 있는 문법으로 JDK1.5부터 지원
	-매개변수는 여러개를 한꺼번에 받아야하므로 배열로 반환된다.
 */
public class E08VariableArgument
{
	static int getTotal(int param) {
		int total = 0;
		total += param;
		return total;
	}
	static int getTotal(int param1, int param2) {
		int total = 0;
		total += (param1+param2);
		return total;
	}
	static int getTotal(int param1, int param2, int param3) {
		int total = 0;
		total += (param1+param2+param3);
		return total;
	}
	
	//가변인자를 통한 메소드의 정의
	static int getTotal(int ... param) { 
		int total = 0;
		for(int i=0; i<param.length; i++) {
			total += param[i];
		}
		return total;
	}	
	
	public static void main(String[] args)
	{
		System.out.println("getTotal(args1)호출:"+
				getTotal(10));
		System.out.println("getTotal(args1+args2)호출:"+
				getTotal(10,20));
		System.out.println("getTotal(args1+args2+args3)호출:"+
				getTotal(10,20,30));
		System.out.println("getTotal(매개변수 6개)호출:"+
				getTotal(10,20,30,40,50,60));
		
		//매개변수의 타입이 double이 포함되어 호출 불가능함
		//실수타입까지 처리하려면 가변인자의 타입을 double로 선언
		//System.out.println("getTotal(args1, args2호출:"+ getTotal(10,10.1));
	}

}
