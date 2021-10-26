package ex16exception;

public class Ex02PreDefineException1 {
	
	public static void main(String[] args) {
		
		System.out.println("### ArrayIndexOutOfBoundsException ###");
		int[] intArr = new int[2];
		try {
			intArr[0] = 100;
			System.out.println("0번방은: "+ intArr[0]);
			intArr[1] = 200;
			System.out.println("1번방은: "+ intArr[1]);
			//예외 발생 지점 = 배열을 벗어나는 입력
			intArr[2] = 300; //JVM(자바컴파일러)가 예외객체를 프로그램으로 throw
			//위에서 예외가 발생하였기때문에 아래문장은 실행되지 않고 catch로 이동
			System.out.println("아? 이방은..!: "+ intArr[2]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			//JVM이 throw한 예외객체를 받아 catch절에서 처리
			System.out.println("예외가 발생했네요");//예외메세지1
			System.out.println("예외메세지:"+ e.getMessage());//예외메세지2(간략설명)
			e.printStackTrace();//예외메세지3(실제오류메세지.가장 많이 사용)
		}
		System.out.println("0번방 재출력: "+ intArr[0]);
		System.out.println("### ArrayIndexOutOfBoundsException 발생 후 ###");
		//예외처리를 하면 실행의 흐름이 중단되지 않으므로 마지막까지 실행된다.
		
	}////end of main
}
