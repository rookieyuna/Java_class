package ex08class;

public class Car2 
{
	public static String MANUAL2 = "수동";
	public static String AUTO2 = "자동";
	
	String carModel;
	String carGear= MANUAL2;
	int carYear;
	Human2 human2;
	
	void carInitialize(String model, int year, String name, int age, int energy)
	{
		carModel = model;
		carYear = year;
		human2 = new Human2();
		human2.name = name;
		human2.age = age;
		human2.energy = energy;
	}
	
	void showInfo()
	{
		System.out.println("차량모델:"+carModel);
		System.out.println("차량기어:"+carGear);
		System.out.println("차량연식:"+carYear);
		System.out.println("  ┌차량주인┐");
		human2.showNow();
	}

}


