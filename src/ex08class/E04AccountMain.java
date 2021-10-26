package ex08class;
/*
시나리오]은행계좌를 추상화 해보자.
-멤버변수 : 예금주, 계좌번호, 잔고
-멤버메서드 : 입금하다, 출금하다, 계좌잔고조회
-조건1 : 입금은 무제한으로 가능함
-조건2 : 잔고가 부족한 경우에는 출금 불능 처리
 */

class Account {
	//멤버변수
	String name; //예금주
	String accountNumber; //계좌번호
	int balance;//잔고
	
	//멤버메소드
	//입금처리: 매개변수로 전달되는 금액만큼 입금처리한다.
	void deposit(int money) {
		balance += money;
		System.out.println(money+"원이 입금됨");
	}
	//출금처리
	void withdraw(int money) {
		//출금할 금액이 잔고보다 작거나 같은 경우에만 출금처리
		if(balance >= money) {
			balance -= money;
			System.out.println("계좌에서"+money+"원이 출금됨");
		}
		else {
			System.out.println("잔고부족으로 출금불능");
		}
	}
	void showAccount() {
		System.out.println("계좌주:"+name);
		System.out.println("계좌번호:"+accountNumber);
		System.out.println("잔고:"+balance);
	}
	//멤버변수 초기화 메서드
	void init(String n, String a, int b) {
		name = n;
		accountNumber = a;
		balance = b;
	}
}

public class E04AccountMain
{

	public static void main(String[] args)
	{
		//첫번째 통장 개설 : 멤버메서드를 통해 멤버변수 초기화 및 입출금 처리
		Account account = new Account();
		account.init("장동건", "111-21-8888", 1000);
		account.deposit(9000);
		account.withdraw(5000);
		account.showAccount();
		
		System.out.println();
		
		//두번째 통장 개설 : 멤버변수에 직접 접근해서 초기화
		Account account2 = new Account();
		account2.name ="정우성";
		account2.accountNumber= "123-45-67890";
		account2.balance = 900000;
		account2.showAccount();
	}

}
