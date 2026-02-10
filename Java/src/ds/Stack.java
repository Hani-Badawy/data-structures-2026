package ds;

public class Stack<T> implements StackADT<T> {

	private T[] data;
	private int size;
	private int capacity;
	
	public Stack() {
		this.capacity = 10;
		this.data = (T[]) new Object[capacity];
		this.size = 0;
	}
	
	public Stack(int capacity) {
		this.capacity = capacity;
		this.data = (T[]) new Object[capacity];
		this.size = 0;
	}
	
	
	
	@Override
	public void push(T item) {
		if (size == capacity) {
			throw new IllegalStateException("Stack is full");
		}
		data[size++] = item;
	}

	@Override
	public T pop() {
		return data[--size];
	}

	@Override
	public T peek() {
		return data[size - 1];
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

}
