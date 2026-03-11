package ds;

public interface BSTAdt<T extends Comparable<T>> {
	/**
	 * Insert a new value into the BST
	 * @param value the value to be inserted
	 */
	public void insert(BSTNode<T> node);
	
	/**
	 * Search for a value in the BST
	 * @param value the value to be searched
	 * @return true if the value is found, false otherwise
	 */
	public boolean search(T value);
	
	/**
	 * Delete a value from the BST
	 * @param value the value to be deleted
	 * @return true if the value is deleted, false otherwise
	 */
	public boolean delete(T value);
	
	/**
	 * Traverse the BST in-order
	 */	
	public void inOrderTraversal();
	
	/**
	 * Traverse the BST pre-order
	 */
	public void preOrderTraversal();
		
	/**
	 * Traverse the BST post-order
	 */
	public void postOrderTraversal();

}
