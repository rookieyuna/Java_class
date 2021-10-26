package ex05method;

import java.util.Scanner;

public class E03MethodType02_2 
{

	static String getHakjum() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("국어점수:");
		int kor = scan.nextInt();
		System.out.println("영어점수:");
		int eng = scan.nextInt();
		System.out.println("수학점수:");
		int math = scan.nextInt();
		
		//평균값 구하기
		double avg = (kor+eng+math)/3.0;
		String hakjum;
		//평균값의 구간을 정하기 위해 10으로 나눈 몫을 사용함
		switch((int)avg/10) {
		case 10: case 9:
			hakjum = "A학점";break;
		case 8:
			hakjum = "B학점";break;
		case 7:
			hakjum = "C학점";break;
		case 6:
			hakjum = "D학점";break;
		default:
			hakjum = "F학점";
		}
		//반환타입에 기술된 String형으로 값 반환(호출한 지점으로)
		return hakjum;
	}
	
	public static void main(String[] args) 
	{
		/*
		시나리오] 사용자로부터 국,영,수 점수를 입력받아 평균을
		구한 후 학점을 반환하는 메소드 정의
		 */
		System.out.println("너의 학점은 "+getHakjum());
		String h = getHakjum();
		System.out.printf("당신의 학점은 %s 입니다.", h);
				
	}//end of main
}//end of class
