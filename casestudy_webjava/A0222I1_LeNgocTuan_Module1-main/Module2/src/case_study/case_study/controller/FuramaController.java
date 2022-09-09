package case_study.controller;

import case_study.service.control.*;

import java.util.Scanner;

public class FuramaController {
    static Scanner scanner = new Scanner(System.in);
    static EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    static CustomerServiceImpl customerService = new CustomerServiceImpl();
    static FacilityServiceImpl facilityService = new FacilityServiceImpl();
    static BookingServiceImpl bookingService = new BookingServiceImpl();
    static ContractServiceImpl contractService = new ContractServiceImpl();

    public static void displayMainMenu() {
        do {
            System.out.println("------MENU FURAMA------ " +
                    "\n 1. Employee Management" +
                    "\n 2. Customer Management" +
                    "\n 3. Facility Management " +
                    "\n 4. Booking Management" +
                    "\n 5. Management" +
                    "\n 6. Exit");
            System.out.println("Choose function");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    displayEmployeeManagement();
                    break;
                case 2:
                    displayCustomerManagement();
                    break;
                case 3:
                    displayFacilityManagement();
                    break;
                case 4:
                    displayBookingManagement();
                    break;
                case 5:
                    displayPromotionManagement();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.print("You need to choose again");
            }
        } while (true);
    }

    public static void displayEmployeeManagement() {
        do {
            System.out.println("------EMPLOYEE MANAGEMENT------" +
                    "\n 1. Display list employees" +
                    "\n 2. Add new employee" +
                    "\n 3. Edit employee " +
                    "\n 4. Return main menu");
            System.out.println("Choose function");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.add();
                    break;
                case 3:
                    employeeService.edit();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.out.print("You need to choose again\n");
            }
        } while (true);
    }

    public static void displayCustomerManagement() {
        do {
            System.out.println("------CUSTOMERS MANAGEMENT------" +
                    "\n 1. Display list customers" +
                    "\n 2. Add new customer" +
                    "\n 3. Edit customer " +
                    "\n 4. Return main menu" +
                    "\n 5. Delete Customer");
            System.out.println("Choose function");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    customerService.display();
                    break;
                case 2:
                    customerService.add();
                    break;
                case 3:
                    customerService.edit();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                case 5:
                    customerService.deleteCustomer();
                    break;
                default:
                    System.out.printf("You need to choose again\n");
            }
        } while (true);
    }

    public static void displayFacilityManagement() {
        do {
            System.out.println("------FACILITY MANAGEMENT------" +
                    "\n 1. Display list facility" +
                    "\n 2. Add new facility" +
                    "\n 3. Display list facility maintenance " +
                    "\n 4. Return main menu");
            System.out.println("Choose function");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    facilityService.displayFacilityCanUse();
                    break;
                case 2:
                    facilityService.addNew();
                    break;
                case 3:
                    facilityService.displayFacilityMaintenance();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.out.print("You need to choose again\n");
            }
        } while (true);
    }

    public static void displayBookingManagement() {
        do {
            System.out.println("------BOOKING MANAGEMENT------" +
                    "\n 1. Add new booking" +
                    "\n 2. Display list booking" +
                    "\n 3. Create new constracts " +
                    "\n 4. Display list contracts" +
                    "\n 5. Edit contracts" +
                    "\n 6. Return main menu");
            System.out.println("Choose function");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    bookingService.add();
                    break;
                case 2:
                    bookingService.display();
                    break;
                case 3:
                    contractService.add();
                    break;
                case 4:
                    contractService.display();
                    break;
                case 5:

                    break;
                case 6:
                    displayMainMenu();
                    break;
                default:
                    System.out.print("You need to choose again\n");
            }
        } while (true);
    }

    public static void displayPromotionManagement() {
        boolean flag = true;
        do {
            System.out.println("------PROMOTION MANAGEMENT------" +
                    "\n 1. Display list customers use service" +
                    "\n 2. Display list customers get voucher" +
                    "\n 3. Return main menu");
            System.out.println("Choose function");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    displayMainMenu();
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }
}
