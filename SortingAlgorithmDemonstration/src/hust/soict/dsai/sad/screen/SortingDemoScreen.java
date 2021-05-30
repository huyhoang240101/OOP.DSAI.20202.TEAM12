package hust.soict.dsai.sad.screen;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingWorker;

import hust.soict.dsai.sad.algoritms.ISortAlgorithm;
import hust.soict.dsai.sad.main.InputArray;
import hust.soict.dsai.sad.main.RandomArray;
import hust.soict.dsai.sad.main.SortArray;

public class SortingDemoScreen extends JFrame {
	
	private SortArray sortArray;
	private ISortAlgorithm algorithm;
	private RandomArray randomArray;
	private InputArray inputArray;
	
	public SortingDemoScreen(ISortAlgorithm thisalgorithm) {
		
		
		setLayout(new BorderLayout());
		sortArray = new SortArray(randomArray);
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
	
//	public void onOpen() {
//		SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {
//
//			@Override
//			protected Void doInBackground() throws Exception {
//				
//				try {
//					Thread.sleep(250);
//				}
//				catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				
//				sortArray.setName(algorithm.getName());
//				sortArray.setAlgorithm(algorithm);
//				
//				algorithm.runSort(sortArray);
//				sortArray.resetColor();
//				sortArray.highlightArray();
//				sortArray.resetColor();
//				longSleep();
//				return null;
//			}
//			
//			public void done() {
//				dispose();
//			}
//		};
//		swingWorker.execute();
//	}

}
