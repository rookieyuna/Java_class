package ex13interface.figure;
/*
사각형을 표현한 클래스
	:가로,세로의 길이가 필요하므로 FigureData클래스를 상속받고
	넓이와 그리는 행위를 표현하기 위해 2개의 인터페이스를 구현한다.
 */
public class Rectangle extends FigureData implements IFigure, IDrawable {
	
	public Rectangle (int width, int height) {
		super(width,height);
	}
	
	@Override
	public void draw(String figureName) {
		System.out.println(figureName+"을 그립니다");
	}
	
	@Override
	public void area(String figureName) {
		System.out.println(figureName+"의 면적(가로*세로):"+
				width*height);	
	}
}
