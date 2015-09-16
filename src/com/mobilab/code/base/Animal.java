package com.mobilab.code.base;

public class Animal {
	
	private int age;
	
	public Animal(){
		if( isValidAge(age) ){
			this.age = 0;
		}
	}
	
	public Animal( int age ){
		this.age = age;
	}
	
	public void setAge(int age){
		if( isValidAge(age) ){
			this.age = age;
		}
	}
	
	public int getAge(){
		return age;
	}
	
	private boolean isValidAge(int age){
		return age>=0;
	}

}
