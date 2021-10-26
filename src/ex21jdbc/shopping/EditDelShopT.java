package ex21jdbc.shopping;

import java.util.Scanner;

import ex21jdbc.connect.IConnectImpl;

public class EditDelShopT extends IConnectImpl {

	public EditDelShopT() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1.수정, 2.삭제");
			System.out.print("메뉴를 선택하세요");
			try {
				int menu = scanner.nextInt();
				if(menu==1) {
					String sql = "UPDATE sh_goods "
							+ " SET goods_name=?, goods_price=? WHERE g_idx=?";
					psmt = con.prepareStatement(sql);			
					psmt.setString(3, scanValue("상품일련번호"));
					psmt.setString(1, scanValue("상품명"));
					psmt.setString(2, scanValue("상품가격"));
					int affected = psmt.executeUpdate();
					System.out.println(affected +"행이 수정 되었습니다.");
				}
				else if(menu==2) {
					String sql = "DELETE FROM sh_goods WHERE g_idx=?";
					psmt = con.prepareStatement(sql);			
					psmt.setString(1, scanValue("상품일련번호")); 
					int affected = psmt.executeUpdate();
					System.out.println(affected +"행이 삭제 되었습니다.");
				}
				scanner.nextLine();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("1.계속, 2.종료");
			System.out.print("계속하시겠습니까?");
			String retry = scanner.nextLine();
			if(retry.equalsIgnoreCase("2"))
				break;
		}
		System.out.println("종료되었습니다.");
	}
	
	public static void main(String[] args) {
		new EditDelShopT().execute();
	}
}
