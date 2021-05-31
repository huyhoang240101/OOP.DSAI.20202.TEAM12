package hust.soict.dsai.sad.algoritms;

import hust.soict.dsai.sad.main.SortArray;

public class BubbleSort implements ISortAlgorithm {
	
	private long stepDelay = 1000;
	
	public void runSort(SortArray array) {
		int length = array.getArraySize();
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (array.getValue(j) > array.getValue(j + 1)) {
					array.swap(j, j+1, getDelay(), true);
				}
			}
		}
	}

	@Override
	public String getName() {
		return "Bubble Sort";
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