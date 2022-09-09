package ss10_list_array.thuc_hanh.linked_list;

public class Solution {
    public static void main(String[] args) {
        NewLinkedList newLinkedList = new NewLinkedList(10);
        newLinkedList.addFirstData(15);
        newLinkedList.addFirstData(22);
        newLinkedList.addFirstData(53);
        newLinkedList.addData(4,24);
        newLinkedList.addData(7,35);
        newLinkedList.printList();
        newLinkedList.getData(1);
    }
}
