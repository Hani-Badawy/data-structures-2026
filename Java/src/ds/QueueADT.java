package ds;

public interface QueueADT<T>{
	
	/** Adds an element to the end of the queue
	 * @param item - the item to add
	 *  */
	void enqueue(T item);
	
	/** Removes and returns the element at the front of the queue
	 * @return the item removed from the front of the queue
	 *  */
	T dequeue() throws Exception;
	
	/** Returns the element at the front of the queue without removing it
	 * @return the item at the front of the queue
	 *  */
	T peek();
	
	/** Returns true if the queue is empty */
	boolean isEmpty();
	
	/** Returns the number of elements in the queue */
	int length();
}
