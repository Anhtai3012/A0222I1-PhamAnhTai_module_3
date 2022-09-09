package ss10_list_array.thuc_hanh.list;

public class Solution {
    public static void main(String[] args) {
        NewList<Integer> myList = new NewList<>();
        myList.addObject(11);
        myList.addObject(22);
        myList.addObject(33);
        myList.addObject(44);

        myList.getInfo();
        System.out.printf("\nelement index %d: %s\n",1,myList.get(1));
        System.out.printf("element index %d: %s\n",0,myList.get(0));
        System.out.printf("element index %d: %s\n",3,myList.get(3));
        System.out.printf("element index %d: %s\n",2,myList.get(2));
        System.out.printf("element index %d: %s\n",1,myList.get(-1));
    }
}
