package java_basic.manager_resort.view;

import java_basic.manager_resort.controller.*;
import java_basic.manager_resort.models.Booking;
import java_basic.manager_resort.models.Contract;
import java_basic.manager_resort.models.facility.Room;
import java_basic.manager_resort.models.facility.Villa;
import java_basic.manager_resort.models.person.Tourist;
import java_basic.manager_resort.utils.TypeCorrect;

import java.util.List;
import java.util.Scanner;


public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static FacilityController facilityController = new FacilityController();
    static TouristController touristController = new TouristController();
    static BookingController bookingController = new BookingController();
    static ContactController contactController = new ContactController();
    static PromotionController promotionController = new PromotionController();
    static VoucherController voucherController = new VoucherController();

    public static void main(String[] args) {
        loop:
        while (true) {
            MenuController.displayMenu("Person Manager,Facility Manager,Booking Manager,Contract Manager,Promotion Manager,Quit");
            int option = TypeCorrect.choiceNumberOption();
            switch (option) {
                case 1:
                    displayPersonMenu();
                    break;
                case 2:
                    displayFacilityMenu();
                    break;
                case 3:
                    displayBookingMenu();
                    break;
                case 4:
                    displayContactMenu();
                    break;
                case 5:
                    displayPromotionMenu();
                    break;
                default:
                    System.out.println("Bye");
                    break loop;
            }
        }
    }

    public static void displayPersonMenu() {
        MenuController.displayMenu("Add New Tourist,Edit,Display,Quit");
        int option = TypeCorrect.choiceNumberOption();
        switch (option) {
            case 1: {
                List<String> data = MenuController.collectDataFromUserInput(Tourist.getPropertiesTourist());
                touristController.addNewTouristInList(new Tourist(data));
//                touristController.addNewTouristInList(new Tourist("4222", "Will", "11/4/2019", "04211132", "cume1a2@gmail.com", "Normal"));
//                touristController.addNewTouristInList(new Tourist("4412", "Min", "11/4/2019", "04913132", "cume1o4@gmail.com", "Normal"));
                break;
            }
            case 2: {
                touristController.editTourist();
                break;
            }
            case 3:
                touristController.displayTourists();
                break;
            default:
                break;
        }
    }

    public static void displayFacilityMenu() {
        MenuController.displayMenu("Add New,Display Can Use,Display Maintenance,Quit");
        int option = TypeCorrect.choiceNumberOption();
        switch (option) {
            case 1: {
                displayAddNewFacility();
                break;
            }
            case 2: {
                facilityController.displayCanUse();
                break;
            }
            case 3:
                facilityController.displayMaintenance();
                break;
            default:
                break;
        }
    }

    public static void displayAddNewFacility() {
        MenuController.displayMenu("Add New Room,Add New Villa,Back Main Menu");
        int option = TypeCorrect.choiceNumberOption();
        switch (option) {
            case 1: {
                List<String> value = MenuController.collectDataFromUserInput(Room.getPropertiesRoom());
                facilityController.addNewInMap(new Room(value));
//                facilityController.addNewInMap(new Room("VL5445", "Cawk", "55", "124", "Now", "wifi"));
//                facilityController.addNewInMap(new Room("VL5555", "Chick", "55", "124", "Now", "wifi"));
                break;
            }
            case 2: {
                List<String> value = MenuController.collectDataFromUserInput(Villa.getPropertiesVilla());
                facilityController.addNewInMap(new Villa(value));
                break;
            }
            default:
                break;
        }
    }

    public static void displayBookingMenu() {
        MenuController.displayMenu("Add Booking,Display All Booking,Back Main Menu");
        int option = TypeCorrect.choiceNumberOption();
        switch (option) {
            case 1: {
                displayAddNewBooking();
                break;
            }
            case 2: {
                bookingController.displaySet();
                break;
            }
            default:
                break;
        }
    }

    public static void displayAddNewBooking() {
        touristController.displayTourists();
        System.out.print("Id Tourist ");
        String idTourist = scanner.nextLine();

        if (touristController.searchById(idTourist) == null) return;

        facilityController.displayCanUse();
        System.out.print("Id Facility ");
        String idFacility = scanner.nextLine();

        if (facilityController.searchFacility(idFacility) == null) return;

        List<String> value = MenuController.collectDataFromUserInput(Booking.getPropertiesBooking());
        bookingController.addNew(new Booking(idTourist, idFacility,
                idFacility + "-" + idTourist,
                TypeCorrect.converterStringToLocalDate(value.get(0)),
                TypeCorrect.converterStringToLocalDate(value.get(1))));

//        bookingController.addNew(new Booking("4222", "VL5445",
//                "VL5445" + "-" + "4222",
//                TypeCorrect.converterStringToLocalDate("11/11/2022"),
//                TypeCorrect.converterStringToLocalDate("14/11/2022")));
//        bookingController.addNew(new Booking("4412", "VL5555",
//                "VL5555" + "-" + "4412",
//                TypeCorrect.converterStringToLocalDate("12/11/2022"),
//                TypeCorrect.converterStringToLocalDate("16/11/2022")));
    }

    public static void displayContactMenu() {
        MenuController.displayMenu("Add New Contact,Display,Back Main Menu");
        int option = TypeCorrect.choiceNumberOption();
        switch (option) {
            case 1: {
                displayAddNewContact();
                break;
            }
            case 2: {
                contactController.displayQueue();
                break;
            }
            default:
                break;
        }
    }

    public static void displayAddNewContact() {
        bookingController.displaySet();
        System.out.println("id Booking");
        String idBooking = scanner.nextLine();

        if (bookingController.searchByIdBooking(idBooking) == null) return;

        plusValueFacilityInBookingToContact(idBooking);

        addTouristGetVoucher(idBooking);

        String voucher = voucherController.searchTouristGetVoucher(bookingController.searchByIdBooking(idBooking).idPerson).getValue();

        int moneyToUse = calculatorMoney(idBooking);

        double discount = TypeCorrect.getDiscountFromVoucher(voucher);

        contactController.addNew(new Contract("SV" + idBooking, idBooking, voucher, discount
                , moneyToUse - (moneyToUse * discount)));

        bookingController.remove(bookingController.searchByIdBooking(idBooking));
    }

    public static void displayPromotionMenu() {
        MenuController.displayMenu("Display Tourist Use,Display Voucher,Back Main Menu");
        int option = TypeCorrect.choiceNumberOption();
        switch (option) {
            case 1:
                voucherController.displayTouristUseService();
                break;
            case 2:
                voucherController.displayMapVoucher();
                break;
            default:
                break;
        }
    }


    public static int calculatorMoney(String idBooking) {
        int dateToUse = bookingController.searchByIdBooking(idBooking).getDateToUse();
        int price = Integer.parseInt(facilityController.searchFacility(bookingController.searchByIdBooking(idBooking).idFacility).getKey().getPrice());
        return dateToUse * price;
    }

    public static void plusValueFacilityInBookingToContact(String idBooking) {
        facilityController.plusValue(facilityController.searchFacility(bookingController.searchByIdBooking(idBooking).idFacility));
    }

    public static void addTouristGetVoucher(String idBooking) {
        promotionController.addNew(touristController.searchById(bookingController.searchByIdBooking(idBooking).idPerson));
        voucherController.setMapPersonGetVoucher(promotionController);
    }

}

