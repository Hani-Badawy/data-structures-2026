package ds;

public class BST<T extends Comparable<T>> implements BSTAdt<T> {

	BSTNode<T> root;
	
	BST() {
		this.root = null;
	}
	
	
	@Override
	public void insert(BSTNode<T> node) {
		if (root == null) {
			root = node;
		} else {
			insert(root, node);
		}
	}
	
	private void insert(BSTNode<T> current, BSTNode<T> newNode) {
		if ( newNode.compareTo(current) < 0) {
			if (current.left == null) {
				current.left = newNode;
			} else {
				insert(current.left, newNode);
			}
		} else {
			if (current.right == null) {
				current.right = newNode;
			} else {
				insert(current.right, newNode);
			}
		}

	}

	@Override
	public boolean search(T value) {
		return search(root, value);
	}

	private boolean search(BSTNode<T> current, T value) {
		if (current == null) {
			return false;
		}
		if (current.value.equals(value)) {
			return true;
		}
		if (value.compareTo(current.value) < 0) {
			return search(current.left, value);
		} else {
			return search(current.right, value);
		}
	}

	
	
	private BSTNode<T> findMin(BSTNode<T> node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	private BSTNode<T> findMax(BSTNode<T> node) {
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}
	
	@Override
	public boolean delete(T value) {
		 root = delete(root, value);
		 return root != null;
	}
	
	private BSTNode<T> delete(BSTNode<T> current, T value) {
		if (current == null) {
			return null;
		}
		if (value.compareTo(current.value) < 0) {
			current.left = delete(current.left, value);
		} else if (value.compareTo(current.value) > 0) {
			current.right = delete(current.right, value);
		} else {
			if (current.left == null) {
				return current.right;
			} else if (current.right == null) {
				return current.left;
			}
			BSTNode<T> temp = findMin(current.right);
			current.value = temp.value;
			current.right = delete(current.right, temp.value);
		}
		return current;
	}
	
	@Override
	public void inOrderTraversal() {
		inOrderTraversal(root);
		
	}

	private void inOrderTraversal(BSTNode<T> node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.println(node.value);
			inOrderTraversal(node.right);
		}
	}	
		
	@Override
	public void preOrderTraversal() {
		preOrderTraversal(root);
		
	}

	private void preOrderTraversal(BSTNode<T> node) {
		if (node != null) {
			System.out.println(node.value);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
		
	}
	
	@Override
	public void postOrderTraversal() {
		postOrderTraversal(root);
		
	}
	
	private void postOrderTraversal(BSTNode<T> node) {
		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.println(node.value);
		}
		
	}
}
