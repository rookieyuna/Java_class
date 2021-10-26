package ex20io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class E08StringWriter
{
	public static void main(String[] args)
	{
		try {
			/*
			문자열을 저장하기 위한 출력스트림을 생성한다
			문자열의 입력은 버퍼에 따라 성능의 차이가 크기때문에
			버퍼 필터 스트림을 추가적으로 연결해서 사용한다.
			 */
			BufferedWriter out = new BufferedWriter
					(new FileWriter("src/ex20io/string.txt"));
		
		/*
		write()를 통해 문자열을 저장하고, 줄바꿈은 newLine()메소드로
		처리한다. 각 OS별로 개행문자가 다르기에 \n는 안쓰는것이 좋다!
		 */
		out.write("나는 KOSMO에서 공부한다.\n");
		out.newLine();//줄바꿈(\n 쓸수 있지만 윈도우에서만 인식!)
		out.write("수료 후 취업 소취!!");
		out.newLine();
		
		out.close();
		System.out.println("입력완료");
		}
		catch (FileNotFoundException e) {
			System.out.println("파일없음");
		}
		catch (IOException e) {
			System.out.println("IO오류");
		}
	}
}
