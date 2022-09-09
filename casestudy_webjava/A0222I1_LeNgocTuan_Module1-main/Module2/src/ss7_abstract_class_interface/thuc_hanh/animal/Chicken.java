package ss7_abstract_class_interface.thuc_hanh.animal;

public class Chicken extends Animal implements Edible {
    private boolean status = true;

    @Override
    protected void makeSound() {
        System.out.println("Chicken make Noise");
    }

    @Override
    protected void eat() {
        System.out.println("Chicken eat rice");
    }

    @Override
    public String howToEat() {
        this.status = false;
        return "Chicken is eaten";
    }

    @Override
    public void isExist() {
        if (status) System.out.println("Chicken Live");
        else System.out.println("Chicken Die");
    }
}
