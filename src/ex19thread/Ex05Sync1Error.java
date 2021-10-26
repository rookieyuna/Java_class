package ex19thread;

//두개의 쓰레드가 공유객체로 사용할 클래스
class SumMulti {
	int num;
	public SumMulti() {
		num=0;
	}
	//매개변수로 전달되는 n을 멤버변수 num에 누적해서 더함
	public void addNum(int n) {
		num += n;
	}
	public int getNum() {
		return num;
	}
}

class MultiAdderThread extends Thread{
	SumMulti sumInst; //위의 공유객체를 멤버변수로 선언
	int start, end;
	public MultiAdderThread(SumMulti sumInst, int start, int end) {
		this.sumInst = sumInst;
		this.start = start;
		this.end = end;
	}
	/*
	쓰레드를 통해 반복적인 공유객체인 sumInst의 addNum()을 호출한다.
	따라서, 두개의 쓰레드가 동시에 접근되는 경우가 발생하게 되는데
	아직 동기화가 처리되지 않아 잘못된 결과가 출력되기도 한다.
	 */
	@Override
	public void run() {
		for(int i=start; i<=end; i++) {
			sumInst.addNum(i);
		}
	}
}

public class Ex05Sync1Error {
	
	public static void main(String[] args) {
		//공유객체로 사용할 객체를 하나만 생성
		SumMulti s = new SumMulti();
		MultiAdderThread mat1 = new MultiAdderThread(s, 1, 5000);
		MultiAdderThread mat2 = new MultiAdderThread(s, 5001, 10000);
		mat1.start();
		mat2.start();
		
		try {
			mat1.join();
			mat2.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1~10000까지의 합: "+s.getNum());
	}
}
