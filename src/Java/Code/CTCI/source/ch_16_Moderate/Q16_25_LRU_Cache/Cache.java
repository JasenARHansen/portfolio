package Java.code.ctci.source.ch_16_Moderate.q16_25_LRU_Cache;

import java.util.HashMap;

@SuppressWarnings("UnusedReturnValue")
public class Cache {
  private final int maxCacheSize;
  private final HashMap<Integer, LinkedListNode> map = new HashMap<>();
  public LinkedListNode listTail = null;
  private LinkedListNode listHead = null;

  public Cache(int maxSize) {
    maxCacheSize = maxSize;
  }

  public String getValue(int key) {
    /* Get value for key and mark as most recently used. */
    LinkedListNode item = map.get(key);
    if (item == null) {
      return null;
    }
    /* Move to front of list to mark as most recently used. */
    if (item != listHead) {
      removeFromLinkedList(item);
      insertAtFrontOfLinkedList(item);
    }
    return item.value;
  }

  private void removeFromLinkedList(LinkedListNode node) {
    /* Remove node from linked list. */
    if (node == null) {
      return;
    }
    if (node.prev != null) {
      node.prev.next = node.next;
    }
    if (node.next != null) {
      node.next.prev = node.prev;
    }
    if (node == listTail) {
      listTail = node.prev;
    }
    if (node == listHead) {
      listHead = node.next;
    }
  }

  private void insertAtFrontOfLinkedList(LinkedListNode node) {
    /* Insert node at front of linked list. */
    if (listHead == null) {
      listHead = node;
      listTail = node;
    } else {
      listHead.prev = node;
      node.next = listHead;
      listHead = node;
      listHead.prev = null;
    }
  }

  public void setKeyValue(int key, String value) {
    /* Put key, value pair in cache. Removes old value for key if
    necessary. Inserts pair into linked list and hash table. */
    /* Remove if already there. */
    removeKey(key);
    /* If full, remove least recently used item from cache. */
    if (map.size() >= maxCacheSize && listTail != null) {
      removeKey(listTail.key);
    }
    /* Insert new node. */
    LinkedListNode node = new LinkedListNode(key, value);
    insertAtFrontOfLinkedList(node);
    map.put(key, node);
  }

  public boolean removeKey(int key) {
    /* Remove key, value pair from cache, deleting from hash table
    and linked list. */
    LinkedListNode node = map.get(key);
    removeFromLinkedList(node);
    map.remove(key);
    return true;
  }

  public String getCacheAsString() {
    if (listHead == null) return "";
    return listHead.printForward();
  }

  @SuppressWarnings("InnerClassMayBeStatic")
  private class LinkedListNode {
    public final int key;
    public final String value;
    private LinkedListNode next;
    private LinkedListNode prev;

    public LinkedListNode(int k, String v) {
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
