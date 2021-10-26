package quiz;

import java.util.Random;

public class QuBubbleSort2
{

	public static void main(String[] args)
	{
		Random random = new Random();
		int[] arr= new int[10];
		
		//중복되지않는 난수생성
		while(true) {
			
			for(int i=0; i<arr.length; i++) {
				arr[i] = random.nextInt(100);
			}
			boolean rndFlag = false; //중복체크
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					if(arr[i]==arr[j] && i!=j)
						rndFlag = true;
				}
			}
			if(rndFlag==false) break;
		}
		
		for(Object obj : arr) {
			System.out.print(obj + " ");
		}
		
		
		
		
		
		
		
		
		
	}

}
