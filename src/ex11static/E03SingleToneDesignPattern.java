package ex11static;
/*
싱글톤 디자인 패턴
	: 클래스를 설계하는 디자인패턴의 하나로써 하나의 인스턴스
	즉 하나의 메모리를 생성해 이를 공유해서 사용하고자 할 때
	쓰는 패턴이다.
작성방법]
	1. 생성자의 접근지정자를 private로 선언한다.
	2. private 정적변수로 클래스 객체를 생성한다
	(클래스 외부는 생성자를 통해 접근할 수 없어 new를 통한 객체생성 불가)
	3. 클래스 내부에 정적메서드로 해당클래스의 객체를 반환하도록 
	정의한다 (메서드의 반환타입은 클래스명)
	4. 위 방법을 통해 객체를 생성하면 메모리에 하나의 객체만 가능
 */

//일반적인 클래스
class NoSingleTone {
	int instVar;
	public NoSingleTone() {}
}

//싱글톤 패턴이 적용된 클래스
class SingleTone {
	int shareVar;
	/*
	JVM(자바가상머신)에 의해 프로그램이 시작될 때 정적변수는 미리
	메서드영역에 생성되어 사용할 준비를 마치게 된다.
	 */
	
	private static SingleTone single = new SingleTone();
	//기본생성자를 private로 선언하여 외부클래스에서 접근불가
	private SingleTone() {} 
	
	/*
	정적메서드로 선언된 메서드에서 해당 객체를 외부로 반환한다.
	-static이 없으면 외부클래스에서 반드시 새로운 객체를 생성해야하므로
	생성자에 접근할 수 없는 외부클래스에서는 SingleTone클래스 사용불가 
	 */
	
	public static SingleTone getInstance() {
		return single;
	}
	void print() {
		System.out.println(String.format("shareVar=%d", shareVar));
	}
}

public class E03SingleToneDesignPattern 
{
	public static void main(String[] args) 
	{
		/*
		일반적인 방식의 객체생성이므로 객체를 생성할 때마다 새로운
		참조값(주소값)을 할당받는 인스턴스가 된다.
		 */
		NoSingleTone nst1 = new NoSingleTone();
		nst1.instVar = 100;
		System.out.println("nst1="+nst1);
		System.out.println("nst1의 instVar="+nst1.instVar);
		
		
		NoSingleTone nst2 = new NoSingleTone();
		nst2.instVar = 200;
		System.out.println("nst2="+nst2);
		System.out.println("nst2의 instVar="+nst2.instVar);
		System.out.println("nst1의 instVar="+nst1.instVar);
		
		//SingleTone st1 = new SingleTon();
		
		SingleTone st2 = SingleTone.getInstance();
		st2.shareVar = 100;
		st2.print();
		
		SingleTone st3 = SingleTone.getInstance();
		st3.shareVar = 200;
		st3.print();
		
		System.out.printf("st2의주소:%s%n", st2);
		System.out.println(String.format("st3의주소:%s", st3));
		System.out.println(String.format("st2의 shareVar:%d", st2.shareVar));
		System.out.println(String.format("st3의 shareVar:%d", st3.shareVar));
		
	}
}
