package ex10accessmodifier;

//과일 판매자를 추상화한 클래스
class FruitSeller3 {
	//멤버변수
	public int numOfApple;//판매자가 보유한 사과개수
	public int myMoney;//판매수익
	public final int APPLE_PRICE; //사과의 단가
	
	public FruitSeller3(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		APPLE_PRICE = price;
	}
	
	//멤버메서드
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
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
class FruitBuyer3{
	
	public int myMoney; //보유한 금액
	public int numOfApple; //구매한 사과의 개수
	
	//초기화 메서드 선언
	public FruitBuyer3(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	
	public void buyApple(FruitSeller3 seller, int money) {
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
public class E02FruitSalesMain5
{
	public static void main(String[] args)
	{
		
		//판매자1 : 사과100개, 단가 1000원
		FruitSeller3 seller1 = new FruitSeller3(0, 100, 1000);
		
		//판매자2 : 사과 80개, 단가300원
		FruitSeller3 seller2 = new FruitSeller3(0, 80, 500);
		
		//구매자 : 보유금액 10000원
		FruitBuyer3 buyer = new FruitBuyer3(10000, 0);
		
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
	
		//////////////////////////////////
		/*
		아래의 코드는 문법적으로 오류는 없으나, 지불금액과 사과개수의 
		관계가 맞지 않는 논리적오류가 발생하였다.
		즉, 코드(메서드)로 구현한 규칙이 완전히 무너지므로
		객체지향 프로그래밍에서는 이런 오류를 막기 위해 멤버변수에 대한
		"정보 은닉"을 하도록 규정하고 있다.
		
		 */
		seller1.myMoney += 1000; 	//판매자1의 1000원 수익
		seller1.numOfApple -= 50; 	//판매자1의 사과 50개 감소
		buyer.numOfApple += 50; 	//구매자의 사과 50개 증가
		
		seller2.myMoney +=1000;		//판매자2의 1000원 수익
		seller2.numOfApple -=70;	//판매자2의 사과 70개 감소
		buyer.numOfApple +=70; 		//구매자 사과 70개 증가
									//하지만 구매자는 돈을 쓰지 않았지..
		
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		
		
		
	}
}
