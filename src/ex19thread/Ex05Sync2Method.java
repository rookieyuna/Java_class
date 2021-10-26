package ex19thread;

//두개의 쓰레드가 공유객체로 사용할 클래스
class SumMulti2 {
	long num;
	public SumMulti2() {
		num=0;
	}
	
	/*
	synchronized 선언으로 인해 정확한 결과가 나오긴 하지만
	코드 실행시간이 길어지는 단점이 있다.
	즉 동기화는 성능의 감소를 초개하므로 필요한 부분만 동기화를
	처리해주는 것이 좋다.
	=>메서드를 동기화하는 법과 필요한 코드만 블럭처리하는 동기화방법이 있다.
	 */
	//동기화방법1: 동기화 메서드 (메서드에 synchronized 추가)
	//메서드 내 동기화가 불필요한 코드들까지 동기화 수행하므로 낭비
//	public synchronized void addNum(int n) {
//		num += n;
//	}
	
	//동기화방법2: 동기화 블럭(조금 더 좋은 성능)
	public void addNum(int n) {
		synchronized (this) {num += n;}
	}
	
	public long getNum() {
		return num;
	}
}

class MultiAdderThread2 extends Thread{
	SumMulti2 sumInst; //위의 공유객체를 멤버변수로 선언
	int start, end;
	public MultiAdderThread2(SumMulti2 sumInst, int start, int end) {
		this.sumInst = sumInst;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		for(int i=start; i<=end; i++) {
			sumInst.addNum(i);
		}
	}
}

public class Ex05Sync2Method {
	
	public static void main(String[] args) {
		//공유객체로 사용할 객체를 하나만 생성
		SumMulti2 s = new SumMulti2();
		MultiAdderThread2 mat1 = new MultiAdderThread2(s, 1, 500000);
		MultiAdderThread2 mat2 = new MultiAdderThread2(s, 500001, 1000000);
		mat1.start();
		mat2.start();
		
		try {
			mat1.join();
			mat2.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1~1000000까지의 합: "+s.getNum());
	}
}
