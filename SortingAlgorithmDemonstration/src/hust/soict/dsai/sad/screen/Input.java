package hust.soict.dsai.sad.screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public interface Input {
	int MAX_SIZE = 12;
	int MIN_SIZE = 5;
	int MAX_VALUE = 40;
	int MIN_VALUE = 1;
	
	ArrayList<Integer> array = new ArrayList<>() ;

	public static void RandomArray() {
		int size = (int)Math.floor(Math.random()*(MAX_SIZE - MIN_SIZE + 1)+ MIN_SIZE);
		for (int i = 0; i < size; i++) {
			int random_value = (int)Math.floor(Math.random()*(MAX_VALUE - MIN_VALUE + 1)+ MIN_VALUE);
			array.add(random_value);
		}
	}
	public class RandomArray implements ActionListener{		
			@Override
			public void actionPerformed(ActionEvent e) {
				array.clear();
				RandomArray();
				JFrame input = new JFrame();
				JOptionPane.showMessageDialog(input, array,"Random Array",
						JOptionPane.INFORMATION_MESSAGE);
			}
	}
	public class InputArray implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame input = new JFrame();
			array.clear();
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
}
		
		
	

	




