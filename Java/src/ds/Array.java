package ds;

import java.util.Iterator;

public class Array<T> implements ResizableArray<T>, Iterable<T> {
	
	
	
	private Object[] elements;
	private int count;
	
	
	@Override
	public Iterator<T> iterator() {
		ArrayIterator<T> iterator = new ArrayIterator<>(this);
		return iterator;
	}

	
	public Array() {
		elements = new Object[10];
		count = 0;
	}
	
	@Override
	public void add(T element) {
		if (count == elements.length) {
			Object[] newElements = new Object[elements.length * 2]; // Double the size
			System.arraycopy(elements, 0, newElements, 0, elements.length);
			elements = newElements;
		}
		elements[count++] = element;
	}

	@Override
	public void remove(int index) {
		for (int i = index; i < count - 1; i++) {
			elements[i] = elements[i + 1];
		}
		count--;
	}

	@Override
	public void insert(int index, T element) {
		if (count == elements.length) {
			Object[] newElements = new Object[elements.length * 2]; // Double the size
			System.arraycopy(elements, 0, newElements, 0, elements.length);
			elements = newElements;
		}
		for (int i = count; i > index; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = element;
		count++;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void clear() {
		count = 0;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(elements[i]);
			if (i < count - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
	
	public T get(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
		}
		return (T) elements[index];
	}
	

}
