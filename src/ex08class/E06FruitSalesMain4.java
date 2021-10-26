package ex08class;


class FruitSeller4 {
	int appleCnt;
	int balance;
	final int APPLE_PRICE;
	
	public FruitSeller4(int appleCnt, int balance) 
	{
		this.appleCnt = appleCnt;
		this.balance = balance;		
		APPLE_PRICE = 1000;
	}
	
	public int appleSell (int money)
	{
		int num = money/APPLE_PRICE;
		appleCnt -= num;
		balance += money;
		
		return num;
	}
	
	void showSeller()
	{
		System.out.println("[Seller]사과개수:"+appleCnt);
		System.out.println("[Seller]판매금액:"+balance);
	}	
}


class FruitBuyer4 {
	
	int appleCnt = 0;
	int money;
	
	public FruitBuyer4(int myMoney)
	{
		money = myMoney;
	}
	
	public void applebuy (FruitSeller4 seller, int money)
	{
		appleCnt = seller.appleSell(money);
		this.money -= money;
	}
	
	void showBuyer()
	{
		System.out.println("[Buyer]사과개수:"+appleCnt);
		System.out.println("[Buyer]남은돈:"+money);
	}	
}


public class E06FruitSalesMain4
{
	public static void main(String[] args)
	{
		FruitSeller4 seller = new FruitSeller4(100, 0);
		FruitBuyer4 buyer = new FruitBuyer4(12000);
		System.out.println("==거래전==");
		seller.showSeller();
		buyer.showBuyer();
		
		buyer.applebuy(seller, 5000);
		System.out.println("==거래후==");
		seller.showSeller();
		buyer.showBuyer();
		
	}
}
