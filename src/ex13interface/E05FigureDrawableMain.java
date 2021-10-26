package ex13interface;

import ex13interface.figure.*;

public class E05FigureDrawableMain {

	public static void main(String[] args) {
		/*
		부모인터페이스타입의 참조변수로 자식객체를 참조하는 이질화형태
		 */
		
		IFigure figure = new Circle(30);
		//오버라이딩 되었으므로 별도의 형변환없이 호출가능
		figure.area("원");
		/*
		IFigure인터페이스에는 area() 추상메서드만 정의되어있으므로
		draw()를 호출하려면 다운캐스팅 후 호출할 수 있다.
		 */
		((Circle)figure).draw("나도 원");
		
		IFigure fig1 = new Rectangle(100, 90);
		fig1.area("사각형");
		((Rectangle)fig1).draw("나도 사각형");
		/*
		IDrawable 인터페이스에는 draw() 추상메서드만 정의되어있으므로
		area()를 호출하려면 다운캐스팅 후 호출할 수 있다.
		 */
		IDrawable draw = new Triangle(100, 90);
		draw.draw("삼각형");
		((Triangle)draw).area("나도 삼각형");
		
		//Circle 참조변수가 동일 객체를 참조하는 동질화 형태
		Circle circle = new Circle(40);
		//모든 메서드 호출 가능
		circle.area("원");
		circle.draw("나도 원");
	}
}
