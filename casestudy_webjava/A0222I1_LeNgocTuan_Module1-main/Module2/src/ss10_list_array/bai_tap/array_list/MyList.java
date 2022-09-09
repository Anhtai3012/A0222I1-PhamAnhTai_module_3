package ss10_list_array.bai_tap.array_list;

import java.util.Arrays;

public class MyList<Integer> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    public Object[] myList;

    public MyList() {
        size = DEFAULT_CAPACITY;
        myList = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        size = capacity;
        myList = new Object[capacity];
    }

    public void checkIndex(int index) {
        if (index < 0 || index > myList.length) {
            throw new IndexOutOfBoundsException("\nOut Bound in index: " + index);
        }
    }

    private Object[] ensureCapacity() {
        return Arrays.copyOf(myList, myList.length + 1);
    }

    public void addObjectInIndex(int index, Object object) {
        checkIndex(index);
        if (addObjectNotDuplicate(object)) {
            Object[] result = ensureCapacity();
            for (int i = index; i < getSizeOfList(); i++) {
                if (i > index) result[i] = myList[i];
                result[index] = object;
            }
            myList = result;
        }
    }

    public void removeObjectInIndex(int index) {
        Object[] result = ensureCapacity();
        checkIndex(index);
        for (int i = index; i < getSizeOfList(); i++) {
            if (i > index) result[i - 1] = myList[i];
        }
        myList = result;
    }

    public int getSizeOfList() {
        return myList.length;
    }

    public Object[] clonesList() {
        return myList.clone();
    }

    public boolean containObjectInList(Object object) {
        for (Object o : myList) {
            if (o == object) {
                return true;
            }
        }
        return false;
    }

    public int findIndexOfObject(Object object) {
        for (int i = 0; i < getSizeOfList(); i++) {
            if (myList[i] == object) {
                return i;
            }
        }
        return -1;
    }

    public boolean addObjectNotDuplicate(Object object) {
        for (Object o : myList) {
            if (o == object) {
                System.out.printf("%s is duplicate", o);
                return false;
            }
        }
        return true;
    }

    public void ensureCapacity(int capacity) {
        if (capacity < getSizeOfList()) {
            System.out.printf("new size %d too small in old length %d\n", capacity, myList.length);
            return;
        }
        myList = Arrays.copyOf(myList, capacity);
    }

    public Object getObjectByIndex(int index) {
        checkIndex(index);
        return myList[index];
    }

    public void clearData() {
        size = 0;
        myList = new Object[size];
    }

    public void getInfo() {
        for (Object o : myList) {
            if (o == null) {
                System.out.print("empty, ");
            } else {
                System.out.print(o + ", ");
            }
        }
        System.out.println("\nSize list now is " + getSizeOfList() + "\n");
    }
}
