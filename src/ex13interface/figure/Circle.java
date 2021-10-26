package ex13interface.figure;

/*
원은 반지름만 있으면 넓이를 구할 수 있으므로
가로, 세로값을 주는 FigureData클래스를 상속하지 않는다
 */
public class Circle implements IFigure, IDrawable {

	int radius;//반지름
	
	public Circle(int radius) {
		this.radius = radius;
	}
	/*
	인터페이스에 정의된 추상메서드를 필수로 오버라이딩 해야한다.
	 */
	@Override
	public void draw(String figureName) {
		System.out.println(figureName+"을 그립니다");	
	}
	
	@Override
	public void area(String figureName) {
		System.out.println(figureName+"의 면적(r*r*PI)"+
				radius*radius*Math.PI);
		//Math클래스의 상수 PI를 통해 원주율을 사용할 수 있다.
	}
	
}
