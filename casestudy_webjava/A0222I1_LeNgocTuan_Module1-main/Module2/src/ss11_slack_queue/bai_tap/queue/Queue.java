package ss11_slack_queue.bai_tap.queue;

public class Queue {
    Node front;
    Node rear;

    public Queue() {
    }

    public Queue(Node node) {
        this.front = node;
        this.rear = node;
        front.next = rear;
    }

    public void enQueue(int value) {
        Node tempe = new Node(value);
        if (front == null) {
            front = tempe;
        } else {
            rear.next = tempe;
        }
        rear = tempe;
        rear.next = front;
    }

    public void deQueue() {
        if (front == null) return;
        if (front == rear) {
            front = rear = null;
        } else {
            Node tempe = front.next;
            rear.next = tempe;
            front = tempe;
        }
    }

    public void displayQueue() {
        Node head = front;
        do {
            System.out.print(head.value);
            head = head.next;
            System.out.print("->");
        } while (head != front);
        System.out.println("\n");
    }

}
