package ex02variable;

public class E06EscapeSequence 
{

	public static void main(String[] args) 
	{

		// "\t" 탭(tab)기능. 스페이스 4칸이 띄워짐.
		System.out.println("4월엔 벚꽃~~!");
		System.out.println("4월엔\t벚꽃~~!");
		
		// "\n" 줄바꿈(line feed)기능.
		System.out.println("KOSMO에 오신걸 환영합니다.\n");
		System.out.println("열심히\n해봅시다.\n");
		
		// "\" 문자열 사이에 " 나 \ 등의 기호를 표시하고 싶을때 사용
		//System.out.println("나는 "개발자"가 되고싶어요.);=>에러발생
		System.out.println("나는 \"개발자\"가 되고싶어요.");
	
		
		//printf문 연습
		//printf(): 문자열을 서식에 맞춰 출력할 때 사용한다.
		
		int kor=81, eng=97, math=79;
		
		//정수인 경우 %d를 사용한다.
		System.out.printf("국어:%d, 영어:%d, 수학:%d%n", kor, eng, math);
		System.out.println("\n국어:"+ kor + ", 영어:"+ eng + ", 수학:"+math);
		
		//실수인 경우 %f를 사용한다.
		double avg = (kor+eng+math) / 3.0; //정수와 실수 연산이므로 결과는 실수
		System.out.printf("평균점수:%f%n", avg);
		
		/*
		자리수 지정하기
		예시) %4d: 정수 출력 시 전체 자리수를 4자리로 표현한다.
			%6.2f: 실수 출력 시 전체자리 수는 6자리, 소수이하 2자리로 표현한다.
			양수는 우측정렬, 음수는 좌측정렬된다. 
		 */
		
		System.out.printf("국어:%d, 영어:%d, 수학:%d, "
				+ "평균:%f %n", kor, eng, math, avg);
		
		System.out.printf("국어:%6d, 영어:%6d, 수학:%6d, "
				+ "평균:%.2f %n", kor, eng, math, avg);
		
		System.out.printf("국어:%-6d, 영어:%-6d, 수학:%-6d, "
				+ "평균:%-7.2f %n", kor, eng, math, avg);
	}

}
