package ds;

public interface MapADT<E,G> {
	
	/** Associates the specified value with the specified key in this map. If the map previously contained a mapping for the key, the old value is replaced by the specified value.
	 * If the map does not already contain a mapping for the key, a new key-value pair is added to the map.
	 * @param key
	 * @param value
	 */
	void put(E key, G value);
	
	/** Returns the value to which the specified key is mapped, or throws an exception if this map contains no mapping for the key.
	 * @param key
	 * @return the value associated with the specified key
	 * @throws Exception if the map contains no mapping for the key
	 */
	G get(E key) throws Exception;
	
	/** Returns true if this map contains a mapping for the specified key.
	 * @param key
	 * @return true if this map contains a mapping for the specified key, false otherwise
	 */
	boolean containsKey(E key);
	
	/** Removes the mapping for the specified key from this map if present.
	 * @param key
	 * @throws Exception if the map contains no mapping for the key
	 */
	void remove(E key) throws Exception;
	
	/** Returns the number of key-value mappings in this map. */
	int size();
}
