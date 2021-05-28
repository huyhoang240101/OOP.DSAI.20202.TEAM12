package hust.soict.dsai.sad.main;

import java.awt.Color;

import javax.swing.JPanel;

public class SortArray extends JPanel {
	
	public static final int DEFAULT_WINDOW_HEGHT = 1280;
	public static final int DEFAULT_WINDOW_WIDTH = 720;
	public static final int DEFAULT_BAR_WIDTH = 5;
	
	public static final int NUM_BARS = DEFAULT_WINDOW_WIDTH / DEFAULT_BAR_WIDTH;
	
	private final int[] array;
	
	public SortArray() {
		setBackground(Color.DARK_GRAY);
		array = new int[NUM_BARS];
	}
	
	public void swap(int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	

}
