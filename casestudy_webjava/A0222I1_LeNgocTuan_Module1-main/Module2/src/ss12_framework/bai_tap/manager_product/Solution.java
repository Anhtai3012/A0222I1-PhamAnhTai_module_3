package ss12_framework.bai_tap.manager_product;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        ManagerProduct managerProduct = new ManagerProduct();
        loop:
        while (true) {
            System.out.print("1.Add new\n2.Edit by ID\n3.Delete By ID\n4.Show ALL List\n5.Find by Name\n6.Sort\n7.Quit\n");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Your choice: ");
            String choice = (scanner.nextLine());
            switch (choice) {
                case "1": {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Price: ");
                    int price = Integer.parseInt(scanner.nextLine());
                    Product product = new Product(id, name, price);
                    managerProduct.add(product);
                }
                break;
                case "2": {
                    System.out.print("ID want set: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    if (managerProduct.searchProductById(id) == null) {
                        System.out.println("List not have product with id " + id);
                        break;
                    }
                    System.out.println("This is " + managerProduct.searchProductById(id).toString() + "\nChange new Name: ");
                    String name = scanner.nextLine();
                    System.out.print("New Price: ");
                    int price = Integer.parseInt(scanner.nextLine());
                    managerProduct.setNewValue(id, name, price);
                }
                break;
                case "3": {
                    System.out.println("ID want delete: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    managerProduct.remove(id);
                }
                break;
                case "4": {
                    managerProduct.showAllList();
                }
                break;
                case "5": {
                    System.out.print("Name want to check: ");
                    String name = scanner.nextLine();
                    if ((managerProduct.searchProductByName(name) == null)) {
                        System.out.printf("List not have another have name %s\n", name);
                    } else {
                        System.out.println(managerProduct.searchProductByName(name).toString());
                    }
                }
                break;
                case "6": {
                    System.out.print("1.Sort price Low -> High\n2.Sort price High -> Low\n3.Quit\nChoice: ");
                    int choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1) {
                        managerProduct.sortPriceLowToHigh();
                        managerProduct.showAllList();
                    } else if (choose == 2) {
                        managerProduct.sortPriceHighToLow();
                        managerProduct.showAllList();
                    } else break;
                }
                break;
                default: {
                    System.out.println("Bye...");
                    break loop;
                }
            }
        }
    }
}
