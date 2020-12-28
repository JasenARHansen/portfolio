package classesInstance;

public class CustomLinkedList<T extends Comparable<T>> {

  private NodeList<T> head;
  private NodeList<T> tail;
  private int size;

  public CustomLinkedList() {
    this.size = 0;
  }

  public void empty() {
    while (this.size != 0) {
      removeIndex(0);
    }
  }

  public NodeList<T> getFirst() {
    return this.head;
  }

  public NodeList<T> getIndex(int index) {
    NodeList<T> pointerNode = this.head;
    for (int i = 0; i < index; i++) {
      pointerNode = pointerNode.getNext();
    }
    return pointerNode;
  }

  public NodeList<T> getLast() {
    return this.tail;
  }

  public int getSize() {
    return this.size;
  }

  private void setSize(int size) {
    this.size = size;
  }

  public void insert(CustomLinkedList<T> inputList) {
    for (int i = 0; i < inputList.getSize(); i++) {
      this.insert(inputList.getIndex(i).getData());
    }
  }

  public void insert(T data) {
    insertIndex(data, this.size);
  }

  public void insertIndex(T data, int index) {
    NodeList<T> node = new NodeList<>(data);

    // Base Case, first entry
    if (this.size == 0) {
      this.head = node;
      this.tail = node;
    }
    // Insert at front
    else if (index == 0) {
      // B add A
      // A.setNext(this.head);
      // this.head.setPrevious(A)
      // this.head = A;
      node.setNext(this.head);
      this.head.setPrevious(node);
      this.head = node;
    }
    // Insert at end
    else if (index >= (this.size)) {
      // B add C
      // C.setPrevious(this.tail);
      // this.tail.setNext(C)
      // this.tail = C;
      node.setPrevious(this.tail);
      this.tail.setNext(node);
      this.tail = node;
    }
    // Insert in middle
    else {
      // Find the index
      // A <-> C add B
      // B.setPrevious(A)
      // B.setNext(A.getNext())
      // A.getNext().setPrevious(B)
      // A.setNext(B)
      NodeList<T> pointerNode = this.head;
      for (int i = 0; i < index - 1; i++) {
        pointerNode = pointerNode.getNext();
      }
      node.setPrevious(pointerNode);
      node.setNext(pointerNode.getNext());
      pointerNode.getNext().setPrevious(node);
      pointerNode.setNext(node);
    }
    this.size++;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public void printList() {
    System.out.format("List: '%s'\n", toString());
  }

  // This does not work as expected when the data type is integer...
  public NodeList<T> remove(T data) {
    NodeList<T> pointerNode = this.head;
    for (int index = 0; index < this.size; index++) {
      if (pointerNode.getData().compareTo(data) == 0) {
        return removeIndex(index);
      }
      pointerNode = pointerNode.getNext();
    }
    return null;
  }

  public NodeList<T> removeIndex(int index) {
    NodeList<T> pointerNode;
    // Delete at front
    if (index == 0) {
      // A <-> B remove A
      // B.setPrevious(null);
      // this.head = B;
      // A.setNext(null);
      // A.setPrevious(null);
      pointerNode = this.head;
      if (pointerNode.getNext() != null) {
        pointerNode.getNext().setPrevious(null);
        this.head = pointerNode.getNext();
      }
      pointerNode.setNext(null);
      pointerNode.setPrevious(null);
    }
    // Delete at end
    else if (index >= (this.size - 1)) {
      // A <-> B remove B
      // A.setNext(null);
      // this.tail = A;
      // B.setNext(null);
      // B.setPrevious(null);
      pointerNode = this.tail;
      if (pointerNode.getPrevious() != null) {
        pointerNode.getPrevious().setNext(null);
      }
      this.tail = pointerNode.getPrevious();
      pointerNode.setNext(null);
      pointerNode.setPrevious(null);
    }
    // Delete in middle
    else {
      // Find the index
      // A <-> B <-> C remove B
      // C.setPrevious(A)
      // A.setNext(C)
      // B.setNext(null);
      // B.setPrevious(null);
      pointerNode = this.head;
      for (int i = 0; i < index; i++) {
        pointerNode = pointerNode.getNext();
      }
      pointerNode.getPrevious().setNext(pointerNode.getNext());
      pointerNode.getNext().setPrevious(pointerNode.getPrevious());
      pointerNode.setNext(null);
      pointerNode.setPrevious(null);
    }
    this.size--;
    if (this.size == 0) {
      this.head = null;
      this.tail = null;
    }
    return pointerNode;
  }

  private void setHead(NodeList<T> node) {
    this.head = node;
  }

  private void setTail(NodeList<T> node) {
    this.tail = node;
  }

  public CustomLinkedList<T> sublist(CustomLinkedList<T> inputList, int startIndex) {
    // This is an unsafe method. If the first or the last node are changed
    // the reference between multiple lists will not update
    CustomLinkedList<T> returnList = new CustomLinkedList<>();
    returnList.setHead(inputList.getIndex(startIndex));
    returnList.setTail(this.tail);
    returnList.setSize(this.size - startIndex);
    return returnList;
  }

  @Override
  public String toString() {
    if (this.head == null) {
      return "null";
    }

    StringBuilder stringBuilder = new StringBuilder();
    NodeList<T> pointerNode = this.head;
    stringBuilder.append(pointerNode.toString());

    while (pointerNode.getNext() != null) {
      pointerNode = pointerNode.getNext();
      stringBuilder.append(" <-> ");
      stringBuilder.append(pointerNode.toString());
    }
    return stringBuilder.toString();
  }
}
