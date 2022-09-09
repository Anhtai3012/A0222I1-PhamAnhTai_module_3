package ss11_slack_queue.thuc_hanh.queue_linked_list;

public class Solution {
    public static void main(String[] args) {
        QueueLinkedList<Integer> queueLinkedList = new QueueLinkedList<>();
        queueLinkedList.enqueue(5);
        queueLinkedList.enqueue(2);
        queueLinkedList.enqueue(4);
        queueLinkedList.enqueue(3);
        queueLinkedList.enqueue(8);
        queueLinkedList.enqueue(12);
        queueLinkedList.dequeue();
        while (queueLinkedList.next() != null) {
            System.out.printf("%d ", queueLinkedList.dequeue().value);
        }
    }
}
