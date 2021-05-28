package hust.soict.dsai.sad.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RandomArray implements ActionListener {
	
	private final int MAX_SIZE = 12;
	private final int MIN_SIZE = 5;
	
	private final int MAX_VALUE = 40;
	private final int MIN_VALUE = 1;
	
	
	private ArrayList<Integer> array;
	private int size;
	
	public RandomArray() {
		size = (int)Math.floor(Math.random()*(MAX_SIZE - MIN_SIZE + 1)+ MIN_SIZE);
		array = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			int random_value = (int)Math.floor(Math.random()*(MAX_VALUE - MIN_VALUE + 1)+ MIN_VALUE);
			array.add(random_value);
		}
	}

	

	public ArrayList<Integer> getArray() {
		return array;
	}

	public int getSize() {
		return size;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	

}
