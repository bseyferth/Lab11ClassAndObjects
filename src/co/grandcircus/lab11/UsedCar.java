package co.grandcircus.lab11;

public class UsedCar extends Car{

	private double miles;

	//default constructor
	public UsedCar() {
		super();
		
	}

	//constructor for the 
	public UsedCar(String make, String model, int year, double price, double miles) {
		super(make, model, year, price);
		this.miles = miles;
	}

	//getter miles
	public double getMiles() {
		return miles;
	}

	//setter miles
	public void setMiles(double miles) {
		this.miles = miles;
	}

	//to string with the super information
	@Override
	public String toString() {
		return super.toString() + " (Used)" + String.format("%,10.1f", miles) + " miles";
	}

	
	}
	
	
	
	
	

