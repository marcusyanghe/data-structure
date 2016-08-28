package lab8;
import java.util.Set;
import java.util.Iterator;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
	private Node root;
	private int size;
	private class Node {
		Node left;
		Node right;
		V value;
		K key;
		public Node(K k, V v) {
			key = k;
			value = v;
			size++;
		}
	}

	//initiate a blank tree
	public BSTMap() {
	}

	/** Removes all of the mappings from this map. */
    public void clear() {
    	root = null;
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key) {
    	return get(key) != null;
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key. 
     */
    public V get(K key) {
    	return get(root, key);
    }

    private V get(Node x,K key) {
    	if(x == null) {
    		return null;
    	}
    	int cmp = key.compareTo(x.key);
    	if(cmp ==0) {
    		return x.value;
    	} else if(cmp > 0) {
    		x = x.right;
    		return get(x, key);
    	} else {
    		x = x.left;
    		return get(x,key);
    	}

    }
    /* Returns the number of key-value mappings in this map. */
    public int size() {
    	return this.size;
    }

    /* Associates the specified value with the specified key in this map. */
    public void put(K key, V value) {
    	if(key == null) {
    		throw new UnsupportedOperationException("null key pointer");
    	} 
    	root = put(root, key, value);
    }

    private Node put(Node x, K key, V value) {

    	if(x == null) {
    		return new Node(key,value);
    	} 

    	int cmp = key.compareTo(x.key);
    	if(cmp > 0) {
    		x.right = put(x.right,key,value);
    		return x;
    		      
    	} else if(cmp < 0) {
    		x.left = put(x.left,key,value); 
    		return x;
    	} else {
    		x.value = value;
    		return x; 
    	}
    }


    public void printInOrder() {
    	printInOrder2(root);
    }

    // 
    private void printInOrder(Node x) {
    	if(x != null) {
	    	printInOrder(x.left);
	    	System.out.println(x.key+" : "+ x.value);
	    	printInOrder(x.right);
    	}
    }

    //trasvese by layer
    private void printInOrder2(Node x) {
    	if(x != null) {
    		System.out.println(x.key+" : "+ x.value);

    		printInOrder(x.left);
	    	printInOrder(x.right);

    	}
    }




    public Iterator iterator() {
    	throw new UnsupportedOperationException();
    }                       //iterator private or public?怎么写????????????????
    						// comparable 怎么写？？？？





    /* Returns a Set view of the keys contained in this map. */
    public Set<K> keySet() {
    	throw new UnsupportedOperationException();
    }   


    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an 
     * UnsupportedOperationException. */
    public V remove(K key) {
    	throw new UnsupportedOperationException();

    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    public V remove(K key, V value) {
    	throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
    	BSTMap map = new BSTMap<Integer, String>();
    	map.put(4,"2 to put");
    	map.put(3,"1 to put");
    	map.put(1,"3 to put");
    	map.put(6,"4 to put");
    	map.put(7,"5 to put");
    	map.put(5,"6 to put");
    	map.put(2,"7 to put");
    	map.put(0,"8 to put");
    	map.put(8,"9 to put");

    	map.printInOrder();


    }

}