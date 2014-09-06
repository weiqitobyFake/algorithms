package algorithms;

import java.util.*;

class MyEntry<K, V>{
	private K key;
	private V value;
	
	public MyEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return this.key;
	}
	
	public V getValue() {
		return this.value;
	}
	
	public void setValue(V v) {
		this.value = v;
	}
	
	public int hashCode() {
		return this.key.hashCode();
	}
	
	public boolean keyEquals(MyEntry<K, V> m) {
		return this.key == m.getKey();
	}
	
	public boolean equals(MyEntry<K, V> m) {
		return key == m.getKey()&&value == m.getValue();
	}
	
	public String toString() {
		return key+"="+value;
	}
}

public class MyHashMap<K, V> {
	private static final int MaxSize = 128;
	private int size;
	
	// because Java does not support generic array
	// So I use ArrayList to do what array does
	// with linked list(separate chaining) to deal with collision
	private ArrayList<LinkedList<MyEntry<K, V>>> table;
	
	public MyHashMap() {
		table = new ArrayList<LinkedList<MyEntry<K, V>>>();
		for (int i=0; i<MaxSize; i++)
			table.add(null);
		size = 0;
	}
	
	
	// with hashFunction, HashMap can find the
	// right place for the new Entry
	private int hashFunction(MyEntry<K, V> m) {
		return m.hashCode() % MaxSize;
	}
	
	// check whether the key is already in the HashMap
	protected boolean keyExists(MyEntry<K, V> m) {
		// Get the hash value of m
		int hashcode = hashFunction(m);
		// The Hash Value Maps key to the right place
		// to find the linked list this Entry should 
		// belongs to
		
		// Check whether this entry is in the map
		// This can be done in constant time
		LinkedList<MyEntry<K, V>> list = table.get(hashcode);
		if (list == null)
			return false;
		for (MyEntry<K, V> entry : list) {
			if (entry.keyEquals(m))
				return true;
		} 
		
		return false;
	}
	
	/***
	 * 
	 * @description this function works for the getValue(K key) function
	 * @exception   NoSuchElementExceltion will thrown if no such key
	 * @return      MyEntry<K, V> myEntryObject;
	 */
	public MyEntry<K, V> getEntry(K key) {
		MyEntry<K, V> temp = new MyEntry<K,V>(key, null);
		
		if (!keyExists(temp))
			throw new NoSuchElementException();
		
		LinkedList<MyEntry<K, V>> list = table.get(hashFunction(temp));
		for (MyEntry<K, V> entry : list) {
			if (entry.keyEquals(temp))
				return entry;	
		}
		return null;
	}
	
	/***
	 * 
	 * @description This function is used to get value of 
	 *              the key which here is the input parameter.
	 * @exception   NoSuchElementExceltion will thrown if no such key
	 * @return      V value;
	 */
	public V getValue(K key) {
		MyEntry<K, V> m = getEntry(key);
		if (m != null)
			return m.getValue();
	}
	
	/***
	 * 
	 * @description Required by Durga. 
	 * @return      boolean b;
	 */
	public boolean add(K key, V value) {
		MyEntry<K, V> m = new MyEntry<K, V>(key, value);
		
		// key is already in the map
		if (keyExists(m)) {
			MyEntry<K, V> entry = getEntry(m.getKey());
			entry.setValue(m.getValue());
			return true;
		}else {
			// key is not in the map
			size++;
			LinkedList<MyEntry<K, V>> list = table.get(hashFunction(m));

			// list is not null
			if (list != null) {
				list.add(0, m);
			}else {
				list = new LinkedList<MyEntry<K, V>>();
				list.add(m);
				for (int i=0; i<table.size(); i++) {
					if (i == hashFunction(m))
						table.set(i, list);
				}
			}
			return true;
		}
	}
	
	/***
	 * 
	 * @description Required by Durga.
	 * @return      boolean b.
	 */
	public boolean delete(K key) {
		V value = getValue(key);
		MyEntry<K, V> t = new MyEntry<K,V>(key, value);
		
		if (!keyExists(t))
			throw new NoSuchElementException();
		
		size--;
		LinkedList<MyEntry<K, V>> list = table.get(hashFunction(t));
		for (int i=0; i<list.size(); i++) {
			MyEntry<K, V> curr = list.get(i);
			if (curr.getKey().equals(key)) {
				list.remove(i);
				if (list.size() == 0)
					list = null;
				break;
			}
		}
		
		return true;
	}
	
	public int size() {
		return this.size;
	}
	
	public String toString() {
		return table + "";
	}
	
	public static void main(String[] args) {
		
	}
}
