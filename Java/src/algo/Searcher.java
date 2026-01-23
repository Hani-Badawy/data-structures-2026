package algo;

public class Searcher<T extends Comparable<T>> {
	
	public int linearSearch(T[] arr, T key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(key)) {
				return i;
			}
		}
		return -1;
	}
	
	
	public int binarySearch(T[] arr, T key) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid].equals(key)) {
				return mid;
			}
			if (arr[mid].compareTo(key) < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}
