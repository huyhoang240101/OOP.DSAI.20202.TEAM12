package hust.soict.dsai.sad.algoritms;

import hust.soict.dsai.sad.main.SortArray;

public interface ISortAlgorithm {
	
	public String getName();

    public long getDelay();

    public void setDelay(long delay);

    public void runSort(SortArray array);

}
