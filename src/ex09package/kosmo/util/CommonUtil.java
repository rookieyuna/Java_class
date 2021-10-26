package ex09package.kosmo.util;

public class CommonUtil
{
	/*
	전달된 문자열을 검사하여 숫자가 아닌 문자가 포함된 경우
	false를 반환하고, 모두 숫자인 경우 true를 반환한다.
	 */
	public static boolean isNumber(String strValue) {
		
		// 만약 전달된 문자열이 빈문자열이라면 무조건 false
		if(strValue.length()==0)
			return false;
		
		//문자열의 길이만큼 반복
		for(int i=0; i<strValue.length(); i++) {
			//각 문자의 아스키코드를 반환한다
			int acode = strValue.codePointAt(i);
			if(!(acode>='0' && acode<='9')) {
				//숫자가 아니라면 false반환
				return false;
			}
		}
		//위 조건을 통과하면 숫자이므로 true 반환
		return true;
	}
}
