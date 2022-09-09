package ss10_list_array.bai_tap.linked_list;

public class Node {
    public Object data;
    public Node next;

    Node(Object data) {
        this.data = data;
    }

    Node(Object data, Node tail) {
        this.data = data;
        this.next = tail;
    }


    public Object getData() {
        return this.data;
    }
}
