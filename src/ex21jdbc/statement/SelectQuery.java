package ex21jdbc.statement;

import java.sql.SQLException;

/*
ResultSet클래스
	:select문 실행 시 쿼리의 실행결과가 ResultSet 객체에 저장된다.
	결과로 반환된 레코드의 처음부터 마지막까지 next()메서드를 통해
	확인 후 반복 추출한다.
	-getXXX()계열의 메서드
	오라클의 자료형이
		number타입 : getInt(인자)
		char/varchar2타입 : getString(인자)
		date타입 : getDate()
	-getString(인자)메서드는 오라클 자료형 상관없이 모두 가능하다.
	-인자는 select절의 순서대로 인덱스(1부터 시작)을 사용하거나,
	"컬럼명"을 사용할 수 있다.
	-인덱스를 사용하면 편리하지만 쿼리문에 컬럼이 추가될 경우에는 
	인덱스가 순서가 바뀌므로 주의가 필요하다.
	 
 */
public class SelectQuery extends ConnectDB{

	public SelectQuery() {
		super();
	}
	
	@Override
	void execute() {
		try {
			stmt = con.createStatement();
			
			String query = "SELECT id, pass, name, regidate, "
					+ " to_char(regidate, 'yyyy.mm.dd hh24:mi') d1"
					+ " FROM member";
				
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String id = rs.getString(1); //id컬럼
				String pw = rs.getString("pass");
				String name = rs.getString(3); //name컬럼
				
				/*
				oracle date타입을 getDate()로 추출하면 0000-00-00형태로 추출됨
				=>date형 자료이므로 java.sql.Date클래스의 참조변수로 저장한다.
				 */
				java.sql.Date regidate = rs.getDate("regidate");
				/*
				oracle date타입을 getString()으로 추출하면 
				0000-00-00 00:00:00 형태로 시간까지 출력. 
				적당한 형태로 자르고 싶다면 substring(시작,끝)을 사용
				 */
				String regidate2 = rs.getString("regidate"); 
				String regidate3 = 
						rs.getString("regidate").substring(0,13);
				//쿼리문에 사용한 별칭(as)를 그대로 사용 가능
				String regidate4 = rs.getString("d1");
				
				System.out.printf("%8s %4s %s %s %s %s %s\n",
						id, pw, name, regidate,
						regidate2, regidate3, regidate4);
			}
		}
		catch (SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
		finally {
			close(); //DB자원반납
		}
	}
	
	public static void main(String[] args) {
		SelectQuery selectSQL = new SelectQuery();
		selectSQL.execute();
	}
}
