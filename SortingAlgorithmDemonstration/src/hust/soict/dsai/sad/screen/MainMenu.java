package hust.soict.dsai.sad.screen;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

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
	}

	public static void main(String[] args) {
		new MainMenu();
		// TODO Auto-generated method stub

	}

}
