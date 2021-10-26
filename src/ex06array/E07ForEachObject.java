package ex06array;

public class E07ForEachObject
{

	public static void main(String[] args)
	{
		String[] strArr = new String[] {
				"자바는 재미있다.",
				"자바는 유용하다.",
				"그러나 어렵다ㅜㅜ"
		};
		
		for(String e : strArr) {
			System.out.println(e);
		}
	}
}
