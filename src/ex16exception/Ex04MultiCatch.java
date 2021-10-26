package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
예외처리를 할 때 필요에 따라 여러개의 catch블럭을 사용할 수 있다.
이 경우 반드시 자식 예외클래스로부터 catch블럭에에 사용해야 함!
또한, Exception 클래스는 모든 예외를 catch하기 때문에 마지막 블럭에 쓰기.
(상속의 구조는 ctrl+t로 확인할 수 있다.)
 */
public class Ex04MultiCatch {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int array[] = new int[3];
		
		try {
			for(int i=0; i<array.length; i++) {
				System.out.print("array["+i+"]에 저장할 숫자 입력: ");
				//입력값에 "11a"와같이 입력하면 NumberFormat 예외 발생
				array[i] = Integer.parseInt(scanner.nextLine());	
			}
			System.out.println("배열에 저장된 두 숫자나누기"+ array[0]/array[1]);
			//입력값에 0 입력하면 Arithmetic 예외 발생
			
			System.out.println("나이를 입력하세요: ");
			int age = scanner.nextInt();
			//나이에 "10살"같이 입력하면 InputMismatch 예외 발생
			System.out.println("당신의 나이는: "+ age);
			
			//존재하지 않는 배열(null)에 값 입력시 ArrayIndexOutOfBounds예외 발생
			array[3] = age;
		}
		
		catch(InputMismatchException e) {
			System.out.println("숫자로만 입력해야합니다.");
		}
		catch(ArithmeticException e) {
			System.out.println("산술연산이 불가능합니다.");
		}
		catch(NumberFormatException e) {
			System.out.println("숫자형태의 문자만 입력하세요");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 인덱스를 초과하였습니다");
		}
		catch(Exception e) {
			System.out.println("예외가 발생하였습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	System.out.println("=====프로그램 끝=====");
	}
	

}
