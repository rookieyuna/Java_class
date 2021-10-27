package ex19thread;

/*
1. 쓰레드로 구현하지 않은 클래스
	: 하나의 클래스가 작업을 끝내야 다음 클래스의 작업 진행가능
	즉, 동시에 작업을 진행할 수 없다.
 */
class NotThread
{
	String title;
	public NotThread(String title) 
	{
		this.title = title;
	}
	void notThreadMethod() 
	{
		for(int i=1; i<=10; i++)
		{
			System.out.println(String.format("%s]i=%d", title, i));
		}
	}
}

/*
2. 독립쓰레드(Non Daemon Thread)
	: 메인쓰레드와 working쓰레드(개발자가 정의한 쓰레드)를 일컫는 것
	메인쓰레드가 종료되어도 계속 실행되며, dead상태가 되어야 실행종료
 */
class YesThread extends Thread
{
	/*
	쓰레드 생성 시 이름을 지정하지 않으면 JVM이 자동으로 이름 부여
	Thread클래스 생성자 호출시 전달하는 매개변수를 통해 이름 지정 가능
	지정된 이름은 getName() 메서드를 통해 반환 가능
	 */
	public YesThread() {}
	public YesThread(String threadName) {
		super(threadName);
	}
	
	void threadMethod() throws InterruptedException{
		for(int i=1; i<=10; i++) {
			System.out.println(String.format("%s]i=%d", getName(), i));
			//2초마다 블럭상태 진입
			sleep(2000);
		}
	}
	@Override
	public void run() {
		try {
			threadMethod();
		}
		catch (InterruptedException e) {}
	}
}

/*
3. 종속쓰레드(Daemon Thread)
	- 모든 독립쓰레드가 종료되면 자동으로 종료되는 쓰레드
	(메인메서드도 하나의 독립쓰레드이므로, 다른 독립쓰레드가
	남아있다면 모두 종료될 때까지 종속쓰레드는 유지됨)
	-주로 프로그램이 보조역할로 배경음악, 로그자동저장 등을 처리
	-프로그램이 종료될때 자동으로 종료되므로 주로 무한루프로 구성
	-setDaemon(true);로 설정
 */
class DaemonThread extends Thread
{
	@Override
	public void run() {
		while(true) {
			System.out.printf("[쓰레드명:%s]Jazz가 흘러요~%n",getName());
			
			try {
				sleep(3000);
				System.out.println("3초마다 자동저장!!");
			}
			catch (InterruptedException e) {
				System.out.println("자동저장 시 오류발생 ㅠㅠ");
			}
		}
	}
}

public class Ex03DaemonThread 
{
	public static void main(String[] args) 
	{
		/*
		쓰레드로 구현하지 않은 클래스의 작업
		: 1번객체 작업 종료 후 2번 객체 실행(즉, 순차실행)
		 */
		NotThread nt1 = new NotThread("첫번째 클래스");
		nt1.notThreadMethod();
		
		NotThread nt2 = new NotThread("두번째 클래스");
		nt2.notThreadMethod();
		
		/*
		독립쓰레드 실행 
		 */
		YesThread yt1 = new YesThread("1st 쓰레드"); //이름부여방법1-생성자
		yt1.setName("첫번째쓰레드"); //이름부여방법2-setName()메서드 활용
		yt1.start();
		
		YesThread yt2 = new YesThread(); //이름부여방법3-자동부여
		yt2.setPriority(Thread.MAX_PRIORITY);
		yt2.start();
		
		/*
		데몬쓰레드(종속쓰레드) 실행
		 */
		
		DaemonThread dt = new DaemonThread();
		//dt.setName("난 데몬쓰레드");
		dt.setDaemon(true); 
		//★★독립->데몬쓰레드로 만들어주는 메서드
		//설정안하면 무한루프라서 프로그램이 멈추지않아유..
		dt.start();
		
		//Thread클래스의 정적메서드를 통해 여러정보 확인
		System.out.println("활성화된 상태의 쓰레드 수"
				+Thread.activeCount());
		System.out.println("실행중인 쓰레드 명"
				+Thread.currentThread());
		System.out.println("메인함수의 우선순위"
				+Thread.currentThread().getPriority());
		System.out.println("메인함수(Main Thread)종료");
	}
}
