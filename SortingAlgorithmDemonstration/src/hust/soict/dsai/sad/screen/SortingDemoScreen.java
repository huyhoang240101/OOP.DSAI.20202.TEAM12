package hust.soict.dsai.sad.screen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import hust.soict.dsai.sad.algoritms.BubbleSort;
import hust.soict.dsai.sad.algoritms.ISortAlgorithm;
import hust.soict.dsai.sad.algoritms.InsertionSort;
import hust.soict.dsai.sad.algoritms.QuickSort;
import hust.soict.dsai.sad.main.Input;
import hust.soict.dsai.sad.main.SortArray;

public class SortingDemoScreen extends JFrame implements Input {
	
	private SortArray sortArray;
	private ISortAlgorithm algorithm;

	public SortingDemoScreen(ISortAlgorithm thisalgorithm, SortArray thissortArray) {
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setVisible(true);
		setLayout(new BorderLayout());
		sortArray = thissortArray;
		add(sortArray, BorderLayout.CENTER );
		algorithm = thisalgorithm;
		setTitle("Sorting Demonstration");
		
		JMenuBar menubar = new JMenuBar();
		add (menubar, BorderLayout.NORTH);
		menubar.setLayout(new FlowLayout());
		
		JMenuItem reset = new JMenuItem("Reset");
		RandomArray randomar = new RandomArray();
		reset.addActionListener(randomar);

		JMenuItem input = new JMenuItem("Input");
		InputArray inputar = new InputArray();
		input.addActionListener(inputar);
			
		JMenuItem help = new JMenuItem("Help");
		Help me = new Help();
		help.addActionListener(me);
		
		JMenuItem bubblesort = new JMenuItem("Bubble Sort");
		Bubble2 bb = new Bubble2();
		bubblesort.addActionListener(bb);
	
		JMenuItem insertionsort = new JMenuItem("Insertion Sort");
		Insertion2 is = new Insertion2();
		insertionsort.addActionListener(is);
	
		JMenuItem quicksort = new JMenuItem("Quick Sort");
		Quick2 qs = new Quick2();
		quicksort.addActionListener(qs);
		
		menubar.add(reset);
		menubar.add(input);
		menubar.add(bubblesort);
		menubar.add(insertionsort);
		menubar.add(quicksort);
		menubar.add(help);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ExitApp();
	}
	
	private void longSleep() {
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void onOpen() {
		SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {

			@Override
			protected Void doInBackground() throws Exception {
				
				try {
					Thread.sleep(250);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
								
				sortArray.setName(algorithm.getName());
				sortArray.setAlgorithm(algorithm);
				
				algorithm.runSort(sortArray);
				sortArray.resetColor();
				sortArray.highlightArray();
				sortArray.resetColor();
				longSleep();
				return null;
			}
			
			public void done() {
				//dispose();
			}
		};
		swingWorker.execute();
	}
	public class Bubble2  implements ActionListener,Input {
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			SortArray sorting = new SortArray(array);
			SortingDemoScreen begin = new SortingDemoScreen(new BubbleSort(), sorting);
			begin.onOpen();
		}
	}
	
	public class Insertion2 implements ActionListener,Input {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			SortArray sorting = new SortArray(array);
			SortingDemoScreen begin = new SortingDemoScreen( new InsertionSort(), sorting);
			begin.onOpen();			
		}	
	}
	
	public class Quick2 implements ActionListener, Input {

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			SortArray sorting = new SortArray(array);
			SortingDemoScreen begin = new SortingDemoScreen( new QuickSort(), sorting);
			begin.onOpen();
		}	
	}
	
	public class Help implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Array is the most basic structure of computer science.\r\n" + 
					"Most operations as well as other data structures are built and performed on array. \r\n" +
								"This program is to  explain three sorting algorithms on array: bubble sort, quicksort and insertion sort.", "Help", 
		                        JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void ExitApp()
	   {
	      addWindowListener((WindowListener) new WindowAdapter()
	      {
	         public void windowClosing(WindowEvent e)
	         {
	        	 int n = JOptionPane.showConfirmDialog(
				            null, "Are you sure you want to exit?", 
				            "Exit", JOptionPane.YES_NO_OPTION);
					if(n == JOptionPane.YES_OPTION)
						System.exit(0);
	         }
	      });
	   }
}