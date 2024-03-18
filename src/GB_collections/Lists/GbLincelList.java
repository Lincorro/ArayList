package GB_collections.Lists;

import GB_collections.GbList;

import java.util.Iterator;


public class GbLincelList<E> implements GbList<E> {
    private Node<E>head;
    private Node<E>tail;

    int size = 0;

    public GbLincelList(){
        tail = new Node<>(null, head,null);
        head = new Node<>(null,null ,tail);
    }

    @Override
    public void add(E value) {
        Node<E> newNode = tail;
        newNode.setValue(value);
        tail = new Node<>(null,newNode,null);
        newNode.setNext(tail);
        size++;
    }

    @Override
    public E get(int index) {
            Node<E> temp = head.getNext();
            for (int i = 0; i < index; i++) {
               temp = getNext(temp);
            }//используя метод getNext мы перебираем наш список до заданного элемента
            return temp.getValue();
    }
    private Node<E> getNext(Node<E> value){
        return value.getNext();
    }
    private Node<E> getPrev(Node<E> value){
        return value.getPrev();
    }

    @Override
    public void removeByIndex(int index) {
        Node<E> temp = head.getNext();
        for (int i = 0; i < index; i++) {
            temp = getNext(temp);
        }//используя метод getNext мы перебираем наш список до заданного элемента
        getNext(temp).setPrev(temp.getPrev());
        getPrev(temp).setNext(temp.getNext());
       }

    @Override
    public boolean equals(Object obj) {
        try {
            if (this == (E) obj) return true;
            else return false;
        }catch (ClassCastException e){ System.out.println(e);}
        return false;
    }

    @Override
    public void remove(E value) {
        Node<E> temp = head.getNext();
        for (int i = 0; i < size; i++) {
            temp = getNext(temp);
            if (value.equals(temp)){
                getNext(temp).setPrev(temp.getPrev());
                getPrev(temp).setNext(temp.getNext());
                return;
            }
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void add(int index, E value) {
        Node<E> temp = head.getNext();
        for (int i = 0; i < index; i++) {
            temp = getNext(temp);
        }
        Node<E> newNode = new Node<>(value,temp.getPrev(),temp.getNext());
        temp.getNext().setPrev(newNode);
        temp.getPrev().setNext(newNode);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
    public void prinList(GbLincelList<E> list){
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }
    }
}
