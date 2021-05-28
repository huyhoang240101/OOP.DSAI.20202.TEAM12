package hust.soict.dsai.sad.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class SortArray extends JPanel {
	
	public static final int DEFAULT_WINDOW_HEGHT = 1280;
	public static final int DEFAULT_WINDOW_WIDTH = 720;
	public static final int DEFAULT_BAR_WIDTH = 10;
	
	private final ArrayList<Integer> array;
	private final int[] barColor;
	
	private int arrayChange = 0; // Number of changes to the array the current algorithm has taken so far
	
	public SortArray() {
		setBackground(Color.DARK_GRAY);
		
		array = new ArrayList<Integer>();
		int NUM_BAR = array.size();
		barColor = new int[NUM_BAR];
		for (int i = 0; i < NUM_BAR; i++) {
			barColor[i] = 0;
		}
	}
	
	public int getArraySize() {
		return array.size();
	}
	
	public int getValue(int index) {
		return array.get(index);
	}
	
	public void finaliseUpdate(long msDelay, boolean isStep) {
		repaint();
        try {
            Thread.sleep(msDelay);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        if (isStep) {
        	arrayChange++;
        }
	}
	
	public void swap(int index1, int index2, long msDelay, boolean isStep) {
		Collections.swap(array, index1, index2);
		
		barColor[index1] = 100;
		barColor[index2] = 100;
		
		finaliseUpdate(msDelay, isStep);
	}
	
	public void updateSingle(int index, int value, long msDelay, boolean isStep) {
		array.set(index, value);
		barColor[index] = 100;
		
		finaliseUpdate(msDelay, isStep);
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		
	}

}
