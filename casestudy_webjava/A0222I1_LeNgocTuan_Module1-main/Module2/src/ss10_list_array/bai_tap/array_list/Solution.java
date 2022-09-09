package ss10_list_array.bai_tap.array_list;

public class Solution {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();

        myList.getInfo();
        myList.addObjectInIndex(1, 4);
        myList.addObjectInIndex(0, 3);
        myList.addObjectInIndex(3, 6);
        myList.addObjectInIndex(4, 7);
        myList.addObjectInIndex(9, 14);
        myList.addObjectInIndex(8, 12);
        myList.addObjectInIndex(11, 18);
        myList.addObjectInIndex(15, 15);

        System.out.print("List: ");
        myList.getInfo();
        myList.removeObjectInIndex(1);  // remove object index 1
        System.out.print("List: ");
        myList.getInfo();
        myList.removeObjectInIndex(myList.findIndexOfObject(14)); //remove object 14
        System.out.print("List: ");
        myList.getInfo();
    }
}
