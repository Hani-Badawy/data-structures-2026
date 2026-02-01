package ds;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>, LinkListADT<T> {

	Node<T> head;
	Node<T> tail;
	private int count;
	
	LinkedList() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	
	

	@Override
	public Iterator<T> iterator() {
		LinkedListIterator<T> iterator = new LinkedListIterator<T>(this);
		return iterator;
	}

	@Override
	public void addFirst(T node) {
		head = new Node<T>(node);
		if (tail == null) {
			tail = head;
		}
		count++;
	}

	@Override
	public void addLast(T node) {
		tail = new Node<T>(node);
		if (head == null) {
			head = tail;
		}
		count++;
	}

	@Override
	public void removeFirst() {
		if (head != null) {
			head = head.next;
			count--;
		}
	}

	@Override
	public void removeLast() {
		if (tail != null) {
			// Traverse to the second last node
			Node<T> current = head;
			if (current == tail) { // Only one node
				head = null;
				tail = null;
			} else {
				while (current.next != tail) {
					current = current.next;
				}
				current.next = null;
				tail = current;
			}
			count--;
		}
	}

	@Override
	public void insertAt(int index, T node) {
		if (index < 0 || index > count) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
		}
		if (index == 0) {
			addFirst(node);
		} else if (index == count) {
			addLast(node);
		} else {
			Node<T> newNode = new Node<T>(node);
			Node<T> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
			count++;
		}
		
	}

	@Override
	public void removeAt(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
		}
		if (index == 0) {
			removeFirst();
		} else if (index == count - 1) {
			removeLast();
		} else {
			Node<T> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			current.next = current.next.next;
			count--;
		}
		
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
		}
		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.value;
		
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

}
