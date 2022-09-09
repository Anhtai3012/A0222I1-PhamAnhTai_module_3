package ss7_abstract_class_interface.thuc_hanh.animal;

public class Tiger extends Animal{
    @Override
    protected void makeSound() {
        System.out.println("Tiger make noise");
    }

    @Override
    protected void eat() {
        System.out.println("Tiger Hunting");
    }
}
