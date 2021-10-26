package ex08class;
/*
문제 8-2] 밑변과 높이 정보를 저장할 수 있는 Triangle클래스를 정의해보자. 
init메소드를 통해 밑변과 높이를 초기화한다.
그리고 밑변과 높이를 변경시킬수 있는 메소드와 삼각형의 넓이를 계산해서 
반환하는 메소드도 함께 정의해보자.

[메인메소드 샘플]
public static void main(String[] args)
{
	Triangle t = new Triangle();
	t.init(10, 17); //밑변10, 높이17로 초기화
	System.out.println("삼각형의 넓이 : " + t.getArea());
	t.setBottom(50);//밑변 50으로 변경
	t.setHeight(14);//높이 14로 변경
	System.out.println("삼각형의 넓이 : " + t.getArea());
}
[실행결과]
삼각형의 넓이 : 85.0
삼각형의 넓이 : 350.0
 */

class Triangle
{
	int bottom, height;
	
	void init(int bottom, int height)
	{
		this.bottom = bottom;
		this.height = height;
	}
	
	double getArea()
	{
		return bottom * height * 0.5;
	}
	void setBottom(int bottom)
	{
		this.bottom = bottom;
	}
	void setHeight(int height)
	{
		this.height = height;
	}
}

public class QuTriangle
{
	public static void main(String[] args)
	{
		Triangle t = new Triangle();
		t.init(10, 17); //밑변10, 높이17로 초기화
		System.out.println("삼각형의 넓이 : " + t.getArea());
		t.setBottom(50);//밑변 50으로 변경
		t.setHeight(14);//높이 14로 변경
		System.out.println("삼각형의 넓이 : " + t.getArea());
	}
}
