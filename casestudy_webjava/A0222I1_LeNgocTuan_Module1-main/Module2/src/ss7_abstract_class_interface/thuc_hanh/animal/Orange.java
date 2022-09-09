package ss7_abstract_class_interface.thuc_hanh.animal;

public class Orange extends Fruit implements Edible {
    private boolean status = true;

    @Override
    public String howToEat() {
        status = false;
        return "Orange is eaten by %s";
    }

    @Override
    public void isExist() {
        if (status) System.out.println("Orange is Exist");
        else System.out.println("Orange is not Exist");
    }
}
