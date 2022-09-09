package ss10_list_array.thuc_hanh.linked_list;

public class NewLinkedList {
    private Object head;
    private int numberOfNode;

    public NewLinkedList(Object data) {
        head = new Node(data);
    }

    public void addData(int index, Object data) {
        Node temp = (Node) head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numberOfNode++;
    }

    public void addFirstData(Object data) {
        Node temp = (Node) head;
        head = new Node(data);
        ((Node) head).next = temp;
        numberOfNode++;
    }

    public void getData(int index) {
        Node temp = (Node) head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        System.out.printf("data in index %d : %s",index,temp.data);
    }

    public void printList() {
        Node temp = (Node) head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
