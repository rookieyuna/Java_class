package quiz;

import java.util.Random;
/*
< 정렬알고리즘 - 선택정렬(selection sort)> 

1. 1~100 사이의 중복되지 않는 정수 10개의 난수를 생성하고 
	생성한 난수는 크기 10인 배열에 저장한다. 
2. 전체요소 중에서 최소값을 찾아 첫번째 자리와 교환한다.
3. 1회전을 수행하면 최소값이 맨 앞에 오게되므로 첫번째 
	자료를 제외한 나머지 자료에서 다시 최소값을 찾아 
	두번째 자리와 교환한다. (자료가 N개라면 교환은 (N-1)번 수행)
4. 단, 정렬되는 과정을 모두 출력해야 한다.
5. 위 그림은 선택정렬을 이용하여 오름차순으로 정렬하는 과정이다.

 */
class RandomNum2
{
	Random random = new Random();
	int[] intArr;

	public RandomNum2(int a)
	{
		intArr = new int[a];
		for (int i = 0; i<intArr.length; i++) { //번호부여
			intArr[i] = random.nextInt(99)+1;
			for (int j=0; j<i; j++) { //중복확인 방법
				if(intArr[i]==intArr[j])
					i--;
			}	
		}
	}
	
	public void showRandomNum()
	{
		for(Object obj: intArr) {
			System.out.print(obj+" ");
		}
		System.out.println();
	}
	
	public int[] getRandom() {
		return intArr;
	}
}

class SelectSort {
	
	int[] arr;
	
	public SelectSort(int[] numArr) {
		arr = numArr;
	}
	
	public void doSelect() {
		int min = 0; //최소 배열 인덱스 확인용 
		int temp = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			min = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[min]>arr[j]) {
					min=j;
				}
			}
			temp=arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
			
			for(Object obj: arr) {
				System.out.print(obj + " ");
			}
			System.out.println();
		}	
		
	}
}

public class QuSelectSort
{
	public static void main(String[] args)
	{
		RandomNum2 random = new RandomNum2(10);
		System.out.println("###최초난수###");
		random.showRandomNum();	
		
		System.out.println("\n###정렬과정###");
		new SelectSort(random.getRandom()).doSelect();
		
		System.out.println("\n###선택정렬###");
		random.showRandomNum();
	}
}
