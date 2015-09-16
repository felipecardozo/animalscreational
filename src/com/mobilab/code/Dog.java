package com.mobilab.code;

import java.util.Comparator;

import com.mobilab.code.base.Animal;

public final class Dog extends Animal implements Comparator<Dog> {

	private final String breed;

	public Dog(){
		this.breed = "";
	}
	
	public Dog(String breed) {
		this.breed = breed;
	}
	
	public Dog(String breed, int age) {
		super(age);
		this.breed = breed;
	}

	public String getBreed() {
		return breed;
	}

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

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + super.getAge();
		result = 31 * result + (breed != null ? breed.hashCode() : 0);
		return result;
	}
	
	@Override
	public int compare(Dog o1, Dog o2) {
		return o1.getAge() - o2.getAge();
	}
	
	public String toString(){
		return super.getAge() + "\t" + getBreed();
	}

}
