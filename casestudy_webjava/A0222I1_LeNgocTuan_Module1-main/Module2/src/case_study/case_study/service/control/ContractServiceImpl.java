package case_study.service.control;

import case_study.models.Person.Customer;
import case_study.models.booking.Booking;
import case_study.models.booking.Contract;
import case_study.service.IService.IContactService;
import case_study.util.ReadAndWrite;

import java.util.*;
import java.util.stream.Collectors;

public class ContractServiceImpl implements IContactService {
    Scanner scanner = new Scanner(System.in);
    public static final String PATH_FILE_BOOKING = "D:\\CODEGYM\\Exercise\\java\\untitled\\src\\case_study\\data\\Booking.csv";
    public static final String PATH_FILE_CONTRACT = "D:\\CODEGYM\\Exercise\\java\\untitled\\src\\case_study\\data\\Contract.csv";

    public static final String PATH_FILE_TEMP = "D:\\CODEGYM\\Exercise\\java\\untitled\\src\\case_study\\data\\Temp.csv";
    @Override
    public void display() {
        List<Contract> contractList = ReadAndWrite.readFileContract(PATH_FILE_CONTRACT);

        for (Contract contract : contractList) {
            System.out.println(contract + "\t");
        }
    }

    @Override
        public void add() {
            Set<Booking> bookingSet = ReadAndWrite.readFileBooking(PATH_FILE_BOOKING);
            Queue<Booking> bookingQueue = new LinkedList<>(bookingSet);
            Set<Booking> temp = ReadAndWrite.readFileBooking(PATH_FILE_TEMP);

            List<Contract> contractList = ReadAndWrite.readFileContract(PATH_FILE_CONTRACT);
            int idContract = contractList.size() + 1;

    //        Set<Booking> bookings = ReadAndWrite.readFileBooking(PATH_FILE_BOOKING);
    //        Queue<Booking> bookingQueue = new LinkedList<>();
    //        for (Booking booking : bookings) {
    //            bookingQueue.add(booking);
    //        }
    //        List<Contract> contractList;
    //        contractList = ReadAndWrite.readFileContract(PATH_FILE_CONTRACT);
    //        int idContract = contractList.size() + 1;

            Booking bookToContract = bookingQueue.peek();
            Customer customer = bookToContract.getIdCustomer();

            System.out.println("Vui lòng nhập số tiền cọc trước:");
            double depositMoney = Double.parseDouble(scanner.nextLine());
            System.out.println("Vui lòng nhập tổng số tiền thanh toán:");
            double payments = Double.parseDouble(scanner.nextLine());

            contractList.add(new Contract(idContract, bookToContract, depositMoney, payments, customer));
            ReadAndWrite.writeList(contractList, PATH_FILE_CONTRACT, false);

            temp.add(bookingQueue.poll());
            bookingSet.remove(bookToContract);
            ReadAndWrite.writeFileBooking(temp,PATH_FILE_TEMP,false);

    //        bookings.clear();
    //        for (Booking booking1 : bookingQueue) {
    //            bookings.add(booking1);
    //        }

            ReadAndWrite.writeFileBooking(bookingSet, PATH_FILE_BOOKING, false);
        }

    @Override
    public void edit() {
        List<Contract> contractList;
        contractList = ReadAndWrite.readFileContract(PATH_FILE_CONTRACT);
        System.out.println("Nhập Id Contract");
        int checkId = 0;
        int id = Integer.parseInt(scanner.nextLine());
        for (Contract contract : contractList) {
            if (contract.getIdContract() == id) {
                System.out.println("Vui lòng nhập số tiền cọc trước:");
                double depositMoney = Double.parseDouble(scanner.nextLine());
                System.out.println("Vui lòng nhập tổng số tiền thanh toán:");
                double payments = Double.parseDouble(scanner.nextLine());
                contract.setDepositMoney(depositMoney);
                contract.setPayments(payments);
                System.out.println("Cập nhập thành công");
                checkId++;
            }
        }
        ReadAndWrite.writeList(contractList, PATH_FILE_CONTRACT, false);
        if (checkId == 0) {
            System.out.println("Không tìm thấy id");
        }
    }
}
