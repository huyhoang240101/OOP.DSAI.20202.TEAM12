package hust.soict.dsai.sad.screen;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingWorker;

import hust.soict.dsai.sad.algoritms.*;
import hust.soict.dsai.sad.main.*;
import hust.soict.dsai.sad.screen.*;

public class SortingDemoScreen extends JFrame {
	private JFrame sort;
    
    public int WIN_WIDTH = 1280;
    public int WIN_HEIGHT = 720;
	
	private SortArray sortArray;
	private ISortAlgorithm algorithm;
	public ArrayList<Integer> array;

	
	public void SortingDemoScreen(ISortAlgorithm thisalgorithm) {
		
		JFrame sort = new JFrame("Sort Visualiser");
		sort.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sort.setVisible(true);
        
		setLayout(new BorderLayout());
		sortArray = new SortArray();
		add(sortArray, BorderLayout.CENTER );
		algorithm = thisalgorithm;
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
				dispose();
			}
		};
		swingWorker.execute();
	}

}