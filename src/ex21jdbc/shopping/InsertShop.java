package ex21jdbc.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertShop
{
	private Connection con;
	private	PreparedStatement prst;
	
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
			String query = "insert into sh_goods "
					+ " values (?, ?, ?, sysdate, ?)";
			
			prst=con.prepareStatement(query);
			
			prst.setString(1, scanValue("상품일련번호"));
			prst.setString(2, scanValue("상품명"));
			prst.setString(3, scanValue("상품가격"));
			prst.setString(4, scanValue("상품코드"));
			
			int affected = prst.executeUpdate();
			System.out.println(affected + "행 입력 완료");
		}
		catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		InsertShop insert = new InsertShop();
		insert.conOracle();
		insert.execute();
	}
}
