package case_study.service.control;

import case_study.models.Person.Employee;
import case_study.service.IService.IEmployeeService;
import case_study.util.ReadAndWrite;
import case_study.util.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    Scanner scanner = new Scanner(System.in);

    private static final String PATH_FILE_EMPLOYEE = "D:\\CODEGYM\\Exercise\\java\\untitled\\src\\case_study\\data\\Employee.csv";


    @Override

    public void display() {
        List<Employee> employeeList;
        employeeList = ReadAndWrite.readFileList(PATH_FILE_EMPLOYEE);
        for (Employee employee : employeeList) {
            System.out.printf(employee.toString() + "\n");
        }
    }

    @Override
    public void add() {
        List<Employee> employeeList = new ArrayList<>();
        System.out.print("Nhập thông tin theo yêu cầu");
        System.out.println("\nNhập id nhân viên");
        int id = Integer.parseInt(Regex.inputNumber());
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        String birthday = Regex.inputBirthday();
        System.out.println("Nhập giới tính");
        String sex = scanner.nextLine();
        System.out.println("Nhập chứng minh");
        String idCard = scanner.nextLine();
        System.out.println("Nhập phone");
        String phone = scanner.nextLine();
        System.out.println("Nhập Email");
        String email = scanner.nextLine();
        System.out.println("Nhập chức vụ");
        String level = scanner.nextLine();
        System.out.println("Nhập vị trí");
        String position = scanner.nextLine();
        System.out.println("Nhập lương");
        double salary = Double.parseDouble(Regex.inputNumber());

        Employee employee = new Employee(id, name, birthday, sex, idCard, phone, email, level, position, salary);
        employeeList.add(employee);
        ReadAndWrite.writeList(employeeList, PATH_FILE_EMPLOYEE, true);
        System.out.println("Đã thêm thành công");

    }

    @Override
    public void edit() {
        List<Employee> employeeList;
        employeeList = ReadAndWrite.readFileList(PATH_FILE_EMPLOYEE);
        int checkId = 0;
        System.out.println("Nhập id muốn sửa: ");

        int inputId = 0;
        while (true) {
            try {
                inputId = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Vui long nhap so");
            }
        }
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == inputId) {
                System.out.println("Nhập tên");

                String name = scanner.nextLine();
                System.out.println("Nhập tuổi");
                String birthday = scanner.nextLine();
                System.out.println("Nhập giới tính");
                String sex = scanner.nextLine();
                System.out.println("Nhập chứng minh");
                String idCard = scanner.nextLine();
                System.out.println("Nhập phone");
                String phone = scanner.nextLine();
                System.out.println("Nhập Email");
                String email = scanner.nextLine();
                System.out.println("Nhập chức vụ");
                String level = scanner.nextLine();
                System.out.println("Nhập vị trí");
                String position = scanner.nextLine();
                System.out.println("Nhập lương");
                double salary = Double.parseDouble(Regex.inputNumber());

                employeeList.get(i).setName(name);
                employeeList.get(i).setBirthday(birthday);
                employeeList.get(i).setSex(sex);
                employeeList.get(i).setIdCard(idCard);
                employeeList.get(i).setPhone(phone);
                employeeList.get(i).setEmail(email);
                employeeList.get(i).setLevel(level);
                employeeList.get(i).setPosition(position);
                employeeList.get(i).setSalary(salary);
                System.out.println("Cập nhập thành công");
                checkId++;
            }
        }

        ReadAndWrite.writeList(employeeList, PATH_FILE_EMPLOYEE, false);
        if (checkId == 0) {
            System.out.println("Không tìm thấy id");
        }
    }
}
