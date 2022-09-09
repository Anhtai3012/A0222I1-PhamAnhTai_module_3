package ss7_abstract_class_interface.thuc_hanh.animal;

public class Apple extends Fruit implements Edible {
    private boolean status = true;
    @Override
    public String howToEat() {
        status = false;
        return "Apple is eaten";
    }

    @Override
    public void isExist() {
        if(status) System.out.println("Apple is Exist");
        else System.out.println("Apple is not Exist");
    }
}
