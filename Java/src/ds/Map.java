package ds;

public class Map<E,G> implements MapADT<E,G> {
	private int capacity;
	private Array<LinkedList<Entry>> data;
	
	public Map(int capacity) {
		this.capacity = capacity;
		data = new Array<LinkedList<Entry>>();
		for (int i = 0; i < capacity; i++) {
			data.add(new LinkedList<Entry>());
		}
	}

	public Map() {
		this.capacity = 100; //default size
		data = new Array<LinkedList<Entry>>();
		for (int i = 0; i < capacity; i++) {
			data.add(new LinkedList<Entry>());
		}
	}

	public void put(E key, G value) {
		int index = hash(key);
		LinkedList<Entry> entries = data.get(index);
		for (Entry entry : entries) {
			if (entry.key.equals(key)) {
				entry.value = value; // Update existing key
				return;
			}
		}
		entries.addLast(new Entry(key, value)); // Add new key-value pair
	}

	public G get(E key) throws Exception {
		int index = hash(key);
		LinkedList<Entry> entries = data.get(index);
		for (Entry entry : entries) {
			if (entry.key.equals(key)) {
				return entry.value;
			}
		}
		throw new Exception("Key not found: " + key);
	}
	

	private int hash(Object key) {
		return Math.abs(key.hashCode()) % capacity;
	}

	public boolean containsKey(E key) {
		int index = hash(key);
		LinkedList<Entry> entries = data.get(index);
		for (Entry entry : entries) {
			if (entry.key.equals(key)) {
				return true;
			}
		}
		return false;
	}

	public void remove(E key) throws Exception {
		int index = hash(key);
		LinkedList<Entry> entries = data.get(index);
		int indexToRemove = -1;
		for (Entry entry : entries) {
			indexToRemove++;
			if (entry.key.equals(key)) {
				entries.removeAt(indexToRemove);
				return;
			}
		}
		throw new Exception("Key not found: " + key);
	}

	public int size() {
		int count = 0;
		for (LinkedList<Entry> entries : data) {
			count += entries.size();
		}
		return count;
	}

	private class Entry {
		E key;
		G value;

		Entry(E key, G value) {
			this.key = key;
			this.value = value;
		}
	}

}
