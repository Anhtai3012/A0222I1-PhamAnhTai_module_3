package java_basic.manager_resort.controller;

import java_basic.manager_resort.models.person.Tourist;
import java.util.Stack;

public class PromotionController {
    static Stack<Tourist> personStack;


    static {
        personStack = new Stack<>();
    }

    public void addNew(Tourist person) {
        if (!isExistTouristInStack(person)) {
            personStack.push(person);
        }
    }

    public Tourist pop(){
        return personStack.pop();
    }

    public boolean isEmpty(){
        return personStack.isEmpty();
    }

    public boolean isExistTouristInStack(Tourist person) {
        for (Tourist tourist : personStack) {
            if (person.hasId(tourist.getId())) return true;
        }
        return false;
    }

    public void displayPersonUse() {
        if (personStack.isEmpty()) return;
        personStack.forEach(x -> System.out.println(x.toString()));
    }
}
