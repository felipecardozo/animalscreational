package com.mobilab.code;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class DogTest {

	
	
	@Test
	public void test() {
		
		List<Dog> list = new ArrayList<>();
		
		list.add( new Dog("hanna is the name of my doggy, she was very easy to breed", 11) );
		list.add( new Dog("Donut chocolate bar candy cheesecake soufflé chocolate cake.", 8 ) );
		list.add( new Dog("Fruitcake gingerbread ice cream powder gummi bears powder carrot cake.", 3 ) );
		list.add( new Dog("Sweet tart chocolate jujubes lollipop pastry chocolate liquorice", 13 ) );
		list.add( new Dog("Apple pie gummi bears cake chocolate bar pie gingerbread cookie wafer marzipan", 7 ) );
		list.add( new Dog("Tart jelly-o chocolate bar croissant biscuit bonbon", 15 ) );
		
		Collections.sort( list, new Dog() );
		
		List<Dog> expected = getExpectedList();
		assertArrayEquals( new int[]{ expected.get(0).getAge(), expected.get(expected.size()-1).getAge() } ,  
						   new int[]{ list.get(0).getAge(), list.get(list.size()-1).getAge() } );
		
	}
	
	private List<Dog> getExpectedList(){
		List<Dog> output = new ArrayList<>();
		output.add( new Dog("Fruitcake gingerbread ice cream powder gummi bears powder carrot cake.", 3 ) );
		output.add( new Dog("Donut chocolate bar candy cheesecake soufflé chocolate cake.", 8 ) );
		output.add( new Dog("Apple pie gummi bears cake chocolate bar pie gingerbread cookie wafer marzipan", 7 ) );
		output.add( new Dog("hanna is the name of my doggy, she was very easy to breed", 11) );
		output.add( new Dog("Sweet tart chocolate jujubes lollipop pastry chocolate liquorice", 13 ) );
		output.add( new Dog("Tart jelly-o chocolate bar croissant biscuit bonbon", 15 ) );
		return output;
	}

}
