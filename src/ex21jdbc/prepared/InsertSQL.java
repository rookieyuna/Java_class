package ex21jdbc.prepared;

import java.util.Scanner;

import ex21jdbc.connect.IConnectImpl;
/*
PreparedStatement 인터페이스 사용
-sql문장을 미리 컴파일할 수 있도록 개선되었다.
-작은따옴표(')같은 문자열 등을 자동적으로 처리한다.
-재사용하기 편리하다.
-미리 컴파일되기 때문에 쿼리의 수행 속도가 Statement 객체에 비해 빠르다.
 */
public class InsertSQL extends IConnectImpl {

	public InsertSQL() {
		super(ORACLE_DRIVER, "kosmo", "1234");
	}

	@Override
	public void execute() {
		try {
			//1. 쿼리문 준비: 값의 셋팅이 필요한 부분을 ?(인파라미터)로 대체
			String query = "INSERT INTO member VALUES (?,?,?,?)";
			
			/*regidate는 테이블 생성 시 default를 system으로 설정해서 생략가능
			혹은 regidate부분에 sysdate를 넣어도 됨
			String query = "INSERT INTO member (id, pass, name) VALUES (?,?,?)";
			String query = "INSERT INTO member VALUES (?,?,?,sysdate)";*/
			
			//2. prepared 객체생성: 생성 시 준비한 쿼리문을 인자로 전달
			psmt = con.prepareStatement(query);
			
			//3. 입력할 내용을 사용자로부터 입력받는다.
			Scanner scan = new Scanner(System.in);
			System.out.println("아이디: ");
			String id = scan.nextLine();
			System.out.println("패스워드: ");
			String pw = scan.nextLine();
			System.out.println("이름: ");
			String name = scan.nextLine();
			
			/*
			4. 인파라미터 설정: ?의 순서대로 설정하고 인덱스는 1부터 시작
				인파라미터 설정 시 사용하는 메서드
				자료형이 숫자: setInt()
						 문자: setString()
						 날짜: setDate()
				=> 입력값이 문자이거나 날짜면 싱글쿼테이션 자동삽입
			 */
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			
			//날짜를 문자열로 입력하는 경우
			//psmt.setString(4, "2021-12-25");
			
			/*날짜를 Date타입으로 입력하는 경우
				현재날짜를 java단에서 입력하는 경우 아래와 같은 변환과정 거친다
				util패키지로 시간을 가져온 후 sql패키지로 타입을 변환한다.
				이 때는 date형으로 입력되므로 setDate()로 인파라미터를 설정한다.
			 */
//			java.util.Date utilDate = new java.util.Date();
//			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//			psmt.setDate(4, sqlDate);
			
			int affected = psmt.executeUpdate();
			System.out.println(affected +"행이 입력되었습니다.");
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		new InsertSQL().execute();
	}
}
