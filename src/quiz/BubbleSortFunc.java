package quiz;

import java.util.Random;
import java.util.Scanner;

public class BubbleSortFunc
{
	//전역변수 형태로 생성하여 모든 메소드에서 접근가능
	static Random rnd = new Random();
	static Scanner scanner = new Scanner(System.in);
			
	public static void main(String[] args) {
		
		//1]중복되지 않는 난수 10개를 생성한다.
		int[] arr = new int[10];
		//난수생성후 arr배열에 저장하기 위한 메소드 호출
		randomCreate(arr);

		//2]생성된 난수를 통해 초기화된 배열을 출력한다.(정렬 전 출력)
		showArray(arr, "난수생성직후 배열출력");

		//3]정렬의 방법을 선택한다.(1.오름차순, 2.내림차순)
		int orderSelect = menuSelect();

		//4]버블정렬 알고리즘을 통한 정렬을 진행한다.
		bubbleSort(arr, orderSelect);

		//5]정렬된 결과를 출력한다(정렬 후 출력)
		showArray(arr, "버블정렬 이후 배열출력");
	}
	
	public static void bubbleSort(int[] arrParam, int ordSel) {

		//swap(자리변경)을 위한 임시변수 생성
		int temp, swapCount=1;

		/*
		크기가 10인 배열이므로 스캔은 9번만 반복하면 된다.
		즉, i의 증가치는 0~8까지 변하게 된다.
		 */
		for(int i=0 ; i<arrParam.length-1 ; i++) {
			/*
			실제 요소값에 대한 비교를 진행한다.
			버블정렬의 목적은 오름차순일때 큰 숫자를 제일뒤로 보내주는
			것이다. 즉 요소1과 요소2를 비교하여 요소1이 크다면
			서로 자리를 바꿔서 큰 숫자를 뒤로 보내준다.
			 */
			for(int j=0 ; j<(arrParam.length-1)-i ; j++) {
				/*
				j가0일때 : arrParam[0] > arrParam[1] 비교
				j가1일때 : arrParam[1] > arrParam[2] 비교
				.....
				 */
				if(ordSel==1) {//오름차순을 선택했을때
					if(arrParam[j] > arrParam[j+1]) {
						/*
						앞의 요소가 크다고 판단이 되면 서로 swap하여
						자리를 서로 바꿔서 큰 숫자를 뒤로 보내준다.
						 */
						temp = arrParam[j];
						arrParam[j] = arrParam[j+1];
						arrParam[j+1] = temp;

						//값의 변경이 있을때마다 배열전체 출력하기
						showArray(arrParam,"SWAP중(오름차순 정렬중):"+
								(swapCount++) + "회교환됨");
					}
				}
				else if(ordSel==2) {//내림차순을 선택했을때
					if(arrParam[j] < arrParam[j+1]) {
						/*
						앞의 요소가 작다고 판단이 되면 서로 swap하여
						자리를 서로 바꿔서 작은 숫자를 뒤로 보내준다.
						 */
						temp = arrParam[j];
						arrParam[j] = arrParam[j+1];
						arrParam[j+1] = temp;

						//값의 변경이 있을때마다 배열전체 출력하기
						showArray(arrParam,"SWAP중(내림차순 정렬중):"+
								(swapCount++) + "회교환됨");
					}
				}
			}
		}
	}//end of bubbleSort()
	
	
	public static int menuSelect() {

		System.out.println("정렬할 방법을 선택하세요");
		System.out.println("1.오름차순, 2.내림차순");
		return scanner.nextInt();
	}
	
	
	public static void showArray(int[] arr, String message) {

		System.out.println(message);
		for(int i=0 ; i<arr.length ; i++) {
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();
	}//end of showArray()

	public static void randomCreate(int[] arrParam) {
		
		//난수생성을 위한 씨드설정
		rnd.setSeed(System.currentTimeMillis());

		/*
		난수생성 방법1:
			1]난수 10개를 우선 생성한후 배열에 담아준다.
			2]배열 전체를 대상으로 중복확인을 한다.
			3]만약 중복되는 요소가 발견되면 다시 1번으로 돌아가서 난수를
			생성한다.
			4]중복되는 요소가 없다면 함수를 종료하고 메인으로 돌아간다.
		 */
		while(true) {

			//1.난수10개 생성후 배열담기
			for(int i=0 ; i<arrParam.length ; i++) {
				arrParam[i] = rnd.nextInt(99) + 1;//1~99까지의 정수 생성
			}

			//2.중복확인
			boolean rndFlag = false;/*중복체크를 위한 변수(false라면 중복된
				난수가 없는경우이고, 중복된 난수가 발견된다면 true로
				값을 변경할것임 */

			for(int i=0 ; i<arrParam.length ; i++) {
				for(int j=0 ; j<arrParam.length ; j++) {
					/*
					비교의 조건은 인덱스i와 인덱스j가 서로 다를때이다.
					인덱스가 동일하다면 같은숫자일테니까...
					 */
					if(i!=j && arrParam[i]==arrParam[j]) {
						//중복된 값이 발견된다면 true로 값을 변경
						rndFlag = true;
					}
				}
			}

			//3.중복된값이 없다면 break로 while루프 탈출하기
			if(rndFlag==false) break;

		}//end of while

	}//end of randomCreate()
}
