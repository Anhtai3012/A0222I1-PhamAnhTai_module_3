package ss10_list_array.bai_tap.linked_list;

public class MyLinkedList<E> {
    Node firstNode;
    Node lastNode;
    int numNode;

    public MyLinkedList() {
        this.numNode = 0;
        this.firstNode = null;
        this.lastNode = null;
    }

    MyLinkedList(Node node) {
        this.numNode = 1;
        this.firstNode = node;
        this.lastNode = node;
    }

    public void addLast(E element) {
        Node node = new Node(element);
        if (this.firstNode == null) {
            this.firstNode = node;
            this.lastNode = this.firstNode;
        } else {
            this.lastNode.next = node;
            this.lastNode = node;
        }
        this.numNode++;
    }

    public void addFirst(E element) {
        Node node = new Node(element);
        if (this.firstNode == null) {
            this.firstNode = node;
            this.lastNode = this.firstNode;
        } else {
            node.next = this.firstNode;
            this.firstNode = node;
        }
        this.numNode++;
    }

    public void add(int idx, E element) {
        if (idx <= 0) {
            addFirst(element);
            return;
        }
        if (idx > this.numNode - 1) {
            addLast(element);
            return;
        }

        Node curr = this.firstNode;
        idx--;
        while (idx-- > 0) {
            curr = curr.next;
        }

        if (curr == null) {
            addLast(element);
        } else {
            Node node = new Node(element);
            Node temp = curr.next;
            curr.next = node;
            node.next = temp;
        }
        numNode++;
    }

    public void removeElement(E element) {
        if (this.firstNode == null) return;
        Node fakeHead = new Node(new Object(), this.firstNode);
        Node prev = fakeHead;
        Node curr = prev.next;
        while (curr != null) {
            if (curr.data == element) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
            if (curr != null) this.lastNode = curr;
        }

        this.firstNode = fakeHead.next;
    }

    public void removeByIndex(int index) {
        if (this.firstNode == null) return;
        if (index > this.numNode - 1 || index < 0) return;

        Node fakeHead = new Node(new Object(), this.firstNode);
        Node prev = fakeHead;
        Node curr = prev.next;

        while (index-- > 0) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;

        this.firstNode = fakeHead.next;
    }

    public int indexOf(E element) {
        if (this.firstNode == null) return 0;
        int result = 0;
        Node head = this.firstNode;
        while (head != null) {
            if (head.data == element) break;
            result++;
            head = head.next;
        }
        return result;
    }

    public void showData() {
        Node head = this.firstNode;
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
