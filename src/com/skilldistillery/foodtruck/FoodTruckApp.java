package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {
	private final Scanner kb = new Scanner(System.in);
	private FoodTruck[] foodTrucks = new FoodTruck[5];
	private boolean enteringData = true;
//	FoodTruck ft = new FoodTruck("Name","food type", 100);
//	FoodTruck ft2 = new FoodTruck("dif Name","food type", 100);
	public void runApp() {
		explainer();
		int i = 0;
		FoodTruck[] fT = new FoodTruck[5];
		while(enteringData) {
			String name;
			String foodType;
			String strRating;
			int rating;
			
			System.out.println("Please enter Food Truck name: ");
			name = getUserString();
			if (checkQuit(name)) {break;}
			FoodTruck foodTruck = new FoodTruck(name);
			
			System.out.println("Please enter Food Type: ");
			foodType = getUserString();
			if (checkQuit(name)) {break;}
			foodTruck.setFoodType(foodType);
			
			System.out.println("Please enter whole number (1-100): ");
			strRating = getUserString();
			if (checkQuit(name)) {break;}
			rating = Integer.parseInt(strRating);
			foodTruck.setRating(rating);
			fT[i] = foodTruck;
			String out = fT[i].toString();
			System.out.println(out);
			i++;
			if (i == 5) {
				enteringData = false;
			}
		}
		
	}
	private void menu() {
		System.out.println("            Select Option             ");
		System.out.println("--------------------------------------");
		System.out.println("1.) See average food truck raiting");
		System.out.println("2.) Display highest rated food truck");
		System.out.println("3.) Quit");
	
	}
	private void explainer() {
		System.out.println("WELCOME!");
		System.out.println("You're going to help me create one to five food trucks!");
		System.out.println("For each truck I'll ask you for a name, a food type, and a rating (1-100).");
		System.out.println("You may enter 'quit' at anypoint to stop creating food trucks and move on to other options");
		System.out.println("You may only create five food trucks.");
		System.out.println("Once you have named a food truck it exists.");
	}
	private String getUserString() {
		String input = kb.nextLine();
		return input;
	}
//	private int getUserInt() {
//	int input = kb.nextInt();
//	kb.nextLine();
//	return input;
//	}
	private boolean checkQuit(String input) {
		boolean quit = false;
		if (input.toUpperCase().trim().equals("QUIT")){
			quit = true;
		}
		return quit;
	}
	private FoodTruck[] foodTruckFleetCreator() {
		
		
		return foodTrucks;
	}
}

// menu: 
//List all existing food trucks.
//See the average rating of food trucks.
//Display the highest-rated food truck.
//Quit the program.

//prompted to input the name, food type, and rating for up to five food trucks. 
//For each set of input, a FoodTruck object is created, 
//its fields set to the user's input, and it is added to the array.
//






