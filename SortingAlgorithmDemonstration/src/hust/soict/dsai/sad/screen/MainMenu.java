package hust.soict.dsai.sad.screen;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainMenu extends JFrame {
	public MainMenu() {
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(5,1));
		
		JButton BubbleSortButton = new JButton("Bubble Sort");
		cp.add(BubbleSortButton);
		
		JButton QuickSortButton = new JButton("Quick Sort");
		cp.add(QuickSortButton);
		
		JButton InsertionSortButton = new JButton("Insertion Sort");
		cp.add(InsertionSortButton);
		
		JButton HelpMenu = new JButton("Help");
		cp.add(HelpMenu);
		
		JButton ExitButton = new JButton("Exit");
		cp.add(ExitButton);
		
		setVisible(true);
		setTitle("Sorting Algorithm Demonstration");
		setSize(400, 200);	
		
		ButtonListener btnListener = new ButtonListener();
		HelpMenu.addActionListener(btnListener);
		ExitButton.addActionListener(btnListener);
	}
	
	private class ButtonListener implements ActionListener{
		private JPanel panel;
		@Override
		public void actionPerformed(ActionEvent e) {
			String button =e.getActionCommand();
			if (button.equals("Exit")) {
				int n = JOptionPane.showConfirmDialog(
			            panel, "Are you sure you want to exit?", 
			            "Exit", JOptionPane.YES_NO_OPTION);
				if(n == JOptionPane.YES_OPTION)
					System.exit(0);
			}
			if (button.equals("Help")) {					
				JOptionPane.showMessageDialog(panel, "Array is the most basic structure of computer science.\r\n" + 
			"Most operations as well as other data structures are built and performed on array. \r\n" +
						"This program is to  explain three sorting algorithms on array: bubble sort, quicksort and insertion sort.", "Help", 
                        JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}							
	
	public static void main(String[] args) {
		new MainMenu();
		// TODO Auto-generated method stub
	}
}
