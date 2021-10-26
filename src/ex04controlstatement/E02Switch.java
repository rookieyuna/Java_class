package ex04controlstatement;

import java.util.Scanner;

/*
Switch문
	if문처럼 조건에 따라 분기하는 제어문으로, 정수식의 값과
	동일한 부분을 찾아 실행하는 형태를 가지고 있다.
	형식]
		switch(산술식 또는 정수식) {
		case 값1:
			실행문; break;
		case 값1:
			실행문; break;
		default:
			위의 값과 매칭되지 않을 때 실행되는 실행문(else와 같음)
		}
	※ switch문 내부에서 break문을 만나게 되면 실행이 중지되고 
	밖으로 탈출하게 된다.
	※ 만약 break문이 없다면 그 아래의 모든 실행문이 실행되게 된다.
 */

public class E02Switch 
{

	public static void main(String[] args) 
	{
		/*
		Scanner 클래스
			: JDK5.0부터 추가된 클래스로 키보드를 통해 사용자로부터
			값을 입력받을 때 사용한다.
			nextLine() : 문자열을 입력받음
			nextInt() : 정수를 입력받음
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int iNum = scanner.nextInt();
		System.out.println("입력한 숫자는:"+ iNum);
		
		//정수를 3으로 나누면 나머지는 0,1,2만 생성된다.
		int remain = iNum % 3;
		switch (remain) {
		case 0:
			System.out.println("나머지는 0입니다.");
			break;
		case 1:
			System.out.println("나머지는 1입니다.");
			break;
		default:
			System.out.println("나머지는 2입니다.");
			break;
		}
		
		/*
		switch문 사용 시 주의사항
		-long 타입의 변수는 사용 할 수 없다.
		-byte/short/int/char/String 만 사용할 수 있다.
		-논리식, 조건식도 사용불가능
		 */
//		long ln = 100;
//		switch(ln) { => 에러발생
//		case 100:
//			System.out.println("long타입 사용??");
//		default:
//			System.out.println("안되는군!");
//		}
//		switch(iNum%3==0) { => 에러발생
//			System.out.println("논리식도 안되는군!");
//		}
		
		String title = "자바";
		switch(title) {
		case "자바": System.out.println("자바 좋아");
			break;
		case "JAVA": System.out.println("JAVA Goood");
			break;
		}
		
		/*
		여러 case를 동시에 처리할 때는 break 문 없이 case를 나열한다.
		if문에서 ||(논리or)을 사용하는 것과 동일하다.
		 */
		
		int season = 4;
		switch(season) {
		case 3:case 4:case 5: // =if(season==3 || season==4 || season==5)
			System.out.println("봄입니다.");
			break;
		case 6:case 7: case 8: case 9:
			System.out.println("여름입니다.");
			break;
		case 10:
			System.out.println("가을입니다.");
			break;
		case 11:case 12:case 1:case 2:
			System.out.println("겨울입니다.");
			break;
		}
		
	}

}
