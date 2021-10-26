package ex13interface.figure;

/*
인터페이스 혹은 클래스 하나당 하나의 자바파일을 구성하는 
것을 권장한다. 그래야 모든 클래스를 public으로 선언할 수 있어 
접근이 용이하다.
 */

public interface IFigure {
	//매개변수로 전달되는 도형의 넓이를 구하는 추상메서드
	void area(String figureName);
}
