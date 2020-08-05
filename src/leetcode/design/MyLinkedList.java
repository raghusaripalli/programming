package leetcode.design;

class MyLinkedList {

    class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= 0 && index < size) {
            if (index < size / 2) {
                Node temp = head;
                while (index-- >= 0) {
                    temp = temp.next;
                }
                return temp.val;
            } else {
                Node temp = tail;
                while (index-- >= 0) {
                    temp = temp.prev;
                }
                return temp.val;
            }
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            if (tail == null)
                tail = head;
        } else {
            Node temp = new Node(val);
            temp = head.prev;
            temp.next = head;
            head = temp;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (tail == null) {
            tail = new Node(val);
            if (head == null)
                head = tail;
        } else {
            Node temp = new Node(val);
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index >= 0 && index < size) {
            if (index == 0) {
                addAtHead(val);
            } else if (index == size - 1) {
                addAtTail(val);
            } else {
                Node temp = new Node(val);
                Node cur;
                Node pre;
                if (index < size / 2) {
                    cur = head;
                    pre = null;
                    for (int i = 0; i < index; i++) {
                        pre = cur;
                        cur = cur.next;
                    }
                } else {
                    pre = tail;
                    cur = null;
                    for (int i = 0; i < size - index + 1; i++) {
                        cur = pre;
                        pre = pre.prev;
                    }
                }
                pre.next = temp;
                temp.prev = pre;
                cur.prev = temp;
                temp.next = cur;
                size++;
            }
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            if (index == 0) {
                head = head.next;
                if (head == null) {
                    tail = null;
                } else {
                    head.prev = null;
                }
            } else if (index == size - 1) {
                tail = tail.prev;
                if (tail == null) {
                    head = null;
                } else {
                    tail.next = null;
                }
            } else {
                if (index < size / 2) {
                    Node cur = head;
                    Node pre = null;
                    for (int i = 0; i < index; i++) {
                        pre = cur;
                        cur = cur.next;
                    }
                    pre.next = cur.next;
                    cur.next.prev = pre;
                } else {
                    Node pre = tail;
                    Node cur = null;
                    for (int i = 0; i < size - index; i++) {
                        cur = pre;
                        pre = pre.prev;
                    }
                    pre.next = cur.next;
                    cur.next.prev = pre;
                }
            }
            size--;
        }
    }


    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll = new MyLinkedList();
        ll.deleteAtIndex(1); // no op
        ll.get(0); // no op
        ll.addAtTail(1); // 1 -> null
        ll.visualize();
        ll.deleteAtIndex(1); // no op
        ll.visualize(); // 1-> null
        ll.deleteAtIndex(0); // null
        ll.visualize();
        ll.addAtHead(2); // 2
        ll.visualize();
        ll.addAtTail(1); // 1
        System.out.println(ll.get(0)); // 2
        System.out.println(ll.get(1)); // 1
        System.out.println(ll.get(2)); // -1
        System.out.println(ll.get(-1)); // -1
        ll.visualize();
        ll.deleteAtIndex(1); // 2 -> null
        ll.visualize();
        ll.deleteAtIndex(0); // null
        ll.visualize();
        ll.addAtHead(1); // 1 -> null
        ll.visualize();
        ll.addAtTail(3); // 1 -> 3 -> null
        ll.visualize();
        ll.addAtIndex(1, 2); // 1 -> 2 -> 3 -> null
        ll.visualize();
        System.out.println(ll.get(1) + "\n"); // 2
        ll.deleteAtIndex(1); // 1 -> 2 -> null
        ll.visualize();
        System.out.println(ll.get(1) + "\n"); // 3
    }

    private void visualize() {
        System.out.println("Size: " + size);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");

        temp = tail;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.prev;
        }
        System.out.println("null\n");
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
