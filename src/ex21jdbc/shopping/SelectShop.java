package ex21jdbc.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectShop
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	public void conOracle() { //오라클연결
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"kosmo", "1234");
			if(con!=null)
				System.out.println("연결성공");
		}
		catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}
	}
	
	public String scanValue(String title) {
		Scanner scan = new Scanner(System.in);
		System.out.print(title+"을 입력하세요: ");
		String data = scan.nextLine();
		
		return data;
	}
	
	public void execute() {
		try {
			String search = scanValue("상품명");
			
			String sql = "SELECT "
					+ " g_idx, goods_name, "
					+ " trim(to_char(goods_price, '999,990')), "
					+ " to_char(regidate, 'yyyy-mm-dd hh:mi'), "
					+ "	p_code "
					+ "	FROM sh_goods "
					+ "	where goods_name like '%"+ search+ "%'"; 
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String idx = rs.getString(1);
				String name = rs.getString(2);
				String price = rs.getString(3);
				String date = rs.getString(4);
				String code = rs.getString("p_code");
				
				System.out.printf("%s %s %s %s %s\n",
						idx, name, price, date, code);
			}
		}
		catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		SelectShop select = new SelectShop();
		select.conOracle();
		select.execute();
	}
}
