package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
[사용자정의 예외클래스 처리 순서]
1. Exception 클래스를 상속한다.
2. 생성자에서 예외 발생 시 출력할 메세지를 super()의 인자에 입력한다.
3. 예외 발생 지점에서 if문으로 감싼 후 예외객체를 생성하고 throw한다.
4. catch문에서 예외객체를 받아 처리한다.
 */
class AgeErrorException extends Exception {
	public AgeErrorException() {
		super("나이 입력이 개잘못 되었군요?");
	}
}

public class Ex06DeveloperDefine
{
	public static void main(String[] args)
	{
		System.out.print("나이를 입력 하세요: ");
		
		try {
			/*
			readAge()메서드에서 예외가 발생하여 예외객체가 throw되면
			이 부분에서 예외처리 한다.
			 */
			int age = readAge();
			System.out.println("당신의 나이는 "+age+" 입니다.");
		}
		catch(AgeErrorException e){
			System.out.println("[예외발생]"+e.getMessage());
		}
	}
	
	public static int readAge() throws AgeErrorException {
		Scanner sc = new Scanner(System.in);
		int  inputAge = 0;
		try {
			//만약 문자를 입력했다면 이 부분에서 예외발생
			inputAge = sc.nextInt();
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
		}
		
		//위에서 숫자로 입력됐으면 if문으로 이동됨.
		//나이가 음수로 입력된 경우 개발자가 정의한 예외 발생
		if(inputAge<0) {
			AgeErrorException ex = new AgeErrorException();
			throw ex; //개발자가 정의하면 throws가 아닌 throw임 기억!
			//throw하면 호출한 곳으로 돌아가며 그곳에서 반드시 catch 해야함! 아니면 프로그램 종료.
		}
		return inputAge;
	}

}
