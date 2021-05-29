package hust.soict.dsai.sad.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InputArray implements ActionListener {
	
	private ArrayList<Integer> array = new ArrayList<Integer>();
	private int size;
	
	
	public ArrayList<Integer> getArray() {
		return array;
	}


	public int getSize() {
		return size;
	}

	public void actionPerformed(ActionEvent e) {
		JFrame input = new JFrame();
		String string = JOptionPane.showInputDialog ("Enter array size");
		int size = Integer.parseInt (string);
		for (int i = 1; i < size+1; i++) {
			String string2 =JOptionPane.showInputDialog("Input array number "+ i);
			int value = Integer.parseInt(string2);
			array.add(value);
		}
		JOptionPane.showMessageDialog(input, array,"Input Array",
				JOptionPane.INFORMATION_MESSAGE);	
	}
}
