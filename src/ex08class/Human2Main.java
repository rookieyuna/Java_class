package ex08class;

public class Human2Main {

	public static void main(String[] args) {
		System.out.println("★길동이살리기★");
		
		Human2 human = new Human2();
		human.name = "홍길동";
		human.age = 30;
		human.energy = 7;
		
		human.showNow();
		
		System.out.println("[Chapter1]");
		human.thinking();
		human.walking();		
		human.walking();
		human.eating();
		human.walking();
		
		human.showNow();
		
		System.out.println("[Chapter2]");
		human.thinking();
		human.thinking();
		human.walking();	
		
		human.showNow();
	}

}
