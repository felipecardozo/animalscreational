package com.mobilab.code;

import java.util.Comparator;

import com.mobilab.code.base.Animal;

/**
 * @author Felipe
 * @version 1.0
 * Dog class represents a Dog which extends from Animal class
 * */
public final class Dog extends Animal implements Comparator<Dog> {

	private final String breed;

	/**
	 * constructor by default, will initialize breed property with white space
	 * */
	public Dog(){
		this.breed = "";
	}
	
	/**
	 * @param breed represents breed
	 * constructor will initialize breed property with a specified value
	 * */
	public Dog(String breed) {
		this.breed = breed;
	}
	
	/**
	 * @param breed represents breed
	 * @param age represents the age of the animal
	 * constructor will initialize breed property with a specified value and the age
	 * */
	public Dog(String breed, int age) {
		super(age);
		this.breed = breed;
	}

	public String getBreed() {
		return breed;
	}

	/**
	 * @param other represents the other object to compare
	 * @return returns a boolean depending of the current object versus the other object
	 * will return a boolean depending of the age and breed of both objects
	 * */
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null || (this.getClass() != other.getClass())) {
			return false;
		}
		Dog guest = (Dog) other;
		return (this.getAge() == guest.getAge()) && (this.breed != null && breed.equals(guest.breed));
	}

	/**
	 * @return returns an integer based on a basic algorithm
	 * will return an integer depending of the hashCode of the object
	 * */
	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + super.getAge();
		result = 31 * result + (breed != null ? breed.hashCode() : 0);
		return result;
	}
	
	/**
	 * @param o1 dog 1
	 * @param o2 dog 2
	 * compares objects according to the age
	 * */
	@Override
	public int compare(Dog o1, Dog o2) {
		return o1.getAge() - o2.getAge();
	}
	
	public String toString(){
		return super.getAge() + "\t" + getBreed();
	}

}
