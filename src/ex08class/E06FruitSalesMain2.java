package ex08class;
/*
FruitSalesMain 이전 버전은 각 클래스가 멤버변수의 초기값이
고정되어, 상태가 다른 객체를 생성할 수 없는 단점이 있었다.
두번째 버전에서는 다양한 초기값을 부여할 수 있도록 초기화 메서드를 도입했다.
 */

//과일 판매자를 추상화한 클래스
class FruitSeller2 {
	//멤버변수
	int numOfApple;//판매자가 보유한 사과개수
	int myMoney;//판매수익
	int apple_price; //사과의 단가
	/*
		apple_price를 기존 상수에서 일반 변수로 변경한다.
		클래스의 멤버상수르 정의하는 경우 선언과 동시에 초기화해야하므로
		상수의 초기값이 없는 형태로는 선언 자체가 불가능하다.
	 */
	
	/*
	초기화 메소드를 선언하여 객체 생성 후 다양한 형태의 초기화가 가능
	※상수값은 단 한번만 초기화가 가능하기때문에 개발자가 원할떄 언제든 
	호출하는 멤버메서드와 특성이 맞지 않는다.
	 */
	public void initMembers(int money, int appleNum, int price	) {
		myMoney = money;
		numOfApple = appleNum;
		apple_price = price;
	}
	
	//멤버메서드
	public int saleApple(int money) {
		int num = money / apple_price;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	public void showSaleResult() {
		System.out.println("[판매자]남은 사과 갯수:"+numOfApple);
		System.out.println("[판매자]판매수익:"+myMoney);
	}
}

//과일 구매자를 추상화한 클래스
class FruitBuyer2{
	
	int myMoney; //보유한 금액
	int numOfApple; //구매한 사과의 개수
	
	public void initMembers(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	
	public void buyApple(FruitSeller2 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	//구매자의 현재상태 출력
	public void showBuyResult() {
		System.out.println("[구매자]사과갯수:"+numOfApple);
		System.out.println("[구매자]현재잔액:"+myMoney);
	}
}

//프로그램의 출발점이 되는 메인 클래스
public class E06FruitSalesMain2
{
	public static void main(String[] args)
	{
		/*
		초기화 메서드가 정의되었으므로 상태가 다른 객체를 생성할 수 있다.
		 */
		
		//판매자1 : 사과100개, 단가 1000원
		FruitSeller2 seller1 = new FruitSeller2();
		seller1.initMembers(0, 100, 1000);
		
		//판매자2 : 사과 80개, 단가300원
		FruitSeller2 seller2 = new FruitSeller2();
		seller2.initMembers(0, 80, 500);
		
		//구매자 : 보유금액 10000원
		FruitBuyer2 buyer = new FruitBuyer2();
		buyer.initMembers(10000, 0);
		
		System.out.println("구매행위가 일어나기전 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		//판매자1, 판매자2에게 각각 5000원 지불하고 구매
		buyer.buyApple(seller1, 5000);
		buyer.buyApple(seller2, 5000);
		
		System.out.println("구매행위가 일어난 후 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
	}
}
