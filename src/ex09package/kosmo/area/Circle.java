package ex09package.kosmo.area;
/*
원의 넓이를 구하기 위한 클래스로 area 패키지에 정의하였다.
 */
public class Circle
{
	double rad;
	final double PI;
	
	public Circle(double rad) {
		this.rad = rad;
		PI = 3.14159;
	}
	//원의 넓이를 구하는 멤버메소드
	public double getArea() {
		return (PI * rad * rad);
	}
}
