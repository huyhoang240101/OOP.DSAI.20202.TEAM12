package hust.soict.dsai.sad.screen;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.sad.algoritms.*;
import hust.soict.dsai.sad.main.*;
import hust.soict.dsai.sad.screen.Input.RandomArray;
import hust.soict.dsai.sad.screen.Input.InputArray;

public class MainMenu  extends JFrame  {
	Container cp = getContentPane();
	public JFrame createarray = new JFrame();
	public JFrame window = new JFrame();
    public static final int WIN_WIDTH = 1280;
    public static final int WIN_HEIGHT = 720;
    

    private final int MAX_SIZE = 12;
	private final int MIN_SIZE = 5;
	
	private final int MAX_VALUE = 40;
	private final int MIN_VALUE = 1;
	private int size;
	public ArrayList<Integer> array;

	
	public MainMenu() {
		
		window.setLayout(new GridLayout(5,1));
		
		JButton BubbleSortButton = new JButton("Bubble Sort");
		window.add(BubbleSortButton);
		
		JButton QuickSortButton = new JButton("Quick Sort");
		window.add(QuickSortButton);
		
		JButton InsertionSortButton = new JButton("Insertion Sort");
		window.add(InsertionSortButton);
		
		JButton HelpMenu = new JButton("Help");
		window.add(HelpMenu);
		
		JButton ExitButton = new JButton("Exit");
		window.add(ExitButton);
		
		window.setVisible(true);
		window.setTitle("Sorting Algorithm Demonstration");
		window.setSize(400, 200);	
		window.setLocationRelativeTo(null);
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
				window.setVisible(false);
				CreateArray();	
				JLabel label1 = new JLabel("Bubble Sort");
				label1.setHorizontalTextPosition(JLabel.CENTER);
				label1.setHorizontalAlignment(JLabel.CENTER);
				label1.setVerticalTextPosition(JLabel.CENTER);
				createarray.add(label1); 
				ISortAlgorithm BubbleSort;

			}
			if(button.equals("Quick Sort")) {
				window.setVisible(false);
				CreateArray();	
				JLabel label2 = new JLabel("Quick Sort");
				label2.setHorizontalTextPosition(JLabel.CENTER);
				label2.setHorizontalAlignment(JLabel.CENTER);
				label2.setVerticalTextPosition(JLabel.CENTER);
				createarray.add(label2);
			}
			if(button.equals("Insertion Sort")) {
				window.setVisible(false);
				CreateArray();	
				JLabel label3 = new JLabel("Insertion Sort");
				label3.setHorizontalTextPosition(JLabel.CENTER);
				label3.setHorizontalAlignment(JLabel.CENTER);
				label3.setVerticalTextPosition(JLabel.CENTER);
				createarray.add(label3);
			}
		}
		
	}							

	public void CreateArray()  {
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
			createarray.setLocationRelativeTo(null);
			createarray.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		}
	
	

	
	public static void main(String [] args) {
		new MainMenu();
	}
}
	
	
		
		
		
	

	

