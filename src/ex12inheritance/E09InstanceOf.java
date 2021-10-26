package ex12inheritance;
/*
instanceof 연산자
	: 인스턴스 변수가 어떤 타입의 변수인지 판단하는 연산자로
	형변환(상속관계가 있을때)이 가능하면 true, 아니면 false를 반환한다.
	- 객체간의 형변이 되려면 반드시 두 클래스가 상속관계여야 한다.
	- 부모클래스 타입의 참조변수로 자식객체를 참조할 수 있으므로,
	매개변수로 전달된 인자가 어떤 타입인지 확인할 때 주로 사용한다. 
 */
class Box {
	public void boxWrap() {
		System.out.println("Box로 포장합니다.");
	}
}
class PaperBox extends Box {
	public void paperWrap() {
		System.out.println("PaperBox로 포장합니다.");
	}
}
class GoldPaperBox extends PaperBox {
	public void goldWrap() {
		System.out.println("GoldPaperBox로 포장합니다.");
	}
}

public class E09InstanceOf
{
	/*
	-여기서 instanceof 연산자를 통해 형변환 가능여부를 판단하는 이유는
	전달된 매개변수를 최상위 클래스인 Box타입으로 받고있기 때문이다.
	-Box타입으로 인자를 받게되면 자동으로 업캐스팅(자동형변환)이 되기
	때문에 자식클래스의 멤버메서드를 호출할 수 없게 된다.
	-이때 자식의 멤버메소드를 호출하려면 원래타입으로 되돌려야하며
	이를 위해 다운캐스팅(강제형변환)이 필요하다.
	-전달된 인자의 각각의 타입으로 형변환이 가능한지 판단한 후
	다운 캐스팅을 진행하고 각 클래스의 멤버메서드를 호출할 수 있도록함
	 */
	static void wrapBox(Box b) {
		int num1 = (int)1.0;
		double num2 = 1;
		
		if(b instanceof GoldPaperBox) {
			((GoldPaperBox)b).goldWrap();
		}
		else if(b instanceof PaperBox) {
			((PaperBox)b).paperWrap();
		}
		else if(b instanceof Box) {
			b.boxWrap();
		}
	}
	
	public static void main(String[] args)	{
		Box box1 = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();
		
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3); //각타입의 인자를 부모타입인 box로 한번에 호출ok
		
		String str = new String("나는 누구?");
		//wrapBox(str); //Stirng객체와는 상속관계가 없으므로 호출 불가능
	}

}
