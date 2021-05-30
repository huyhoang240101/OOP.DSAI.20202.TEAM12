package hust.soict.dsai.sad.main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import hust.soict.dsai.sad.screen.MainMenu;

public class InputArray extends MainMenu implements ActionListener {
	
	private ArrayList<Integer> array = new ArrayList<Integer>();
	private int size;

	public ArrayList<Integer> getArray() {
		return array;
	}

	public void setSize(int size) {
		this.size = size;
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
