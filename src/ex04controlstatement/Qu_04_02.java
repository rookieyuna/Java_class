package ex04controlstatement;

/*
다음 예제는 두개의 if문을 사용하고 있다.이를 하나의 if문으로 변경해보자
public static void main(String[] args)
{
	 int num = 120;
	 if (num > 0) {
		if ((num % 2) == 0) {
			System.out.println("양수이면서 짝수");
		}
	 }
}
 */
public class Qu_04_02 
{

	public static void main(String[] args) 
	{
		
		int num = 120;
		if(num>0 && (num%2)==0) {
			System.out.println("양수이면서 짝수");
		}

	}

}
