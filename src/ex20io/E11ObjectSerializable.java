package ex20io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
직렬화
	: Circle클래스를 입출력의 대상 파일로 저장하기 위해
	Serializable 인터페이스를 구현하여 정의한다.
	인스턴스가 파일의 형태로 저장되는 것을 '직렬화'라고 한다.
	상속이 되는 경우라면 부모쪽만 implements하면 된다.
 */

class Circle implements Serializable
{
	int xPos, yPos;
	double radian;
	public Circle(int x, int y, double r)
	{
		xPos = x;
		yPos = y;
		radian = r;
	}
	public void showCircleInfo()
	{
		System.out.printf("좌표[%d,%d]",xPos,yPos);
		System.out.println("반지름: "+ radian);
	}
}

public class E11ObjectSerializable
{

	public static void main(String[] args)
	{
		try {
			//인스턴스를 파일에 저장하기 위해 출력스트림을 생성한다.
			ObjectOutputStream out = new ObjectOutputStream
					(new FileOutputStream("src/ex20io/circle.obj"));
			//인스턴스를 생성한 후 파일에 저장한다.
			out.writeObject(new Circle(1, 1, 2.4));
			out.writeObject(new Circle(2, 2, 4.8));
			out.writeObject(new String("String타입의 오브젝트"));
			//java에서 제공하는 기본클래스는 별도의 처리없이 직렬화 가능
			out.close();
			
			/*
			인스턴스의 복원(역직렬화)를 위한 스트림을 생성하고 
			readObject()메서드를 통해 복원한다.
			
			 */
			ObjectInputStream in = new ObjectInputStream
					(new FileInputStream("src/ex20io/circle.obj"));
			
			Circle c1 = (Circle)in.readObject();
			Circle c2 = (Circle)in.readObject();
			String message = (String)in.readObject();
			in.close();
			
			c1.showCircleInfo();
			c2.showCircleInfo();
			System.out.println("String오브젝트: "+message);
		}
		
		catch (ClassNotFoundException e) {
			System.out.println("클래스없음");
		}
		catch (FileNotFoundException e) {
			System.out.println("파일없음");			
		}
		catch (IOException e) {
			System.out.println("뭔가없음");
		}
	}

}
