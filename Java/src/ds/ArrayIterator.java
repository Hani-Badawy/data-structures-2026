package ds;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {

	Array<T> array;
	int currentIndex;
	
	public ArrayIterator(Array<T> array) {
		this.array = array;
		this.currentIndex = 0;
	}
	
	@Override
	public boolean hasNext() {
		return currentIndex < array.size();
	}

	@Override
	public T next() {
		return array.get(currentIndex++);
	}

}
