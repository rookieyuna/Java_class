package ex06array;

public class E02ArrayAndMethod
{

	public static void main(String[] args)
	{
		//배열을 선언과 동시에 초기화. 요소의 개수를 통해 크기 결정됨
		int[] arr = {1,2,3,4,5};
		//배열변수만 선언된 상태
		int[] ref;
		System.out.println("초기화 직후 출력");
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		/*
		배열명을 매개변수로 전달하는 것은 배열의 참조값(주소값)을
		전달하는 것이다. 정수의 경우는 해당 값이 그대로 전달된다.
		※ 메소드에 배열 주소값만 전달할뿐 배열을 구분하진 않음.
		 */
		ref = addAllArray(arr,7);
		
		/*
		addAllArray() 메서드에서 반환한 값은 처음에 전달했던 배열의
		주소값이므로, 결과적으로 ref도 동일한 배열을 참조하게 된다.
		 */
		
		System.out.println("메소드 호출 후 출력");
		for(int i=0; i<ref.length; i++)
		{
			System.out.print(ref[i] + " "); // 8 9 10 11 12 출력됨
		}
		System.out.println();
		for(int i=0; i<ref.length; i++)
		{
			System.out.print(arr[i] + " "); // 8 9 10 11 12 출력됨
		}
	}
	/*
	매개변수로 전달된 참조값을 ar이 받게되므로 결국 동일한 배열을
	참조하게 된다. 즉 main()메서드에서 생성한 배열과 동일한 배열을
	참조하게 되는 것이다.
	 */
	static int[] addAllArray(int[] ar, int addVal)
	{
		for(int i=0; i<ar.length; i++)
		{
			ar[i] += addVal;
			
			/*
			위 복합대입 연산자를 풀어서 쓰면 다음과 같다.
			ar[i] = ar[i] + addVal
			즉, 배열의 i번째 요소에 addVal(7)을 더한 후 다시 대입한다.
			 */
		}
		return ar;
	}
}
