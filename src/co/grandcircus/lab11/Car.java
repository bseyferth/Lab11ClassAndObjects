package co.grandcircus.lab11;

public class Car {

	private String make;
	private String model;
	private int year;
	private double price;
	
	//getter make
	public String getMake() {
		return make;
	}

	//setter make
	public void setMake(String make) {
		this.make = make;
	}

	//getter model
	public String getModel() {
		return model;
	}


	//setter model
	public void setModel(String model) {
		this.model = model;
	}

	//getter year
	public int getYear() {
		return year;
	}

	//setter year
	public void setYear(int year) {
		this.year = year;
	}
	
	//getter price
	public double getPrice() {
		return price;
	}

	//setter price
	public void setPrice(double price) {
		this.price = price;
	}

	//constructor
	public Car(String make, String model, int year, double price) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
	}
	
	//default constructor
	public Car() {
	}

	//to string
	@Override
	public String toString() {
		return String.format("%-10s %-10s %d\t$%,10.2f", make, model, year, price);
	}
	
	
	
	
	
	
}
