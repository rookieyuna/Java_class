package ex21jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HRSelected
{

	public static void main(String[] args)
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "hr";
			String pass = "1234";
			
			Connection con = DriverManager.getConnection(url,id,pass);
			if(con!=null) {
				System.out.println("Oracle 연결성공");
				
				/*
				1. 쿼리문 작성 
					-작성시 주의점: 쿼리문 줄바꿈시 앞뒤로 공백을 삽입하는
					것이 좋다. 문장이 분리되지 않으면 syntaxError가 발생한다.
				 */
				String sql = "SELECT * FROM employees "
						+ " WHERE department_id=30 "
						+ " ORDER BY employee_id DESC ";
				/*
				2. 쿼리문 전송을 위해 Statement 인터페이스를 통한 객체를
				생성한다. 주로 정적쿼리문을 실행할 때 사용한다. 
				*/
				Statement stmt = con.createStatement();
				/*
				3. 쿼리문을 전송 한 후 실행한 결과를 ResultSet객체를 통해
				반환받는다. 해당 객체는 select쿼리를 실행했을 때만 사용한다.
				 */
				ResultSet rs = stmt.executeQuery(sql);
				/*
				4. 반환된결과를 개수만큼 반복한다. 
				※ next()메서드는 출력할 다음 레코드가 있을경우 true를 반환!
				 */
				while(rs.next()) {
					/*
					getXXX() 메서드를 통해 컬럼에 접근한다. 
					오라클의 자료형은 숫자, 문자, 날짜 3가지 형태이므로 
					각 메서드도 그와 동일하다.
					각 컬럼에 접근시 인덱스, 컬럼명 두 가지 모두 사용가능하다.
					 */
					String emp_id = rs.getString(1);//인덱스로접근
					String f_name = rs.getString(2);//"first_name"
					String l_name = rs.getString("last_name");//컬럼명으로 접근
					java.sql.Date h_date = rs.getDate("hire_date");
					int sal = rs.getInt("salary");
					System.out.printf("%s %s %s %s %s\n",
							emp_id, f_name, l_name, h_date, sal);
				}			
				/*
				5.자원반납 : 모든작업을 마친 후에는 메모리 절약을 위해
				연결했던 자원을 반납한다.
				 */
				rs.close();
				stmt.close();
				con.close();
			}
			else {
				System.out.println("Oracle 연결실패");
			}
		}
		catch(Exception e) {
			System.out.println("Oracle 연결시 예외발생");
			e.printStackTrace();
		}
	}
}
