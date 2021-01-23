package com.skilldistillery.foodtruck;

public class FoodTruck {
	private final StringBuilder sb = new StringBuilder();

	private int idNum;
	private String name;
	private String foodType;
	private int rating;
	private static int numOfTrucks = 1;

	public FoodTruck(String name, String foodType, int rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		this.idNum = numOfTrucks;
		numOfTrucks++;
	}

	public FoodTruck(String name, String foodType) {
		this(name, foodType, 50);
		this.idNum = numOfTrucks;
		numOfTrucks++;
	}

	public FoodTruck(String name) {
		this(name, "Never Specified", 50);
		this.idNum = numOfTrucks;
		numOfTrucks++;
	}

	public FoodTruck() {
		this("TBD", "Never Specified", 50);
		this.idNum = numOfTrucks;
		numOfTrucks++;
	}

	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String toString() {
		String fTruckInfo;

		fTruckInfo = sb.append("Name of Truck: ").append(name).append(". Food Type: ")
				.append(foodType).append(". Rating: ").append(rating)
				.append(". ID number: ").append(idNum).append(".").toString();

		return fTruckInfo;

	}

}
//You will define a FoodTruck class with fields for a unique numeric id,
//a name (“TacoRific”, “Mediterranean Medic”, etc.), 
//food type (“Tacos”, “Falafel”, etc.), and a numeric rating.
//
//You will create a separate class with a main method that starts the program. 
//It will have an array to store up to five FoodTruck objects. 
//The main method of this class is the only static method in the entire project.