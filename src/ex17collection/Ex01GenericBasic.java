package ex17collection;

//오렌지를 표현한 클래스
class Orange {
	int sugar; //당도를 표현한 멤버변수

	public Orange(int sugar) {
		this.sugar = sugar;
	}
	public void showInfo() {
		System.out.println("오렌지의 당도는 "+sugar+"입니다.");
	}
}

//오렌지 전용 박스 클래스 : Orange객체만 저장하고 반환가능
class OrangeBox{
	Orange item;
	public void store(Orange item) {
		this.item = item;
	}
	public Orange pullOut() {
		return item;
	}
}

//모든 과일 박스 클래스 : Object 기반으로 모든 객체(과일) 저장 가능
class FruitBox{
	Object item;
	public FruitBox(Object item) {
		this.item = item;
	}
	public void store(Object item) {
		this.item = item;
	}
	public Object pullOut() {
		return item;
	}
}

public class Ex01GenericBasic {

	public static void main(String[] args)
	{
		/*
		OrangeBoxdp Orange 객체를 생성한 후 저장하고 정보를 출력
		 */
		OrangeBox oBox1 = new OrangeBox();
		Orange orange1 = new Orange(10);
		oBox1.store(orange1);
		orange1 = oBox1.pullOut();
		orange1.showInfo();
		
		/*
		상자1은 오렌지 전용박스이므로 다른 객체(과일)을 저장할 수 없음
		컴파일 에러가 발생하므로 실행자체가 불가
		-> 즉 자료형에는 안전하지만, 구현에는 불편함이 있음
		다른 객체를 저장하기 위해 또 다른 Box클래스를 만들어줘야함
		 */
		//oBox1.store("당도가 20인 오렌지");//잘못된 타입 입력으로 컴파일 에러발생
		Orange orange2 = oBox1.pullOut();
		orange2.showInfo();
		
		
		/*
		Object를 기반으로한 FruitBox 구현에는 편리하나 코드레벨에서
		에러가 발생하지 않으므로 오류를 찾아내기훨씬 더 어렵다ㅠㅠ
		자료형에는 안전하지 못한 코드가 된다.
		 */
		
		FruitBox fBox1 = new FruitBox(new Orange(20));
		Orange orange3 = (Orange)fBox1.pullOut();
		orange3.showInfo();
		
		FruitBox fBox2 = new FruitBox("당도가 30인 오렌지");
		Orange orange4 = (Orange)fBox2.pullOut();//실행은 되나 런타임 에러 발생
		orange4.showInfo();
		
	}
}
