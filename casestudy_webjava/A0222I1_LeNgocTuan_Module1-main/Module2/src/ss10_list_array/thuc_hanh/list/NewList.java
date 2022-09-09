package ss10_list_array.thuc_hanh.list;

import java.util.Arrays;

public class NewList<element> {
    private int MIN_VALUE_IN_LIST = 0;
    private final int MAX_VALUE_IN_LIST = 10;
    public Object[] name;

    public NewList() {
        name = new Object[MAX_VALUE_IN_LIST];
    }

    public void ensureCapa() {
        int newSize = name.length * 2;
        name = Arrays.copyOf(name, newSize);
    }


    public Object[] addObject(Object object) {
        if (name.length == MIN_VALUE_IN_LIST) {
            ensureCapa();
        }
        name[MIN_VALUE_IN_LIST++] = object;
        return name;
    }

    public Object get(int index) {
        if (index < 0 || index > MIN_VALUE_IN_LIST){
            throw new IndexOutOfBoundsException("Out bound in index " + index);
        }
        return name[index];
    }
    public void getInfo(){
        for (Object o: name) {
            System.out.print(o + "\t");
        }
    }

}
