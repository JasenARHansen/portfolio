package Java.code.ctci.source.ctciLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@SuppressWarnings("unused")
public class HashMapList<T, E> {
    private final HashMap<T, ArrayList<E>> map = new HashMap<>();

    public boolean containsKey(T key) {
        /* Check if hash map list contains key. */
        return map.containsKey(key);
    }

    public boolean containsKeyValue(T key, E value) {
        /* Check if list at key contains value. */
        ArrayList<E> list = get(key);
        if (list == null) return false;
        return list.contains(value);
    }

    public ArrayList<E> get(T key) {
        /* Get list of items at key. */
        return map.get(key);
    }

    public Set<T> keySet() {
        /* Get the list of keys. */
        return map.keySet();
    }

    public void put(T key, ArrayList<E> items) {
        /* Insert list of items at key. */
        map.put(key, items);
    }

    /* Insert item into list at key. */
    public void put(T key, E item) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(item);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
