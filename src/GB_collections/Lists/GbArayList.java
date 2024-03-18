package GB_collections.Lists;

import GB_collections.GbList;
import GB_collections.Lists.util.ArrayIterator;

import java.util.Iterator;

public class GbArayList<Q> implements GbList<Q> {
    private Q[] values;
    private int size;//сколько элементов в Листе
    private int capasity;//сколько места всего
@SuppressWarnings("unchecked")
    public GbArayList() {
        this.size=0;
        this.capasity=10;
        try {
            this.values=(Q[])new Object[capasity];
        }catch (ClassCastException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void add(Q value) {
    if (size == capasity)addCapasity();
    values[size++]=value;
    }

    private void addCapasity(){
    capasity +=10;
        try {
            Q[]array = (Q[])new Object[capasity];
            System.arraycopy(values, 0, array, 0, values.length);
            this.values=array;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    @Override
    public Q get(int index) {
        return values[index];
    }

//    @Override
//    public void removeByIndex(int index) {
//    Q[] temp = (Q[])(new Object[capasity]);
//    System.arraycopy(values, 0, temp,0,index);
//    int amountElementsAfterIndex = values.length - index - 1;
//    System.arraycopy(values,++index, temp, index, amountElementsAfterIndex);
//    size--;
//    }
    @Override
    @SuppressWarnings("unchecked")
    public void removeByIndex(int index) {
        try {
            Q[] temp = values;
            values = (Q[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int amountElementsAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, amountElementsAfterIndex);
        } catch (ClassCastException e) {
            throw new RuntimeException(e);
        }


    }



    @Override
    public void remove(Q value) {
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(value)){
                removeByIndex(i);
                return;
            }
        }
        throw new RuntimeException("Element not found");
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void add(int index, Q value) {
    }

    @Override
    public Iterator<Q> iterator() {
        return new ArrayIterator(values);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        int i =0;
        while (values[i] != null) {
            builder.append(values[i]).append(", ");
            i++;
        }
        if (builder.length() == 1)
            return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
