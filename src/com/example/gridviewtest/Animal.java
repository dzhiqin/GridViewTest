package com.example.gridviewtest;

public class Animal {
	private String animalName;
	private int imageId;
	public Animal(String animalName,int imageId) {
			
		this.animalName=animalName;
		this.imageId=imageId;
	}
	public String getName(){
		return animalName;
	}
	public int getId(){
		return imageId;
	}

}
