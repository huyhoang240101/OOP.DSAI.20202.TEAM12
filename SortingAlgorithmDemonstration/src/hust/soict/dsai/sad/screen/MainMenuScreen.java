package hust.soict.dsai.sad.screen;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.sad.algoritms.*;
import hust.soict.dsai.sad.main.*;
import hust.soict.dsai.sad.main.Input.InputArray;
import hust.soict.dsai.sad.main.Input.RandomArray;

public class MainMenuScreen  extends JFrame  {
	Container cp = getContentPane();
	public JFrame createarray = new JFrame();
	public JFrame window = new JFrame();
    public static final int WIN_WIDTH = 1280;
    public static final int WIN_HEIGHT = 720;
 
	public ArrayList<Integer> array;
	

	public MainMenuScreen() {
		
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
		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			         {
			        	 int n = JOptionPane.showConfirmDialog(
						            null, "Are you sure you want to exit?", 
						            "Exit", JOptionPane.YES_NO_OPTION);
							if(n == JOptionPane.YES_OPTION)
								System.exit(0);
			         }
			      });
			   
	
		
		ButtonListener btnListener = new ButtonListener();
		HelpMenu.addActionListener(btnListener);
		ExitButton.addActionListener(btnListener);
		BubbleSortButton.addActionListener(btnListener);
		QuickSortButton.addActionListener(btnListener);
		InsertionSortButton.addActionListener(btnListener);

	}
	
	public class ButtonListener implements ActionListener{
		
			
		@Override
		public void actionPerformed(ActionEvent e) {
			String button =e.getActionCommand();
				
			if (button.equals("Exit")) {
				int n = JOptionPane.showConfirmDialog(
			            null, "Are you sure you want to exit?", 
			            "Exit", JOptionPane.YES_NO_OPTION);
				if(n == JOptionPane.YES_OPTION)
					System.exit(0);
			}
			
			if (button.equals("Help")) {					
				showHelpMenu();
			}
			
			if(button.equals("Bubble Sort")) {
				CreateArray();		
						
				JButton start1 = new JButton("Start");
				Bubble BS = new Bubble();
				start1.addActionListener(BS);	
				createarray.add(start1);
				
				JLabel label1 = new JLabel("Bubble Sort");
				label1.setHorizontalTextPosition(JLabel.CENTER);
				label1.setHorizontalAlignment(JLabel.CENTER);
				label1.setVerticalTextPosition(JLabel.CENTER);
				createarray.add(label1);
			}
			
			if(button.equals("Quick Sort")) {
				CreateArray();	
				
				JButton start2 = new JButton("Start");
				Quick QS = new Quick();
				start2.addActionListener(QS);	
				createarray.add(start2);
				
				JLabel label2 = new JLabel("Quick Sort");
				label2.setHorizontalTextPosition(JLabel.CENTER);
				label2.setHorizontalAlignment(JLabel.CENTER);
				label2.setVerticalTextPosition(JLabel.CENTER);
				createarray.add(label2);
			}
			
			if(button.equals("Insertion Sort")) {
				CreateArray();	
				
				JButton start3 = new JButton("Start");
				Insertion IS = new Insertion();
				start3.addActionListener(IS);	
				createarray.add(start3);
				
				JLabel label3 = new JLabel("Insertion Sort");
				label3.setHorizontalTextPosition(JLabel.CENTER);
				label3.setHorizontalAlignment(JLabel.CENTER);
				label3.setVerticalTextPosition(JLabel.CENTER);
				createarray.add(label3); 
			}
		}
	}							

	public void CreateArray()  {
			JButton RandomArrayButton = new JButton("Random Array");
			createarray.add(RandomArrayButton);
			RandomArray randomarray = new RandomArray();
			RandomArrayButton.addActionListener(randomarray);
			
			JButton InputArrayButton = new JButton("Input Array");
			createarray.add(InputArrayButton);
			InputArray inputarray = new InputArray();
			InputArrayButton.addActionListener(inputarray);
						
			createarray.setLayout(new GridLayout(4,1));
			createarray.setVisible(true);
			window.setVisible(false);
			createarray.setTitle("Create Array");
			createarray.setSize(400,200);
			createarray.setLocationRelativeTo(null);
			createarray.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			
			createarray.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e)
				{
					int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?",
							"Exit", JOptionPane.YES_NO_OPTION);
					if(n == JOptionPane.YES_OPTION)
						System.exit(0);
				}
			});	     
	}
	
	public class Bubble  implements ActionListener,Input {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			SortArray sorting = new SortArray(array);
			SortingDemoScreen begin = new SortingDemoScreen(new BubbleSort(), sorting);
			begin.onOpen();
		}
	}
	
	public class Insertion implements ActionListener,Input {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			SortArray sorting = new SortArray(array);
			SortingDemoScreen begin = new SortingDemoScreen( new InsertionSort(), sorting);
			begin.onOpen();			
		}	
	}
	
	public class Quick implements ActionListener, Input {

		@Override
		public void actionPerformed(ActionEvent e) {
			SortArray sorting = new SortArray(array);
			SortingDemoScreen begin = new SortingDemoScreen( new QuickSort(), sorting);
			begin.onOpen();
		}	
	}
	
	public static void main(String [] args) {
		new MainMenuScreen();
	}
	
	public void showHelpMenu() {
		JOptionPane.showMessageDialog(null, 
				"Array is the most basic structure of computer science.\r\n" + 
		"Most operations as well as other data structures are built and performed on array. \r\n" +
						"This program is to  explain three sorting algorithms on array: bubble sort, quicksort and insertion sort. \r\n \r\n" +
		"First as you can see there are 5 buttons here. \r\n"+
						"3 buttons are for choosing the way of sorting (Bubble Sort, Insertion Sort and Quick Sort). \r\n" +
		"After choosing sorting type you can choose to input the array or randomly create the array. \r\n "+
						"Then you can choose to start the sorting or choose to create the array again. \r\n \r\n"+
		"One button for the help menu to understand the aim of this program and how to use.\r\n"+
						"And one more button to exit the program."
				,"Help", 
                JOptionPane.INFORMATION_MESSAGE);
	}
}
	
		
		

	

