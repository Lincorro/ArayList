package GB_collections;

public interface GbList<T> extends Iterable<T>{
    void add(T value);
    T get(int index);
    void removeByIndex(int index);
    void remove(T value);
    int getSize();
    void add(int index, T value);

}
