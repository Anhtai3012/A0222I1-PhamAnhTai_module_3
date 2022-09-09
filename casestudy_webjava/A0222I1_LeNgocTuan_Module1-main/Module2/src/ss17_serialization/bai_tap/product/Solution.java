package ss17_serialization.bai_tap.product;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        String fileNameCopy = "D:\\CODEGYM\\Full module\\Module2\\src\\ss17_serialization\\bai_tap\\product\\Copy.bin";
        String fileName = "D:\\CODEGYM\\Full module\\Module2\\src\\ss17_serialization\\bai_tap\\product\\ProductList.bin";
        List<Product> productList = new LinkedList<>();
//        productList = takeDataAsListFromFile(fileName); // for write continue in data in file
        loop:
        while (true) {

            try {
                System.out.print("1.Add New\n2.Display\n3.Search Info by ID\n4.Copy\n5.Sort by price\n6.Quit\nChoice ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Choice must number!");
            }

            switch (choice) {

                case 1:
                    addNew(productList); // write new again
                    addDataIntoFile(fileName, productList);
                    break;

                case 2:
                    System.out.println("file name root");
                    displayData(getDataAsListFromFile(fileName));
                    System.out.println("file name copy");
                    displayData(getDataAsListFromFile(fileNameCopy));
                    break;

                case 3:
                    displayData(searchProductFromFile(fileName));
                    break;

                case 4:
                    copyDataIntoFile(getDataAsListFromFile(fileName), fileNameCopy);
                    break;

                case 5:
                    if (productList.size() == 0) System.out.println("Empty List. NON SORT");
                    productList.sort((o1, o2) -> {
                        if (o1.getPrice() > o2.getPrice()) return 1;
                        if (o1.getPrice() < o2.getPrice()) return -1;
                        return o1.getName().compareToIgnoreCase(o2.getName());
                    });
                    displayData(productList);
                    break;

                default:
                    System.out.println("Bye");
                    break loop;
            }
        }
    }

    public static void addNew(List<Product> list) {
        while (true) {
            try {
                System.out.print("id ");
                int id = Integer.parseInt(scanner.nextLine());
                if (isExist(list, id)) {
                    System.out.println("Id is duplicate");
                    continue;
                }
                System.out.print("name ");
                String name = scanner.nextLine();
                System.out.print("manufacturer ");
                String manufacturer = (scanner.nextLine());
                System.out.print("price ");
                int price = Integer.parseInt(scanner.nextLine());
                System.out.print("other ");
                String other = scanner.nextLine();
                Product product = new Product(id, name, manufacturer, price, other);
                list.add(product);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Id, Price MUST Number");
            }
        }
        System.out.println("Add new complete");
    }

    public static boolean isExist(List<Product> products, int id) {
        for (Product product: products) {
            if (product.getId() == (id)) return true;
        }
        return false;
    }

    public static void addDataIntoFile(String fileName, List<Product> list) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        } catch (IOException e) {
            System.out.println("File can't Write");
        } finally {
            try {
                assert objectOutputStream != null;
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Product> getDataAsListFromFile(String fileName) {
        List<Product> products = new LinkedList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            products = (List<Product>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void copyDataIntoFile(List<Product> list, String fileName) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Complete...");
        }
    }

    public static void displayData(List<Product> list) {
        for (Product pro : list) {
            System.out.println(pro);
        }
    }

    public static List<Product> searchProductFromFile(String fileName) {
        List<Product> search = new LinkedList<>();
        int id = 0;
        boolean flag = true;

        try {
            System.out.print("id want search ");
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Id must Number");
            return search;
        }

        for (Product product : getDataAsListFromFile(fileName)) {
            if (product.getId() == id) {
                search.add(product);
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.print("id NOT exist in list");
        }
        return search;
    }
}
