package ex07string;

public class E02StringMethod
{

	public static void main(String[] args)
	{
		System.out.println("[String 클래스의 주요 메소드]");
		
		String str1 = "Welcom to Java";
		String str2 = "자바야 놀자!";
		
		/*
		1] int length() : 문자열의 길이를 반한다.
		 */
		System.out.println("\n### length() ###");
		System.out.println("str1의 길이"+str1.length());
		System.out.println("str2의 길이"+str2.length());
		
		/*
		2] char charAt(int index) : 문자열에서 특정 index에 해당하는 문자 
			하나를 반환한다. index는 배열과 같이 0부터 시작한다.
		 */
		System.out.println("\n### charAt() ###");
		System.out.println("str1의 두번째 문자:"+str1.charAt(1));
		System.out.println("str2의 두번째 문자:"+str2.charAt(1));
		System.out.println("str1의 두번째 문자:"+str1.codePointAt(1));
		
		
		/*
		시나리오] 주민등록번호를 이용하여 성별을 판단하는 프로그램 작성
			190419-3000000 =>남자
			190419-4000000 =>여자
		 */
		String juminNum = "190419-2000000";
		//문자열에서 문자 하나를 뽑아 비교하므로 '(싱클쿼테이션)을 사용해야함
		if(juminNum.charAt(7)=='1' || juminNum.charAt(7)=='3') {
			System.out.println("남자입니다");
		}
		else if(juminNum.charAt(7)=='2' || juminNum.charAt(7)=='4') {
			System.out.println("여자입니다");
		}
		else if(juminNum.charAt(7)=='5' || juminNum.charAt(7)=='6'){
			System.out.println("외국인입니다");
		}
		else {
			System.out.println("주민번호가 잘못되었습니다.");
		}
		
		/*
		3] codePointAt(int index)
			: 문자열에서 특정 index에 해당하는 문자의 아스키코드/유니코드 값을
			반환한다.
		 */
		System.out.println("\n### codePointAt() ###");
		System.out.println("str1 첫번째문자 아스키코드:"+str1.codePointAt(0));
		System.out.println("str2 첫번째문자 아스키코드:"+str2.codePointAt(0));
		
		/*
		4] compareTo()
			: 두 문자열의 첫번째 문자부터 순차적으로 비교하면서
			앞 문자열의 아스키코드가 크면 양수를 반환하고
			뒷 문자열의 아스키코드가 크면 음수를 반환한다.
			두 문자열이 같을 때는 0을 반환한다.
		 */
		System.out.println("\n### compareTo() ###");
		String str3 = "A";
		String str4 = "AC";
		System.out.println(str1.compareTo(str2));//-1
		System.out.println(str4.compareTo(str3));//1
		System.out.println("ABC".compareTo("ABC")==0?
				"문자열이 같다": "문자열이 다르다");
		
		/*
		5] concat() 
			: 두개의 문자열을 연결할 때 사용 "+"기호와 동일한 역할
		 */
		System.out.println("\n### concat() ###");
		System.out.println("JAVA".concat("WORLD").concat(" Go"));
		System.out.println("JAVA"+"WORLD"+" GO");
		
		/*
		6] contains() //문자열에 특정 문자열 포함여부 확인 후 True/False 반환
		 */
		System.out.println("\n### contains() ###");
		System.out.println(str1.contains("To"));
		System.out.println(str1.contains("to"));
		
		/*
		시나리오] 해당 문자열이 이메일 형식인지 검사하는 프로그램 작성
			hong@kosmo.co.kr => 이메일형식임
			not@naver => 이메일 형식아님
		 */
		String email1 = "hong@kosmo.co.kr";
		if(email1.contains("@")&&email1.contains("."))
			System.out.println("이메일 형식임");
		else
			System.out.println("이메일 형식아님");
		
		/*
		7] boolean endsWith(String) //해당 문자열로 끝나면 True 반환
		8] boolean startsWith(String) //해당 문자열로 시작하면 True 반환
		 */
		System.out.println("\n### endWith()/startsWith() ###");
		System.out.println("www.daum.net".endsWith("net"));
		System.out.println("naver.com".startsWith("http"));
		
		/*
		9]String format(printf()형식)
			: 출력형식을 지정하여 문자열로 반환하고 싶을때 사용한다.
			printf()와 사용법은 동일하고, 주로 웹애플리케이션(JSP)를
			제작할 때 사용된다.
		 */
		System.out.println("\n### format() ###");
		System.out.printf("국어:%d, 영어:%d, 수학%d%n", 81,92,100);
		
		String formatStr= String.format("국어:%d, 영어:%d, 수학%d%n", 81,92,100);
		System.out.println(formatStr);
		
		/*
		10] int indexOf(String) // JSP에서도 사용하는 함수
			: 특정문자열이 시작하는 인덱스값 반환. 없을경우 -1 반환
		 */
		System.out.println("\n### indexOf() ###");
		System.out.println(str1.indexOf("ava"));
		System.out.println(str1.indexOf("J"));
		System.out.println(email1.indexOf("@")!=-1 ? 
				"이메일형식맞음" : "이메일형식아님");
		/*
		시나리오] 주민등록번호를 indexOf()메소드를 사용하여 성별을
		구분하는 프로그램을 작성하시오.
		 */
		System.out.println("\n### indexOf()로 성별 확인하기###");
		juminNum = "120403-3012345";
		int index = juminNum.indexOf("-") + 1; //'-' 다음에 있는 숫자 위치
		//위에서 찾은 인덱스를 통해 문자를 가져와서 구분함
		if(juminNum.charAt(index)=='3') {
			System.out.println("남자");
		}
		else {
			System.out.println("여자");
		}
		
		/*
		11] int lastIndexOf(String)
			: 사용법은 indexOf()와 동일하지만 문자열의 뒤에서부터 인덱스 탐색
		 */
		System.out.println("\n### lastIndexOf() ###");
		System.out.println(str1.lastIndexOf("ava"));
		System.out.println(str1.lastIndexOf("J"));
		System.out.println("indexOf:"+str1.indexOf("a"));
		System.out.println("lastIndexOf:"+str1.lastIndexOf("a"));
		
		/*
		12] replace(String, String) //
			: 특정 문자열을 찾아서 지정된 문자열로 변경
			찾는 문자열이 없는 경우 변경되지 않으나 에러도 발생하지 않음
			ex)ID마스킹처리 등 kosmo-> k####, 사용빈도가 높음
		 */
		System.out.println("\n### replace() ###");
		System.out.println("J를 G로 변경하기");
		System.out.println(str1.replace("J","G"));
		System.out.println("java를 KOSMO로 변경하기");
		System.out.println(str1.replace("java","KOSMO"));
		
		/*
		13] String[] split("")
			: 문자열을 구분자를 통해 분리해서 String배열로 반환한다.
			해당 구분자가 없는 경우에는 크기가 1인 배열로 반환된다.
		 */
		System.out.println("\n### split() ###");
		String phoneNumber = "010-1234-5678";
		String[] phoneArr = phoneNumber.split("-");
		for(int i=0; i<phoneArr.length; i++)
		{
			System.out.printf("phoneArr[%d]=%s\n", i, phoneArr[i]);
		}
		phoneArr = phoneNumber.split("%");
		for(int i=0; i<phoneArr.length; i++)
		{
			System.out.printf("phoneArr[%d]=%s\n", i, phoneArr[i]);
		}
		
		/*
		14] String substring(int beginIndex, (int endIndex))
			: 문자열을 자를 때 사용하는 메소드로 시작index부터
			문자열의 끝 혹은 endIndex-1까지 반환한다.
			-오버로딩 메서드로 인자값을 한개입력할때와 두개입력할때 다름 
			-endIndex 입력 시 마지막index 문자는 반환하지 않는다.
		*/
		System.out.println("\n### substring() ###");
		System.out.println(str1.substring(3));	
		System.out.println(str1.substring(3,7));
		
		/*
		시나리오] 다음 파일명에서 확장자를 잘라내는 프로그램을 작성하시오.
		파일명: my.file.images.jpg
		 */
		String filename = "my.file.images.jpg";
		//파일명의 뒷부분부터 . 의 위치를 찾아낸다.
		int beginIndex = filename.lastIndexOf(".")+1;
		System.out.println("파일의 확장자는 "+ filename.substring(beginIndex));
		
	}	
}
