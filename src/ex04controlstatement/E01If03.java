package ex04controlstatement;

public class E01If03 
{
/*
if문 형식3
	if(조건1){
		조건1이 참일 때 실행문장;
	}
	else if(조건2) {
		조건2가 참일 때 실행문장;
	}
	else {
		위 모든 조건에 부합하지않을 때 실행문장;
	}
	※ else문에는 조건식이 들어갈 수 없다.
 */
	public static void main(String[] args) 
	{
		/*
		시나리오] 국,영,수 점수의 평균값을 구하여 학점을 출력하는
			프로그램을 작성하시오. 90점 이상 A, 60점 미만은 F학점
		 */
		
		
		int kor=99, eng=70, math=64;
		double avg = (kor+eng+math) / 3.0;
		System.out.println("평균점수는(그대로):"+ avg);
		System.out.printf("평균점수는(소수2자리): %.2f\n", avg);
		
		if(avg>=90)
			System.out.println("A학점");
		else if(avg>=80)
			System.out.println("B학점");
		else if(avg>=70)
			System.out.println("C학점");
		else if(avg>=60)
			System.out.println("D학점");
		else
			System.out.println("F학점. 학사경고;");
		
		/*
		if~else 구문을 구성할 때는 조건의 구간을 어떻게 설정하느냐에
		따라 전혀 다른 결과가 나올 수 있다.
		아래 문장은 높은 점수라 할지라도 60점 이상의 조건에 만족하므로
		무조건 D학점이 출력된다.
		 */
			
		if(avg>=60)
			System.out.println("D학점");
		else if(avg>=70)
			System.out.println("C학점");
		else if(avg>=80)
			System.out.println("B학점");
		else if(avg>=90)
			System.out.println("A학점");
		else
			System.out.println("F학점. 학사경고;");
				
	}

}
