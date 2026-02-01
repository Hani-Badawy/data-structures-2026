package ds;

public interface LinkListADT<T> {
	
	/** Adds an element to the beginning of the list
	 * @param node - the node to add
	 *  */
	void addFirst(T node);
	
	/** Adds an element to the end of the list
	 * @param node - the node to add
	 *  */
	void addLast(T node);
	
	/** Removes the first element in the list */
	void removeFirst();
	
	/** Removes the last element in the list */
	void removeLast();
	
	/** Inserts the specified element at the specified index
	 * 	@param index - the index to insert the node at
	 * 	@param node - the node to insert
	 *  */
	void insertAt(int index, T node);
	
	/** Removes the element at the specified index
	 * 	@param index - the index of the node to remove
	 *  */
	void removeAt(int index);
	
	/** Returns the element at the specified index
	 * 	@param index - the index of the node to return
	 *  */
	T get(int index);
	
	/** Returns the number of nodes in the list */
	int size();
	
	/** Returns true if the list is empty */
	boolean isEmpty();
}
