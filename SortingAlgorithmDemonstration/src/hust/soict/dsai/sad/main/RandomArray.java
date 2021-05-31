package hust.soict.dsai.sad.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.dsai.sad.algoritms.BubbleSort;
import hust.soict.dsai.sad.screen.SortingDemoScreen;

public class RandomArray {
	
	private static final int MAX_SIZE = 12;
	private static final int MIN_SIZE = 10;
	
	private static final int MAX_VALUE = 40;
	private static final int MIN_VALUE = 1;
	
	
	private static ArrayList<Integer> array;
	private static int size;
	
	public static ArrayList<Integer> RandomArray() {
		size = (int)Math.floor(Math.random()*(MAX_SIZE - MIN_SIZE + 1)+ MIN_SIZE);
		array = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			int random_value = (int)Math.floor(Math.random()*(MAX_VALUE - MIN_VALUE + 1)+ MIN_VALUE);
			array.add(random_value);
		}
		System.out.println(array);
		return array;
	}

	public int getSize() {
		return size;
	}
	
}
