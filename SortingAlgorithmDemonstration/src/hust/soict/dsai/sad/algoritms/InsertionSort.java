package hust.soict.dsai.sad.algoritms;

import hust.soict.dsai.sad.main.SortArray;

public class InsertionSort implements ISortAlgorithm {
	
	private long stepDelay = 1000;
	
	public void runSort(SortArray array) {
		//key is the updateSingle() method in sortArray
		int key;
		int length = array.getArraySize();
		for(int i = 1; i < length; i++) {
			key = array.getValue(i);
			int j = i -1;
			
			while (j >= 0 && array.getValue(j) > key) {
				array.updateSingle(j + 1, j, 5, true);;
				j = j-1;
			}
			array.updateSingle(j+1, key, getDelay(), true);;
		}
	}

	@Override
	public String getName() {
		return "Insertion Sort";
	}

	@Override
	public long getDelay() {
		return stepDelay;
	}

	@Override
	public void setDelay(long delay) {
		this.stepDelay = delay;
		
	}
}
