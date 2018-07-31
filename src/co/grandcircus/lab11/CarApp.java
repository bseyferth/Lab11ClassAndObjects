package co.grandcircus.lab11;

//Created by Brian Seyferth on 7/30/2018

//imports scanner and array list functionality
import java.util.ArrayList;
import java.util.Scanner;

public class CarApp {
	
	public static void main(String[] args) {
		
		//creates array list and opens scanner
		ArrayList<Car> list = new ArrayList<>();
		Scanner scnr = new Scanner(System.in);
		
		//declares variables needed
		String userResponse = "";
		String buyYOrN = "";
		String usedYOrN = "";
		String carBrand = "";
		String carModel = "";
		int year;
		double price;
		double mileage;
		int lookUpNum;
		int removeNum;
		boolean quitRef = false;
		
		//creates cars using the first option of creating them
		Car car1 = new Car("Ford", "Fusion", 2014, 25000);
		Car car2 = new Car("Porsche", "Cayenne", 2018, 75000);
		UsedCar car3 = new UsedCar("Ford", "F150", 2010, 12500, 99500);
		UsedCar car4 = new UsedCar("Subaru", "Outlander", 2012, 9999, 78000);
		
		//adds the cars to the list
		list.add(car1);
		list.add(car2);
		list.add(car3);
		list.add(car4);
		
		//creates the cars using the second way and adds them to the list in one line 
		list.add(new UsedCar("Honda", "Civic", 2005, 5000, 125000));
		list.add(new Car("Tesla", "Model S", 2018, 50000));
		
		//prints outs welcome and initial list
		System.out.println("Welcome to Seyferth's Car Lot!");
		for (int i = 0; i<list.size(); i++) {
			System.out.println((i+1) + ". " + list.get(i));
		}
		
		//this while loop sets up the quit option in the program
		while (quitRef == false) {
			
			//prints out the options available
			System.out.println("What would you like to do?");
			System.out.println("(Type \"list\" to see the current list of cars.)");
			System.out.println("(Type \"look\" to look up 1 car from the current list of cars.)");
			System.out.println("(Type \"add\" to add a car to the current list of cars.)");
			System.out.println("(Type \"remove\" to remove a car from the current list of cars.)");
			System.out.println("(Type \"quit\" to quit the program.)");
		
			//collects user response
			userResponse = scnr.nextLine();
		
		
			//this If, else if, and else statement matches the response to options
			//anything that isn't an option starts the loop again
			
			//this is the list options
			if (userResponse.equals("list")) {
				
				//prints list
				for (int i = 0; i<list.size(); i++) {
					System.out.println((i+1) + ". " + list.get(i));
				}
			
				//look option is set up
			} else if (userResponse.equals("look")) {
			
				//these statements look up the valid value input from the user
				lookUpNum = (Validator.getInt(scnr,"Which car would you like to see (1-" + list.size() + ")", 1, list.size())-1);			
				System.out.println(list.get(lookUpNum));
				
				//asks them if they would like to purchase
				System.out.println("Would you like to purchase this car? (\"y\" or \"n\")");
				buyYOrN = scnr.nextLine();
				
				// if statement to setup the user response to buy or not
				if (buyYOrN.equals("y")) {
					
					//prints out great message and ends app
					System.out.println("Excellent! Our finance department will be in touch shortly.");
					quitRef = true;
				} else {
					
					//restarts app based on a user no response to buy
					System.out.println("No problem. Lets find something better.");
					quitRef = false;
				}
			
				//sets up the add option
			} else if (userResponse.equals("add")) {
			
				//runs through questions needed, collects valid data, and 
				//creates a car or used car from responses
				System.out.println("Is this car a used car? (\"y\" or \"n\")");
				usedYOrN = scnr.nextLine();
				
				if (usedYOrN.equals("y")) {
					
					System.out.println("What is the brand?");
					carBrand = scnr.nextLine();
					System.out.println("What is the model?");
					carModel = scnr.nextLine();
					
					//collects and validates year
					year = Validator.getInt(scnr,"What is the year?");
					//collects and validates price 
					price = Validator.getDouble(scnr,"What is the price?");
					//collects and validates mileage
					mileage = Validator.getDouble(scnr,"How many miles?");
					
					//adds a used car object to list
					list.add(new UsedCar(carBrand, carModel, year, price, mileage));
					quitRef = false;
					
				} else {
					
					System.out.println("What is the brand?");
					carBrand = scnr.nextLine();
					System.out.println("What is the model?");
					carModel = scnr.nextLine();
					
					//collects and validates year
					year = Validator.getInt(scnr,"What is the year?");
					//collects and validates price 
					price = Validator.getDouble(scnr,"What is the price?");
					
					//adds a car object to the list
					list.add(new Car(carBrand, carModel, year, price));
					quitRef = false;
				}
				
			//creates the remove option
			} else if (userResponse.equals("remove")) {
			
				//removes a car from the list based on user input
				removeNum = (Validator.getInt(scnr,"Which car would you like to remove (1-" + list.size() + ")", 1, list.size())-1);
				list.remove(removeNum);
				System.out.println("Car " + (removeNum+1) + " will be removed.");
				quitRef = false;

			//creates and executes the quit option
			} else if (userResponse.equals("quit")) {
				
				quitRef = true;
			
				//this handles the user putting anything in besides options
			} else {
			
				System.out.println("Your response was unrecognized. Please try again.");
				quitRef = false;
			}
		}
		
		//prints out goodbye message
		System.out.println("Goodbye!");
		
	}
}
