package hust.soict.dsai.sad.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import hust.soict.dsai.sad.screen.MainMenu;

<<<<<<< HEAD
public class RandomArray  implements ActionListener {
=======
import hust.soict.dsai.sad.algoritms.BubbleSort;
import hust.soict.dsai.sad.screen.SortingDemoScreen;

public class RandomArray implements ActionListener {
>>>>>>> 4b170bc375d6417580e1f1ee686706d8c1eb678d
	
	private final int MAX_SIZE = 12;
	private final int MIN_SIZE = 5;
	
	private final int MAX_VALUE = 40;
	private final int MIN_VALUE = 1;
	
	private ArrayList<Integer> array;
	private int size;
	private SortingDemoScreen sortingScreen;
	
<<<<<<< HEAD
	
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void RandomArray() {
=======
	public RandomArray() {
>>>>>>> 4b170bc375d6417580e1f1ee686706d8c1eb678d
		size = (int)Math.floor(Math.random()*(MAX_SIZE - MIN_SIZE + 1)+ MIN_SIZE);
		array = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			int random_value = (int)Math.floor(Math.random()*(MAX_VALUE - MIN_VALUE + 1)+ MIN_VALUE);
			array.add(random_value);
		}
	}

	public ArrayList<Integer> getArray() {
		return array;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new RandomArray();
		JFrame input = new JFrame();
		JOptionPane.showMessageDialog(input, array,"Random Array",
				JOptionPane.INFORMATION_MESSAGE);
		new SortingDemoScreen(new BubbleSort());
		}
}
