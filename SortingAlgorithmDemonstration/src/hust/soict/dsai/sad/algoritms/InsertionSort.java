package hust.soict.dsai.sad.algoritms;

public class InsertionSort {
	
	public void runSort(int[] arr, int length) {
		//key is the updateSingle() method in sortArray
		int key;
		for(int i = 1; i < length; i++) {
			key = arr[i];
			int j = i -1;
			
			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j+1] = key;
		}
	}

}
