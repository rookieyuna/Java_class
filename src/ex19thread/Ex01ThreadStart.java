package ex19thread;

/*
Thread(쓰레드)
-스레드의 생성은 Thread 클래스를 상속받는 것부터 시작한다.
-이 방법은 쓰레드로 생성할 클래스가 다른 클래스를 상속받지않아도 될 때 쓰는 방식
-만약 해당클래스가 다른 클래스를 상속해야한다면 Runnable 인터페이스를 구현
 */
class ShowThread extends Thread
{
	String threadName;
	public ShowThread(String name) {
		threadName =name;
	}
	/*
	run()메서드는 쓰레드의 main() 메서드에 해당한다.
	Thread클래스의 run()메서드를 오버라이딩 한것으로 run()메서드는
	직접 호출하면 안되고 start()메서드를 통해 간접적으로 호출해야 한다.
	(만약, 직접 호출하면 단순히 실행만 될 뿐 쓰레드가 생성되지 않음)
	 */
	
	@Override
	public void run()
	{
		for(int i=0; i<=100; i++) {
			System.out.println("안녕하세요. ["+threadName+"] 입니다.");
			try {
				/*
				Thread 클래스의 static메서드로 실행의 흐름을 주어진
				시간만큼 block상태로 전환시켜준다 
				(1000분의 1초 단위로 기술하므로 1000 입력시 1초임)
				 */
				sleep(10); // = 0.01초만큼 block
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


public class Ex01ThreadStart
{

	public static void main(String[] args)
	{
		//쓰레드 객체생성
		ShowThread st1 = new ShowThread("쓰레드1st");
		ShowThread st2 = new ShowThread("Thread2nd");
		
		//쓰레드 객체를 통한 쓰레드 생성 및 실행
		st1.start();
		st2.start();
		
		/*
		run()메소드를 통한 호출은 단순한 실행만 될 뿐 쓰레드 생성 불가
		첫번째 쓰레드객체의 작업이 완료된 후 두번째 쓰레드 동작
		 */
//		st1.run();
//		st2.run();
	}
}
