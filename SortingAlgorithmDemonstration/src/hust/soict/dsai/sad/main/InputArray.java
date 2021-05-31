package hust.soict.dsai.sad.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InputArray {
	
	private static ArrayList<Integer> array = new ArrayList<Integer>();
	private int size;
	
	public static ArrayList<Integer> InputArray() {
		String string = JOptionPane.showInputDialog ("Enter array size");
		int size = Integer.parseInt (string);
		for (int i = 1; i < size+1; i++) {
			String string2 =JOptionPane.showInputDialog("Input array number "+ i);
			int value = Integer.parseInt(string2);
			array.add(value);
		}
		return array;
	}
	
	public int getSize() {
		return size;
	}
	
}
