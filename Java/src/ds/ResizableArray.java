package ds;

public interface ResizableArray<T> {
	/**
	 * Adds an element to the end of the array.
	 * 
	 * @param element The element to be added.
	 */
	void add(T element);

	/**
	 * Removes the element at the specified index.
	 * 
	 * @param index The index of the element to be removed.
	 * @throws IndexOutOfBoundsException if the index is out of range.
	 */
	void remove(int index);

	/**
	 * Retrieves the element at the specified index.
	 * 
	 * @param index The index of the element to retrieve.
	 * @return The element at the specified index.
	 * @throws IndexOutOfBoundsException if the index is out of range.
	 */
	void insert(int index, T element);

	/**
	 * Returns the current size of the array.
	 * 
	 * @return The number of elements in the array.
	 */
	int size();

	/**
	 * Clears all elements from the array.
	 */
	void clear();

	/**
	 * Checks if the array is empty.
	 * 
	 * @return true if the array is empty, false otherwise.
	 */
	boolean isEmpty();
}
