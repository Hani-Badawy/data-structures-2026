package algo;

public class Sorter<T extends Comparable<T>> {

	public void selectionSort(T[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j].compareTo(arr[minIndex]) < 0) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(arr, i, minIndex);
			}
		}
	}
	
	public void bubbleSort(T[] arr) {
		int n = arr.length;
		boolean swapped;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j].compareTo(arr[j+1])>0) {
					swap(arr, j, j + 1);
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}
	
	public void insertionSort(T[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			T key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j].compareTo(key) > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}
	
	public void mergeSort(T[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}
	
	private void merge(T[] arr, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;
		T[] L = (T[]) new Object[n1];
		T[] R = (T[]) new Object[n2];
		for (int i = 0; i < n1; i++) {
			L[i] = arr[left + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = arr[mid + 1 + j];
		}
		int i = 0, j = 0;
		int k = left;
		while (i < n1 && j < n2) {
			if (L[i].compareTo(R[j]) <= 0) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	
	private void swap(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
