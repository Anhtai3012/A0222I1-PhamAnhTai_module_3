package ss11_slack_queue.thuc_hanh.stack_linked_list;


import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack() {
        stack = new LinkedList<>();
    }

    public void push(T t) {
        stack.addFirst(t);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
       return stack.removeLast();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }
}
