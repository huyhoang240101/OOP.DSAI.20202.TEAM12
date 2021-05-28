package hust.soict.dsai.sad.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class InputArray implements ActionListener {
	
	private ArrayList<Integer> array = new ArrayList<Integer>();
	private int size;
	
	public InputArray() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter array size:");
		size = in.nextInt();
		array = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			int value = in.nextInt();
			array.add(value);
		}
	}
	
	
	public ArrayList<Integer> getArray() {
		return array;
	}


	public int getSize() {
		return size;
	}


	public void actionPerformed(ActionEvent e) {
		
	}

}
