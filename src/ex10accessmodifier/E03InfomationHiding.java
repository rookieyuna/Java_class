package ex10accessmodifier;

class FruitSeller6 {

	//외부클래스에서 접근할 수 없도록 private로 선언한다.
	private int numOfApple;
	private int myMoney;
	private final int APPLE_PRICE;
	
	public FruitSeller6(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		APPLE_PRICE = price;
	}
	
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


class FruitBuyer6{
	
	//외부클래스에서 접근할 수 없도록 private로 선언한다.
	private int myMoney;
	private int numOfApple;
	
	public FruitBuyer6(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	
	public void buyApple(FruitSeller6 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	
	public void showBuyResult() {
		System.out.println("[구매자]사과갯수:"+numOfApple);
		System.out.println("[구매자]현재잔액:"+myMoney);
	}
}

public class E03InfomationHiding
{
	public static void main(String[] args)
	{
		
		//판매자1 : 사과100개, 단가 1000원
		FruitSeller6 seller1 = new FruitSeller6(0, 100, 1000);
		
		//판매자2 : 사과 80개, 단가300원
		FruitSeller6 seller2 = new FruitSeller6(0, 80, 500);
		
		//구매자 : 보유금액 10000원
		FruitBuyer6 buyer = new FruitBuyer6(10000, 0);
		
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
		멤버변수를 private로 선언하면 클래스 외부에서 접근이 불가능하므로
		아래코드는 모두 에러가 발생하게 된다.
		즉, 멤버변수의 정보은닉을 통해 비정상적인 접근을 차단하고,
		멤버메서드를 통해서만 정상적인 접근(사과구매)를 할 수 있도록 한다.
	
		seller1.myMoney += 1000; 	//판매자1의 1000원 수익
		seller1.numOfApple -= 50; 	//판매자1의 사과 50개 감소
		buyer.numOfApple += 50; 	//구매자의 사과 50개 증가
		
		seller2.myMoney +=1000;		//판매자2의 1000원 수익
		seller2.numOfApple -=70;	//판매자2의 사과 70개 감소
		buyer.numOfApple +=70; 		//구매자 사과 70개 증가
									//하지만 구매자는 돈을 쓰지 않았지..
		 */
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
	}
}
