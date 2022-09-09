package java_basic.manager_resort.controller;

import java_basic.manager_resort.models.Contract;

import java.util.LinkedList;
import java.util.Queue;

public class ContactController {
    static Queue<Contract> contracts;

    static {
        contracts = new LinkedList<>();
    }

    public void addNew(Contract contract) {
        if (isExist(contract)) return;
        contracts.add(contract);
    }

    public boolean isExist(Contract contract) {
        for (Contract element : contracts) {
            if (element.getCodeInvoice().equalsIgnoreCase(contract.getCodeInvoice())) return true;
        }
        return false;
    }

    public void displayQueue() {
        contracts.forEach(x-> System.out.println(x.toString()));
    }
}
