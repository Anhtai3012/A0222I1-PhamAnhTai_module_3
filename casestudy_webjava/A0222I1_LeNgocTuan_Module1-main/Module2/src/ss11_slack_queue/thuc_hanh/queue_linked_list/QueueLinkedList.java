package ss11_slack_queue.thuc_hanh.queue_linked_list;

import java.util.LinkedList;

public class QueueLinkedList<E> {
    private  Node head;
    private Node tail;
    public LinkedList<E> myQueue;

    public QueueLinkedList() {
        this.head = null;
        this.tail = null;
        myQueue = new LinkedList<>();
    }

    public void enqueue(int value) {
        Node temp = new Node(value);
        if (head != null) {
            temp.next = head;
        }
        head = temp;
    }
    public Node next(){
        return this.head;
    }

    public Node dequeue() {
        if (this.head == null) return null;
        Node temp = this.head;
        this.head = this.head.next;
        if (this.head == null)
            this.tail = null;
        return temp;
    }
    public boolean isEmpty(){
        return myQueue.size() == 0;
    }
}

