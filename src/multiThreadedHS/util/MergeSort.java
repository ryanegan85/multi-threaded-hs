package multiThreadedHS.util;

import java.util.ArrayList;

/*
Referenced https://www.tutorialspoint.com/data_structures_algorithms/merge_sort_algorithm
for merge sort algorithm
*/
public class MergeSort {
	//ArrayList<Integer> valuesList;
	//private int[] values;
	//Results res;
	
	/*
	public MergeSort(Results res) {
		this.res = res;
		valuesList = res.getData();
		
		values = new int[valuesList.size()];
		for(int i=0; i<values.length; i++) {
			values[i] = valuesList.get(i).intValue();
		}
	}
	*/
	public MergeSort() {}
	
	public ArrayList<Integer> mergeSort(ArrayList<Integer> arr) {
		int[] values = new int[arr.size()];
		for(int i=0; i<values.length; i++) {
			values[i] = arr.get(i).intValue();
		}
		
		sort(values, 0, values.length-1);
		
		ArrayList<Integer> sortedArray = new ArrayList<Integer>();
		for(int i : values) {
			sortedArray.add(i);
		}
		
		return sortedArray;
	}
	
	public void sort(int[] array, int l, int r) {
		int m;
		if(r > l) {
			m = (l+r)/2;
			
			sort(array, l,m);
			
			sort(array, m+1, r);
			
			merge(array, l, m, r);
		}
	}
	
	public void merge(int[] array, int l, int m, int r) {
		int i;
		int j;
		int k;
		
		int l1 = m - l + 1;
		int l2 = r - m;
		
		int tempL[] = new int[l1];
		int tempR[] = new int[l2];
		
		for(i=0; i<l1; ++i) {
			tempL[i] = array[l+i];
		}
		for(j=0; j<l2; ++j) {
			tempR[j] = array[m+1+j];
		}
		
		k = l;
		i = 0;
		j = 0;
		
		while(i < l1 && j < l2) {
			if(tempL[i] <= tempR[j]) {
				array[k] = tempL[i];
				i++;
			} else {
				array[k] = tempR[j];
				j++;
			}
			k++;
		}
		
		while(i < l1) {
			array[k] = tempL[i];
			i++;
			k++;
		}
		
		while(j < l2) {
			array[k] = tempR[j];
			j++;
			k++;
		}
	}
}
