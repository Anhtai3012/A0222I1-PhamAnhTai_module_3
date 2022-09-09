package ss11_slack_queue.bai_tap.queue;

public class Solution {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(14);
        queue.enQueue(22);
        queue.enQueue(43);
        queue.displayQueue();
        queue.deQueue();
        queue.displayQueue();
        queue.deQueue();
        queue.displayQueue();
    }
}
