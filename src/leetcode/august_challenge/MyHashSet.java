package leetcode.august_challenge;

public class MyHashSet {

    class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    private Node[] arr;
    private static final int size = 10011;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        arr = new Node[size];
    }

    public void add(int key) {
        int i = myHash(key);
        if (arr[i] == null) {
            arr[i] = new Node(key);
        } else {
            Node cur = arr[i];
            while (cur.next != null && cur.key != key) {
                cur = cur.next;
            }
            if (cur.key != key) {
                cur.next = new Node(key);
            }
        }
    }

    public void remove(int key) {
        int i = myHash(key);
        if (arr[i] == null) {
            return;
        } else if (arr[i].key == key) {
            arr[i] = arr[i].next;
        } else {
            Node cur = arr[i], pre = null;
            while (cur.next != null && cur.key != key) {
                pre = cur;
                cur = cur.next;
            }
            if (pre != null && cur.key == key) {
                pre.next = cur.next;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int i = myHash(key);
        if (arr != null) {
            Node cur = arr[i];
            while (cur != null) {
                if (cur.key == key) {
                    return true;
                }
                cur = cur.next;
            }
        }
        return false;
    }

    private int myHash(int key) {
        return key % size;
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));
    }
}
