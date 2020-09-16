package datastructures;

public class SymbolTable<Key extends Comparable, Value> {

    SymbolTable() {

    }

    void put(Key key, Value value) {

    }

    Value get(Key key) {
        return null;
    }

    void delete(Key key) {
        put(key, null);
    }

    boolean contains(Key key) {
        return get(key) != null;
    }

    boolean isEmpty() {
        return true;
    }

    int size() {
        return 0;
    }

    Iterable<Key> keys() {
        return null;
    }
}
