package datastructures;

public class SymbolTable<Key extends Comparable<Key>, Value> {
    private BST<Key, Value> bst;

    SymbolTable() {
        bst = new BST<>();
    }

    public void put(Key key, Value value) {
        bst.put(key, value);
    }

    public Value get(Key key) {
        return bst.get(key);
    }

    public void delete(Key key) {
        put(key, null);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return bst.size();
    }

    public Iterable<Key> keys() {
        return bst.keys();
    }
}
