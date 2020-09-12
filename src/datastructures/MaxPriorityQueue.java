package datastructures;

public class MaxPriorityQueue<Key extends Comparable<Key>> {
    private final Key[] arr;
    private int idx;

    public MaxPriorityQueue(int capacity) {
        idx = 0;
        arr = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return idx == 0;
    }

    public Key getMax() {
        return arr[1];
    }

    public void insert(Key key) {
        arr[++idx] = key;
        swim(idx);
    }

    public Key delete() {
        Key max = arr[1];
        exchange(1, idx--);
        sink();
        arr[idx + 1] = null;
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k, k / 2);
            k = k / 2;
        }
    }

    private void sink() {
        int k = 1;
        while (2 * k <= idx) {
            int j = 2 * k;
            if (j < idx && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    private void exchange(int a, int b) {
        Key temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private boolean less(int key1, int key2) {
        return arr[key1].compareTo(arr[key2]) < 0;
    }

    public static void main(String[] args) {
        MaxPriorityQueue<Integer> heap = new MaxPriorityQueue<>(3);
        heap.insert(1);
        System.out.println(heap.getMax());
        heap.insert(2);
        System.out.println(heap.getMax());
        heap.insert(3);
        System.out.println(heap.getMax());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
    }
}
