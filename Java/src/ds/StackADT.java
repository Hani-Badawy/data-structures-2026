/**
 * @author  Hani Mohammed (Badawy)
 */
package ds;

/**
 * An interface for the ADT stack. 
 */
public interface StackADT<T> {
	/**
	 * Pushes an item onto the top of this stack.
	 * @param item the item to be pushed onto this stack
	 */
	public void push(T item);
	
	/**
	 * Removes the object at the top of this stack and returns that
	 * object as the value of this function.
	 * @return The object at the top of this stack (the last item of the
	 *         vector). The stack is modified by this operation.
	 */
	public T pop();
	
	/**
	 * Looks at the object at the top of this stack without removing it
	 * from the stack.
	 * @return The object at the top of this stack (the last item of the
	 *         vector). This stack is not modified by this operation.
	 */
	public T peek();
	
	/**
	 * Tests if this stack is empty.
	 * @return true if and only if this stack contains no items; false
	 *         otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of items in this stack.
	 * @return the number of items in this stack.
	 */
	public int size();
}
