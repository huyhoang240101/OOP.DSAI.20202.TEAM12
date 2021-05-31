package hust.soict.dsai.sad.screen;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingWorker;

import hust.soict.dsai.sad.algoritms.ISortAlgorithm;
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
}