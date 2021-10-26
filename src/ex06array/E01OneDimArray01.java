package ex06array;

public class E01OneDimArray01
{

	public static void main(String[] args)
	{
		/*
		자바에서는 배열을 객체를 통해 생성하게 된다.
		생성된 배열은 Heap(힙) 영역에 저장되고, 할당된 메모리의 주소값을
		반환한다. 그래서 배열명(배열변수)는 주소값(참조값)을 할당받게 된다.
		해당 주소를 통해 배열에 접근할 수 있다.
		 */
		//크기가 3인 정수형배열 선언
		int[] numArr = new int[3];
		//인덱스 0부터 배열 초기화
		numArr[0] = 10;
		numArr[1] = 20;
		numArr[2] = 30;
		//배열의 인덱스를 통한 접근으로 값 출력
		System.out.println("배열명(numArr)="+numArr);
		//Heap영역에 생성된 배열의 참조값(주소값) 출력
		System.out.println("numArr 2번방의 값: "+numArr[2]);
		System.out.println("===========================");
		
		
		/*
		배열의 선언 및 초기화
			:배열은 여려개의 변수를 사용하기 위해 선언하므로
			접근을 위해 일반적으로 반복문(for)을 사용한다.
		배열명.length
			: 해당 배열의 크기를 반환한다. 배열의 크기가 변경되는
			경우 유연하게 사용할 수 있다.
		 */
		int[] arrNumber = new int[40];
		//배열의 초기화: 0번방에 10을 삽입후 1씩 증가시키면서 초기화한다.
		for(int i=0; i<arrNumber.length; i++)
		{
			arrNumber[i]= i+10;
		}
		//length와 달리 배열의 크기가 변경되면 for문의 범위도 변경해야함
		for(int i=0; i<4; i++) 
		{
			//각 배열요소 출력
			System.out.println(i+"번방의값="+arrNumber[i]);
		}
		System.out.println("===========================");
		
		
		/*
		객체배열 : 기본자료형을 저장하는 배열이 아닌 객체의 참조값을
			저장할 용도로 생성하는 배열이다. 사용법은 동일하다.
		 */
		
		String[] strArr = new String[3];
		strArr[0] = "java";
		strArr[1] = "jsp";
		strArr[2] = "spring";
		for(int j=0; j<strArr.length; j++) 
		{
			System.out.println(strArr[j]);
		}
		System.out.println("===========================");
		
		System.out.println("배열의 선언과 초기화");
		System.out.println("방법1: 배열의 선언 이후 초기화");
		int[] initArr = new int[1];
		initArr[0] = 100;
		System.out.println("initArr[0]="+initArr[0]);
		
		/*
		배열의 선언과 동시에 초기화를 하는 경우 자바 컴파일러는
		초기값의 개수를 통해 배열의 개수를 알 수 있기에 배열의
		크기는 새 생략하도록 약속도되어있다 
		 */
		System.out.println("방법2: 배열의 선언과 동시 초기화");
		//int[] initArr2 = new int[3] {1, 20, 300} //에러발생
		int[] initArray2 = new int[] {1, 20, 300};
		
		/*
		배열 요소의 개수를 통해 배열을 생성한 후 초기화까지 동시에
		진행한다. 이 경우 new를 생략할 수 있다.
		 */
		System.out.println("방법3: 초기값만으로 선언");
		int[] initArr3 = {11, 13, 17, 19, 23}; //요소의 개수를 통해 크기 5로지정
		int arrSum = 0;
		//요소의 개수만큼 루프되면서 각 요소를 누적해서 더함.
		for(int x=0; x<initArr3.length; x++)
		{
			arrSum += initArr3[x];
		}
		System.out.println("배열요소의 합은="+arrSum);
		
		
	}
}
