package ex06array;

public class E06ArrayInit
{

	public static void main(String[] args)
	{
		/*
		1차원, 2차원 배열은 크기가 지정된 경우에는 전체요소가 0으로 초기화.
		
		 */
		int[] arr = new int[3];
		System.out.println("arr[0]=" + arr[0]); // 0 출력
		
		int[][] arr2 = new int[3][4];
		System.out.println("arr2[0][0]=" + arr2[0][0]);// 0 출력
		
		/*
		1차원 배열의 경우 요소의 갯수에 의해 전체 크기가 결정된다.
		2차원 배열도 마찬가지이나 다른점은 가장 큰 요소의 개수에 의해 크기가
		결정되므로, 빈공간이 발생할 수 있다. 이때 빈 공간은 0으로 채울 수없고
		null로 채워지게 된다.
		즉, 배열의 크기에서 제외되는 부분이 발생된다.
		 */
		
		int[] arrDim = {1,2,3};
		System.out.println("arrDim[0]=" + arrDim[0]);
		
		int[][] arr2Dim = {
				{1},
				{2,3}
		};
		System.out.println("arr2Dim[0][0]=" + arr2Dim[0][0]); //1 출력
		System.out.println("arr2Dim[0][1]=" + arr2Dim[0][1]);
					//null값이므로 출력이 불가능. 예외상황 발생
	}
}
