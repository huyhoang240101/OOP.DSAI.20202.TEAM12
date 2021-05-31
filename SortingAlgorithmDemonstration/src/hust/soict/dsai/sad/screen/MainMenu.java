package hust.soict.dsai.sad.screen;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.sad.algoritms.BubbleSort;
import hust.soict.dsai.sad.main.InputArray;
import hust.soict.dsai.sad.main.RandomArray;

public class MainMenu extends JFrame {
	Container cp = getContentPane();
	public JFrame frame = new JFrame();
	public JFrame createarray = new JFrame();
	private SortingDemoScreen sortingScreen;
	
	
	public MainMenu() {
		
		frame.setLayout(new GridLayout(5,1));
		frame.setLocationRelativeTo(null);
		
		JButton BubbleSortButton = new JButton("Bubble Sort");
		frame.add(BubbleSortButton);
		
		JButton QuickSortButton = new JButton("Quick Sort");
		frame.add(QuickSortButton);
		
		JButton InsertionSortButton = new JButton("Insertion Sort");
		frame.add(InsertionSortButton);
		
		JButton HelpMenu = new JButton("Help");
		frame.add(HelpMenu);
		
		JButton ExitButton = new JButton("Exit");
		frame.add(ExitButton);
		
		frame.setVisible(true);
		frame.setTitle("Sorting Algorithm Demonstration");
		frame.setSize(400, 200);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonListener btnListener = new ButtonListener();
		HelpMenu.addActionListener(btnListener);
		ExitButton.addActionListener(btnListener);
		BubbleSortButton.addActionListener(btnListener);
		QuickSortButton.addActionListener(btnListener);
		InsertionSortButton.addActionListener(btnListener);
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
			if(button.equals("Bubble Sort")) {
				frame.setVisible(false);
				CreateArray();	
				JLabel label1 = new JLabel("Bubble Sort");
				label1.setHorizontalTextPosition(JLabel.CENTER);
				label1.setHorizontalAlignment(JLabel.CENTER);
				label1.setVerticalTextPosition(JLabel.CENTER);
				createarray.add(label1);
			}
			if(button.equals("Quick Sort")) {
				frame.setVisible(false);
				CreateArray();	
				JLabel label2 = new JLabel("Quick Sort");
				label2.setHorizontalTextPosition(JLabel.CENTER);
				label2.setHorizontalAlignment(JLabel.CENTER);
				label2.setVerticalTextPosition(JLabel.CENTER);
				createarray.add(label2);
			}
			if(button.equals("Insertion Sort")) {
				frame.setVisible(false);
				CreateArray();	
				JLabel label3 = new JLabel("Insertion Sort");
				label3.setHorizontalTextPosition(JLabel.CENTER);
				label3.setHorizontalAlignment(JLabel.CENTER);
				label3.setVerticalTextPosition(JLabel.CENTER);
				createarray.add(label3);
			}
		}	
	}							
	
	public static void main(String[] args) {
		new MainMenu();
		// TODO Auto-generated method stub
	}

	public void CreateArray() {
			createarray.setLayout(new GridLayout(3,1));
			
			JButton RandomArrayButton = new JButton("Random Array");
			createarray.add(RandomArrayButton);
			RandomArray randomarray = new RandomArray();
			RandomArrayButton.addActionListener(randomarray);
			
			JButton InputArrayButton = new JButton("Input Array");
			createarray.add(InputArrayButton);
			InputArray inputarray = new InputArray();
			InputArrayButton.addActionListener(inputarray);
			
			createarray.setVisible(true);
			createarray.setTitle("Create Array");
			createarray.setSize(400,200);
			createarray.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			
		}
	}

