package ex19thread;
/*
[쓰레드의 우선순위]
-setPriority(우선순위): 쓰레드의 우선순위를 지정할 때
-getPriority(우선순위): 쓰레드의 우선순위를 반환할 때

우선순위 입력: MAX_PRIORITY(10), NORM_PRIORITY(5), MIN_PRIORITY(1)
 */
class MessageSendingTread extends Thread
{
	String message;

	public MessageSendingTread(String message) 
	{
		this.message = message;
	}
	public MessageSendingTread(String message, int pri) 
	{
		this.message = message;
		setPriority(pri);
	}
	public void run()
	{
		for(int i=0; i<=1000; i++)
		{//각 쓰레드당 1000번씩 반복출력하며 우선순위 출력
			System.out.println(message +" "+ i +"("+getPriority()+")");
			
			try {
				sleep(1);//0.001초 동안 블럭상태
			}
			/*
			기본적으로 우선순위가 높은 쓰레드가 먼저 실행되지만
			sleep()메서드를 사용하게되면 잠깐씩 블럭상태로 전환
			->우선순위가 낮은 쓰레드도 가끔 실행되는 상황발생
			 */
			catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}


public class Ex02Priority 
{
	
	public static void main(String[] args) 
	{
		
		/*
		1단계-우선순위를 부여하지 않을경우
			:동일한 우선순위 5 부여하여 CPU가 알아서 작업을 분배
		 */
//		MessageSendingTread tr1 = new MessageSendingTread("첫번째");
//		MessageSendingTread tr2 = new MessageSendingTread("Second");
//		MessageSendingTread tr3 = new MessageSendingTread("333333");

		/*
		2단계-정수를 사용하여 우선순위 부여
			: 우선순위는 1~10으로 부여할수 있고 높을수록 높은우선순위
			단, 우선순위가 높다고 무조건 먼저실행되는 것은 아님.
		 */
//		MessageSendingTread tr1 = 
//				new MessageSendingTread("첫번째", 10);
//		MessageSendingTread tr2 = 
//				new MessageSendingTread("Second", 5);
//		MessageSendingTread tr3 = 
//				new MessageSendingTread("333333", 1);
	
		/*
		3단계-정적상수를 사용하여 우선순위 부여
		: 객체생성없이 바로 접근 가능하며 2단계와 결과는 동일  
		ex) Thread.MAX_PRIORITY, NORM_PRIORITY, MIN_PRIORITY
		
		 */
		MessageSendingTread tr1 = 
				new MessageSendingTread("첫번째", Thread.MAX_PRIORITY);
		MessageSendingTread tr2 = 
				new MessageSendingTread("Second", Thread.NORM_PRIORITY);
		MessageSendingTread tr3 = 
				new MessageSendingTread("333333", Thread.MIN_PRIORITY);
		
		tr1.start();
		tr2.start();
		tr3.start();
	}
}
