package ex13interface.figure;

//'그리다' 행위를 표현한 인터페이스
public interface IDrawable {
	
	//매개변수로 전달되는 도형을 그릴 추상메서드
	void draw(String figureName);
}
