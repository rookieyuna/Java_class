package quiz;

import java.util.Random;

/*
< 정렬알고리즘 - 버블정렬(Bubble Sort)> 

1. 중복되지 않는 난수 10개(1~99)를 생성하여 크기가 10인 배열에 담는다.
2. 오름차순으로 버블정렬한다.(1, 2, 3 …… 10)
3. 버블정렬이란 모든 배열요소를 순차적으로 비교하여 스왑(교환)하는 알고리즘이다.
4. 단, 정렬되는 과정을 모두 출력해야 한다.
5. 위 그림은 버블정렬을 이용하여 오름차순으로 정렬하는 과정이다.

 */
class RandomNum 
{
	Random random = new Random();
	int[] intArr;

	public RandomNum(int a)
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

class BubbleSort
{
	int[] numArr;
	public BubbleSort(int[] numArr)
	{
		this.numArr = numArr;
	}
	
	public void doBubble()
	{
		int temp = 0;
		for(int i=0; i<numArr.length; i++) { //난수개수만큼 반복
			for(int j=0; j<numArr.length-i-1; j++) { //차례로 숫자 비교 후 switch
				if(numArr[j]>numArr[j+1]) {
					temp = numArr[j+1];
					numArr[j+1] = numArr[j];
					numArr[j] = temp;
				}
			}
			for(Object obj: numArr) { 
				System.out.print(obj+" ");
			}
			System.out.println();
		}
	}
}

public class QuBubbleSort
{
	public static void main(String[] args)
	{
		RandomNum random = new RandomNum(10);
		BubbleSort bubble = new BubbleSort(random.getRandom());
		
		System.out.println("###최초난수###");
		random.showRandomNum();
		
		System.out.println("\n###정렬과정###");
		bubble.doBubble();
		
		System.out.println("\n###버블정렬###");
		random.showRandomNum();
	}
}

