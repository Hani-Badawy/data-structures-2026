package ds;

import java.util.Iterator;

public class LinkedListIterator<T> implements Iterator<T> {

	LinkedList<T> list;
	int currentIndex;
	
	public LinkedListIterator(LinkedList<T> list) {
		this.list = list;
		this.currentIndex = 0;
	}
	
	@Override
	public boolean hasNext() {
		 return currentIndex < list.size();
	}

	@Override
	public T next() {
		Node<T> currentNode = list.head;
		for (int i = 0; i < currentIndex; i++) {
			if (currentNode != null) {
				currentNode = currentNode.next;
			}
		}
		currentIndex++;
		return currentNode != null ? currentNode.value : null;
	}

}
