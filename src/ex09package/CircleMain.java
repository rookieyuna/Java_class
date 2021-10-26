package ex09package;

//둘레를 구하기위한 Circle클래스 임포트
import ex09package.kosmo.perimeter.Circle;

public class CircleMain
{

	public static void main(String[] args)
	{
		//넓이를 구하기 위한 Circle 클래스 전체경로 입력
		ex09package.kosmo.area.Circle circle1 =
				new ex09package.kosmo.area.Circle(6.5);
		System.out.println("반지름이 6.5인 원의 넓이:"
				+ circle1.getArea());
		
		Circle circle2 = new Circle(4.5);
		

	}

}
