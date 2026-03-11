package ds;

public class BSTNode<T extends Comparable<T>> implements Comparable<BSTNode<T>> {

	T value;
	BSTNode<T> left;
	BSTNode<T> right;
	
	BSTNode(T value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	@Override
	public int compareTo(BSTNode<T> other) {
		return this.value.compareTo(other.value);
	}
}
