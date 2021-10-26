package ex06array;

public class E05TwoDimArray02
{
	public static void main(String[] args)
	{
		//세로크기3, 가로크기 4인 2차원 배열 선언
		int[][] arr2Dim = new int[3][4];
		
		//각 행과 열의 크기만큼 반복하면서 초기화 진행
		for(int i=0; i<arr2Dim.length; i++) {
			for(int j=0; j<arr2Dim[i].length; j++) {
				arr2Dim[i][j] = i + j;
				System.out.print(arr2Dim[i][j]+ " ");
			}
			System.out.println();
		}
		
	/*
	시나리오] 다음 절차에 따라 프로그램을 작성하시오.
	1. 2차원 배열을 선언한다. 세로2 가로4
	2. 난수를 이용하여 배열을 초기화 한다. (난수 1~100)
	3. 배열전체요소를 매개변수로 전달된 정수만큼 증가시킨다.
	4. 증가되기 전, 후 배열을 출력한다.
	5. 다음 메소드명으로 구현한다. twoDimPlus() 
	 */
		
		int[][] twoArray = new int [2][4];
		
		for(int i=0; i<twoArray.length; i++) {
			for(int j=0; j<twoArray[i].length; j++) {
				twoArray[i][j] = (int)(Math.random()*100);
			}
		}
		
		System.out.println("==초기화 후===================");
		showArray(twoArray);
		twoDimPlus(twoArray, 10);
		System.out.println("\n==메소드호출 후==============");
		showArray(twoArray);
	}	
	
	//2차원배열 출력용 메소드
	static void showArray(int[][] arr2)
	{
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.printf("%-3d", arr2[i][j]);
			}
		}
	}
	//2차원배열에 전달된 매개변수만큼 각 요소를 증가시키는 메소드
	static void twoDimPlus(int[][] arr2, int plusNum)
	{
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				//해당요소를 plusNum만큼 증가시킨다.
				arr2[i][j] += plusNum;
			}
		}
	}
}
