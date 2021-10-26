package ex21jdbc.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class EditDelShop
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
	
	public void executeUpDel() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			try {
				System.out.println("메뉴를 고르세요");
				System.out.println("1. 수정 / 2. 삭제");
				int choice = scan.nextInt();
				if(choice==1) {
					String sql = "UPDATE sh_goods "
							+ " SET goods_name=?, goods_price=?, p_code=? "
							+ " where g_idx = ?";
					prst = con.prepareStatement(sql);
					prst.setString (4, scanValue("상품일련번호"));
					prst.setString (1, scanValue("상품명"));
					prst.setString (2, scanValue("상품가격"));
					prst.setString (3, scanValue("상품코드"));
					
					int affected = prst.executeUpdate();
					System.out.println(affected + "행 수정 완료");
				}
				else if(choice==2) {
					String sql = "DELETE FROM sh_goods "
							+ " WHERE g_idx = ?";
					prst = con.prepareStatement(sql);
					prst.setString (1, scanValue("상품일련번호"));
					int affected = prst.executeUpdate();
					System.out.println(affected + "행 삭제 완료");
				}
			}
			catch (Exception e) {
				System.out.println("예외발생");
				e.printStackTrace();
			}
			
			System.out.println("다시 시작하시겠습니까? 재시작(1)/종료(0):");
			int restart = scan.nextInt();
			if (restart == 0) {break;}
		}
	}
	
	public static void main(String[] args)
	{
		EditDelShop editDel = new EditDelShop();
		editDel.conOracle();
		editDel.executeUpDel();
	}
}
