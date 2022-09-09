package ss11_slack_queue.thuc_hanh.stack_linked_list;

public class GenericStackClient {
    private static void stackOfStrings() {
        MyGenericStack<String> myGenericStack = new MyGenericStack<>();
        myGenericStack.push("One ");
        myGenericStack.push("Four ");
        myGenericStack.push("Three ");
        myGenericStack.push("Two ");
        myGenericStack.push("Nine");
        System.out.printf("Size my generic stack before pop is: %d\n", myGenericStack.size());
        while (!myGenericStack.isEmpty()) {
            System.out.printf("%s", myGenericStack.pop());
        }
        System.out.printf("\nSize my generic stack after pop is: %d", myGenericStack.size());
    }

    private static void stackOfIntegers() {
        MyGenericStack<Integer> myGenericStack = new MyGenericStack<>();
        myGenericStack.push(11);
        myGenericStack.push(23);
        myGenericStack.push(21);
        myGenericStack.push(52);
        myGenericStack.push(12);
        System.out.printf("Size my generic stack before pop is: %d\n", myGenericStack.size());
        while (!myGenericStack.isEmpty()) {
            System.out.printf("%s\t", myGenericStack.pop());
        }
        System.out.printf("\nSize my generic stack after pop is: %d", myGenericStack.size());
    }

    public static void main(String[] args) {
        System.out.println("stack Of Strings");
        stackOfStrings();
        System.out.println("\nstack Of Integers");
        stackOfIntegers();
    }
}
