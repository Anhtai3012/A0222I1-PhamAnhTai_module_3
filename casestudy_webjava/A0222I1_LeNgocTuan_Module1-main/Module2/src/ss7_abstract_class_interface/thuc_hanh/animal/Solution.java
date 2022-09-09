package ss7_abstract_class_interface.thuc_hanh.animal;

public class Solution {
    public static void main(String[] args) {
        Animal[] zoo = new Animal[2];
        zoo[0] = new Tiger();
        zoo[1] = new Chicken();

        Fruit[] foodOfZoo = new Fruit[2];
        foodOfZoo[0] = new Apple();
        foodOfZoo[1] = new Orange();
        for (Fruit fruit : foodOfZoo) {
            fruit.isExist();
        }
        foodOfZoo[0].howToEat();
        foodOfZoo[0].isExist();
        for (Animal animal : zoo) {
            animal.makeSound();
            animal.eat();
            if (animal instanceof Chicken) {
                ((Chicken) animal).isExist();
                System.out.printf("%s\n", ((Chicken) animal).howToEat());
                ((Chicken) animal).isExist();
            }
        }
    }
}
