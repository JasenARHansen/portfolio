package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_12_Hash_Table;

import java.util.ArrayList;

@SuppressWarnings("SpellCheckingInspection")
public class Hasher<K, V> {
    private final ArrayList<LinkedListNode<K, V>> arr;

    public Hasher(int capacity) {
        /* Create list of linked lists. */
        arr = new ArrayList<>();
        arr.ensureCapacity(capacity);
        for (int i = 0; i < capacity; i++) {
            arr.add(null);
        }
    }

    public V get(K key) {
        /* Get value for key. */
        if (key == null) return null;
        LinkedListNode<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }

    public void printTable() {
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i) == null ? "" : arr.get(i).printForward();
            System.out.println(i + ": " + s);
        }
    }

    public V put(K key, V value) {
        /* Insert key and value into hash table. */
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node != null) {
            V oldValue = node.value;
            node.value = value; // just update the value.
            return oldValue;
        }
        node = new LinkedListNode<>(key, value);
        int index = getIndexForKey(key);
        if (arr.get(index) != null) {
            node.next = arr.get(index);
            node.next.prev = node;
        }
        arr.set(index, node);
        return null;
    }

    private LinkedListNode<K, V> getNodeForKey(K key) {
        /* Get linked list node associated with a given key. */
        int index = getIndexForKey(key);
        LinkedListNode<K, V> current = arr.get(index);
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public int getIndexForKey(K key) {
        /* Really stupid function to map a key to an index. */
        return Math.abs(key.hashCode() % arr.size());
    }

    public V remove(K key) {
        /* Remove node for key. */
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node == null) {
            return null;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            /* Removing head - update. */
            int hashKey = getIndexForKey(key);
            arr.set(hashKey, node.next);
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        return node.value;
    }

    private static class LinkedListNode<K, V> {
        public final K key;
        public LinkedListNode<K, V> next;
        public LinkedListNode<K, V> prev;
        public V value;

        public LinkedListNode(K k, V v) {
            key = k;
            value = v;
        }

        public String printForward() {
            String data = "(" + key + "," + value + ")";
            if (next != null) {
                return data + "->" + next.printForward();
            } else {
                return data;
            }
        }
    }
}
