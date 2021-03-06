package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {
	private final Scanner kb = new Scanner(System.in);
	private boolean enteringData = true;
	private boolean selectingOption = true;

	public void runApp() {
		explainer();
		FoodTruck[] foodTruckFleet = new FoodTruck[5];
		foodTruckFleet = foodTruckFleetCreator();
		runOptions(foodTruckFleet);
		System.out.println("\nThank you for all the help! Now go reward your hard labors with some real food.\uD83D\uDC4B");
	}

	private void menu() {
		System.out.println("----------------------------------------");
		System.out.println("|            Select Option             |");
		System.out.println("|   Select by entering 1, 2, 3, or 4   |");
		System.out.println("|--------------------------------------|");
		System.out.println("|1.) Display Food Truck Fleet.         |");
		System.out.println("|2.) See average food truck rating.    |");
		System.out.println("|3.) Display highest rated food truck. |");
		System.out.println("|4.) Quit.                             |");
		System.out.println("----------------------------------------");

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
		return input.trim();
	}


	private int checkSelection(String input) {
		int selection = 0;
		if (input.trim().equals("1") || input.toUpperCase().trim().equals("ONE")
				|| input.toUpperCase().trim().equals("DISPLAY FLEET")) {
			selection = 1;
			return selection;
		} else if (input.trim().equals("2") || input.toUpperCase().trim().equals("TWO")
				|| input.toUpperCase().trim().equals("DISPLAY AVERAGE")) {
			selection = 2;
			return selection;
		} else if (input.trim().equals("3") || input.toUpperCase().trim().equals("THREE")
				|| input.toUpperCase().trim().equals("DISPLAY HIGHEST RATED")) {
			selection = 3;
			return selection;
		} else if (input.trim().equals("4") || input.toUpperCase().trim().equals("FOUR")
				|| input.toUpperCase().trim().equals("QUIT")) {
			selection = 4;
			return selection;
		} else {
			return selection;
		}
	}

	private boolean checkQuit(String input) {
		boolean quit = false;
		if (input.toUpperCase().trim().equals("QUIT")) {
			quit = true;
		}
		return quit;
	}

	private int checkRange(int rating) {
		int inRange;
		if (rating > 100) {
			inRange = 100;
		} else if (rating < 1) {
			inRange = 1;
		} else {
			inRange = rating;
		}
		return inRange;
	}

	private void displayFleet(FoodTruck[] foodTruckFleet) {
		for (FoodTruck foodTruck : foodTruckFleet) {
			if (foodTruck == null) {
				break;
			}
			String out = foodTruck.toString();
			System.out.println(out);
			System.out.println();
		}
		System.out.println();
	}

	private void getFleetAvgRating(FoodTruck[] foodTruckFleet) {
		int iteration = 0;
		int rating = 0;
		for (FoodTruck foodTruck : foodTruckFleet) {
			if (foodTruck == null) {
				break;
			}
			rating += foodTruck.getRating();
			iteration++;
		}
		double averageRating = ((double) rating) / ((double) iteration);
		System.out.printf("The Average Rating Of this Fleet is %.2f", averageRating);
		System.out.println("");
		System.out.println("");
	}

	private void displayHighestRatedTruck(FoodTruck[] foodTruckFleet) {
		StringBuilder sb = new StringBuilder();
		String highestRatedTruckInfo;
		int highestRating = 0;
		int iteration = 0;
		int indexOfhighestRating = 0;
		for (FoodTruck foodTruck : foodTruckFleet) {
			if (foodTruck == null) {
				break;
			}
			if (highestRating < foodTruck.getRating()) {
				highestRating = foodTruck.getRating();
				indexOfhighestRating = iteration;

			}
			iteration++;
		}
		sb.append("With a rating of ").append(highestRating).append(", ")
				.append(foodTruckFleet[indexOfhighestRating].getName())
				.append(" has the highest rating in the fleet!\nThey are highly regarded for their delicous ")
				.append(foodTruckFleet[indexOfhighestRating].getFoodType()).append(".\nTheir Id number is: ")
				.append(foodTruckFleet[indexOfhighestRating].getIdNum());

		highestRatedTruckInfo = sb.toString();
		System.out.println(highestRatedTruckInfo);
		System.out.println();
	}

	private FoodTruck[] foodTruckFleetCreator() {
		int i = 0;
		FoodTruck[] foodTrucks = new FoodTruck[5];
		while (enteringData) {
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
			rating = checkRange(rating);
			foodTruck.setRating(rating);

			foodTrucks[i] = foodTruck;
//			String out = fT[i].toString();
//			System.out.println(out);
			i++;
			if (i == 5) {
				enteringData = false;
			}
		}

		return foodTrucks;
	}

	private void runOptions(FoodTruck[] foodTruckFleet) {
		while (selectingOption) {
			menu();
			int selection = checkSelection(getUserString());
			switch (selection) {
			case 0:
				System.out.println("Invalid Input, try again.");
				continue;
			case 1:
				displayFleet(foodTruckFleet);
				continue;
			case 2:
				getFleetAvgRating(foodTruckFleet);
				continue;
			case 3:
				displayHighestRatedTruck(foodTruckFleet);
				continue;
			case 4:
				selectingOption = false;
				break;

			}
		}
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
