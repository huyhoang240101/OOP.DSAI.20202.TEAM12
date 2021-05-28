package hust.soict.dsai.sad.algoritms;

import hust.soict.dsai.sad.main.SortArray;

public class QuickSort implements ISortAlgorithm {
	
	private long stepDelay = 30;
	
	private int partition(SortArray array, int low, int high) {
		int pivot = array.getValue(high);
		int i = low - 1;
		
		for (int j = low; j <= high -1; j++) {
			if (array.getValue(j) <= pivot) {
				i++;
				array.swap(i, j, getDelay(), true);
			}
		}
		array.swap(i+1, high, getDelay(), true);
		return (i+1);
	}
	
	private void quickSort(SortArray array, int low, int high) {
		if (low < high) {
			int pivot = partition(array, low, high);
			
			quickSort(array, low, pivot - 1);
			quickSort(array, pivot + 1, high);
		}
	}

	@Override
	public String getName() {
		return "Quick Sort";
	}

	@Override
	public long getDelay() {
		return stepDelay;
	}

	@Override
	public void setDelay(long delay) {
		this.stepDelay = delay;
	}

	@Override
	public void runSort(SortArray array) {
		quickSort(array, 0, array.getArraySize() - 1);
		
	}

}
