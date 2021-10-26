package ex13interface.figure;
/*
가로(밑변), 세로(높이)를 멤버로 가지고있는 상위클래스
차후 삼각형, 사각형 클래스에서 상속받아 사용할 것임.
 */
public class FigureData {

	int width, height;
	public FigureData(int width, int height) {
		this.width = width;
		this.height = height;
	}
}
