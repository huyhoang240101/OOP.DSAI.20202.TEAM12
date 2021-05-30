package hust.soict.dsai.sad.screen;

import java.awt.BorderLayout;

import hust.soict.dsai.sad.main.SortArray;

public class SortingDemoScreen extends Screen {
	
	private SortArray sortArray;
	
	public SortingDemoScreen(SortArray sortArray) {
		setLayout(new BorderLayout());
		sortArray = new SortArray();
		add(sortArray, BorderLayout.CENTER );
		
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
		
	}

}
