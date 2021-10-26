package bokang.sub;

/*
체크카드 클래스 Ver.02

버전02에서 추가부분
	1. 멤버변수 초기화 메소드 정의 
		메소드명 : initMembers()
	2. 기본생성자, 인자생성자 정의
	3. 멤버변수 정보은닉
	4. getter/setter 메소드 추가
 */


public class CheckCard2
{
	private long cardNumber;//카드번호
	private String owner; //소유자
	private int balance; //잔액
	private int point; // 포인트
	
	//초기화메서드
	public void initMembers(long cardNumber, String owner, int balance,int point) {
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.balance = balance;
		this.point = point;
	}
	
	//기본(디폴트)생성자
	public CheckCard2() {}
	//인자생성자
	public CheckCard2(long cardNumber, String owner, int balance, int point)
	{
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.balance = balance;
		this.point = point;
	}
	/*
	멤버변수를 private로 선언하면 클래스 내부에서만 접근할 수
	있으므로 외부에서의 접근을 위해 getter/setter를 생성한다.
	 */
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
		this.balance += amount;
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
		this.point += (amount*0.1);
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
