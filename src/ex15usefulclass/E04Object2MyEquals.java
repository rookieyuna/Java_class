package ex15usefulclass;

/*
equals()메서드
-자바에서 인스턴스의 내용비교를 위해 비교연산자(==)를 사용하면
	단순히 참조값 주소를 비교하므로, 실제 내용에 대한 비교하지않음
-인스턴스간의 내용비교를 위해서는 equals()메소드를 각 클래스에
	맞게 오버라이딩하여 사용해야 한다.
-String과 같은 기본클래스는 별도의 오버라이딩 없이 가능하다.
 */
class IntNumber {
	int num;

	public IntNumber(int num) {
		this.num = num;
	}
	/*
	equals()메서드가 어떻게 인스턴스간의 내용을 비교하는지
	확인하기 위한 코드로 구성된 myEquals() 메서드 ㅎㅎ
	 */
	public boolean myEquals(IntNumber numObj) {
		if(this.num == numObj.num) {
			return true; //값이 같을때
		}
		else {
			return false; //값이 다를때
		}
	}
}
public class E04Object2MyEquals {

	public static void main(String[] args) {
		
		//기본클래스인 String 클래스와 인스턴스 비교
		//String은 별도의 오버라이딩 없이 바로 메서드 사용가능
		String str1 = new String("우린KOSMO");
		String str2 ="우린KOSMO";
		
		if(str1==str2) {
			System.out.println("같은 주소값");
		}
		else {
			System.out.println("다른 주소값");
		}
		
		if(str1.equals(str2)) {
			System.out.println("같은 문자열");
		}
		else {
			System.out.println("다른 문자열");
		}
		
		//개발자가 정의한 클래스에 대한 비교
		IntNumber num1 = new IntNumber(10);
		IntNumber num2 = new IntNumber(20);
		IntNumber num3 = new IntNumber(10);
		
		if(num1.myEquals(num2)) {
			System.out.println("num1과 num2는 동일한 정수");
		}
		else {
			System.out.println("num1과 num2는 다른 정수");
		}
		
		if(num1.myEquals(num3)) {
			System.out.println("num1과 num3은 동일한 정수");
		}
		else {
			System.out.println("num1과 num3은 다른 정수");
		}

	}

}
