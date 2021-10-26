package bokang.sub;

/*
체크카드 클래스 Ver.03
	: initMembers 초기화 메소드는 삭제처리 
	
	1.충전은 10000원 단위로만 가능하다.
	만약 5000원을 충전하면 충전불능으로 처리한다.
	
	2.잔고가 부족하면 결제불능으로 처리해야 한다.
	
	3.생성자 오버로딩 처리
		new CheckCard3(카드번호, 소유자, 잔고, 포인트);
		new CheckCard3(카드번호, 소유자, 잔고); => 포인트 0으로 초기화
		new CheckCard3(카드번호, 소유자); => 잔고, 포인트 0으로 초기화
	
	4.포인트 적립율 변경
		10만원 이하결재 : 0.1%적립
		10만원 초과결재 : 0.3%적립
 */

public class CheckCard3
{
	private long cardNumber;
	private String owner; 
	private int balance;
	private int point; 
	
	//기본(디폴트)생성자
	public CheckCard3() {}
	//인자생성자
	public CheckCard3(long cardNumber, String owner)
	{
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.balance = 0;
		this.point = 0;
	}
	public CheckCard3(long cardNumber, String owner, int balance)
	{
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.balance = balance;
		this.point = 0;
	}
	public CheckCard3(long cardNumber, String owner, int balance, int point)
	{
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.balance = balance;
		this.point = point;
	}
	
	public long getCardNumber()
	{
		return cardNumber;
	}

	public void setCardNumber(long cardNumber)
	{
		this.cardNumber = cardNumber;
	}

	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	public int getBalance()
	{
		return balance;
	}

	public void setBalance(int balance)
	{
		this.balance = balance;
	}

	public int getPoint()
	{
		return point;
	}

	public void setPoint(int point)
	{
		this.point = point;
	}
	
	public void charge(int amount) {
		if(amount%10000 != 0) {
			System.out.println("충전불가! 만원단위만 충전가능");
		}
		else {
			this.balance += amount;
			System.out.println(amount+"원 충전완료");
		}
			
	}
	
	//결제
	public void payment (int amount) {
		if (this.balance<amount) {
			System.out.println("※한도초과로 결제실패");
		}
		else {
			this.balance -= amount;
			savingPoint(amount);
			System.out.println(amount+"원 결제완료");
			}
	}
	
	//적립
	public void savingPoint(int amount) {
		if(amount<=100000)
			this.point += (amount*0.1);			
		else
			this.point += (amount*0.3);
	}
	
	//현재상태출력
	public void showState() {
		System.out.println("######카드정보######");
		System.out.println("카드번호:"+ cardNumber);
		System.out.println("소유자:"+ owner);
		System.out.println("잔액:"+ balance);
		System.out.println("현재포인트:"+ point);
	}
}
