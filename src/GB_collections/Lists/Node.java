package GB_collections.Lists;

public class Node<E> {
    transient E value;
    transient Node<E> next;
    transient Node<E> prev;


    protected Node(E value, Node<E> prev, Node<E> next) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    protected E getValue() {
        return value;
    }

    protected void setValue(E value) {
        this.value = value;
    }

    protected Node<E> getNext() {
        return next;
    }

    protected void setNext(Node<E> next) {
        this.next = next;
    }

    protected Node<E> getPrev() {
        return prev;
    }

    protected void setPrev(Node<E> prev) {
        this.prev = prev;
    }
}
