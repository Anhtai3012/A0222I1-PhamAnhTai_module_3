package ss10_list_array.bai_tap.linked_list;

public class Solution {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addLast(10);
        linkedList.addLast(14);
        linkedList.addLast(15);
        linkedList.addLast(14);
        linkedList.addLast(19);
        linkedList.addFirst(30);
        linkedList.addFirst(34);
        linkedList.add(3, 16);
        linkedList.removeElement(15);
        linkedList.removeByIndex(5);
        linkedList.showData();
    }
}
