package case_study.service.control;

import case_study.models.Person.Customer;
import case_study.models.booking.Booking;
import case_study.models.facility.Facility;
import case_study.service.IService.IBookingService;
import case_study.util.ReadAndWrite;
import case_study.util.Regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class BookingServiceImpl implements IBookingService {
    private static final String PATH_FILE_CUSTOMER = "D:\\CODEGYM\\Exercise\\java\\untitled\\src\\case_study\\data\\Customer.csv";
    public static final String PATH_FILE_FACILITY = "D:\\CODEGYM\\Exercise\\java\\untitled\\src\\case_study\\data\\Facility";
    public static final String PATH_FILE_BOOKING = "D:\\CODEGYM\\Exercise\\java\\untitled\\src\\case_study\\data\\Booking.csv";
    static Scanner scanner = new Scanner(System.in);




    @Override
    public void display() {
        Set<Booking> bookings;
        bookings = ReadAndWrite.readFileBooking(PATH_FILE_BOOKING);
        for (Booking booking : bookings) {
            System.out.printf(booking.toString() + "\n");
        }
    }

    @Override
    public void add() {
        Map<Facility, Integer> facilityMap = ReadAndWrite.readFile(PATH_FILE_FACILITY);
        Set<Booking> bookings;
        bookings = ReadAndWrite.readFileBooking(PATH_FILE_BOOKING);
        int id = bookings.size() + 1;
        Customer customer = choosesCustomer();
        Facility facility = choosesFacility();
        LocalDate startDay = null;
        LocalDate endDay = null;
        boolean flag = true;
        do {
            try {
                System.out.println("Nhập ngày bắt đầu");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                startDay = LocalDate.parse(scanner.nextLine(), formatter);
                System.out.println("Nhập ngày kết thúc");
                endDay = LocalDate.parse(scanner.nextLine(), formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Nhập ngày theo định dạng dd/MM/yyyy");
            }
        } while (flag);

        System.out.println("Nhập kiểu dịch vụ");
        String serviceType = Regex.inputServiceType();
        bookings.add(new Booking(id, startDay, endDay, customer, facility, serviceType));
        ReadAndWrite.writeFileBooking(bookings, PATH_FILE_BOOKING, false);
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            if (facility.getIdFacility().equals(entry.getKey().getIdFacility())) {
               facilityMap.put(entry.getKey(),entry.getValue()+1);
            }
        }
        ReadAndWrite.writeFile(facilityMap,PATH_FILE_FACILITY,false);
    }


    public static Customer choosesCustomer() {
        List<Customer> customerList = ReadAndWrite.readFileList(PATH_FILE_CUSTOMER);
        System.out.println("Danh sách Customer");
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
        System.out.println("Nhập Id khách hàng muốn Booking:");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flag = true;
        while (flag) {
            for (Customer customer : customerList) {
                if (customer.getId() == id) {
                    flag = false;
                    System.out.println("Nhập mã khách hàng thành công");
                    return customer;
                }
            }
            if (flag) {
                System.out.println("Không tìm thấy khách hàng, vui lòng nhập lại");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
        return null;
    }

    public static Facility choosesFacility() {
        Map<Facility, Integer> facilityMap = ReadAndWrite.readFile(PATH_FILE_FACILITY);
        System.out.println("Danh sách Facility");
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            System.out.println(entry.toString());
        }

        System.out.println("Nhập Id mã dịch vụ Facility:");
        String id = scanner.nextLine();
        boolean flag = true;
        while (flag) {
            for (Facility key : facilityMap.keySet()) {
                if (key.getIdFacility().equals(id)) {
                    flag = false;
                    System.out.println("Nhập mã dịch vụ thành công");
                    return key;
                }
            }
            if (flag) {
                System.out.println("Không tìm thấy mã dịch vụ, vui lòng nhập lại");
                id = scanner.nextLine();
            }
        }
        return null;
    }


}
