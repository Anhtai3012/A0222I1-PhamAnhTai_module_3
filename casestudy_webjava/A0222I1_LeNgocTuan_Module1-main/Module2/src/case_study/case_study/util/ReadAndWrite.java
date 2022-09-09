package case_study.util;

import case_study.models.Person.Customer;
import case_study.models.Person.Employee;
import case_study.models.booking.Booking;
import case_study.models.booking.Contract;
import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ReadAndWrite {
    public static final String PATH_FILE_CONTRACT = "D:\\CODEGYM\\Exercise\\bai_tap\\src\\case_study\\data\\Contract.csv";
    public static final String PATH_FILE_TEMP = "D:\\CODEGYM\\Exercise\\bai_tap\\src\\case_study\\data\\Temp.csv";


    public static void writeFile(Map<Facility, Integer> facilityMap, String pathFile, boolean append) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
//                if (entry.getKey() instanceof Villa) {
//                    bufferedWriter.write(entry.getKey().getData() + entry.getValue());
//                    bufferedWriter.newLine();
//                }
//                if (entry.getKey() instanceof Room) {
//                    bufferedWriter.write(entry.getKey().getData() + entry.getValue());
//                    bufferedWriter.newLine();
//                }
//                if (entry.getKey() instanceof House) {
//                    bufferedWriter.write(entry.getKey().getData() + "," + entry.getValue());
//                    bufferedWriter.newLine();
//                }
                bufferedWriter.write(entry.getKey().getData() + entry.getValue());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Facility, Integer> readFile(String pathFile) {
        Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        String[] array = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                if (array.length == 10) {
                    // dung neu length bang nhau   if(array[0].contains("SVVL"))
                    facilityMap.put(new Villa(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3])
                            , Integer.parseInt(array[4]), array[5], array[6]
                            , Double.parseDouble(array[7]), Integer.parseInt(array[8])), Integer.parseInt(array[9]));
                }
                if (array.length == 9) {
                    facilityMap.put(new House(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3])
                            , Integer.parseInt(array[4]), array[5], array[6]
                            , Integer.parseInt(array[7])), Integer.parseInt(array[8]));
                }
                if (array.length == 8) {
                    facilityMap.put(new Room(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3])
                            , Integer.parseInt(array[4]), array[5], array[6]), Integer.parseInt(array[7]));

                }
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return facilityMap;
    }

    public static <E> void writeList(List<E> eList, String pathFile, boolean append) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (E e : eList) {
                if (e instanceof Employee) {
                    bufferedWriter.write(((Employee) e).getData());
                    bufferedWriter.newLine();
                }
                if (e instanceof Customer) {
                    bufferedWriter.write(((Customer) e).getData());
                    bufferedWriter.newLine();
                }
                if (e instanceof Contract) {
                    bufferedWriter.write(((Contract) e).getData());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <E> List<E> readFileList(String pathFile) {
        List<E> eList = new ArrayList<>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        String[] array = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                if (array.length == 10) {
                    eList.add((E) new Employee(Integer.parseInt(array[0]), array[1], array[2], array[3],
                            array[4], array[5], array[6], array[7], array[8], Double.parseDouble(array[9])));
                }
                if (array.length == 9) {
                    eList.add((E) new Customer(Integer.parseInt(array[0]), array[1], array[2], array[3],
                            array[4], array[5], array[6], array[7], array[8]));
                }

            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return eList;
    }

    public static void writeFileBooking(Set<Booking> bookings, String pathFile, boolean append) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Booking booking : bookings) {
                bufferedWriter.write(booking.getData());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<Booking> readFileBooking(String pathFile) {
        Set<Booking> bookings = new TreeSet<>(new BookingComparator());
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        String[] array = null;
        List<Customer> customers = readFileList("D:\\CODEGYM\\Exercise\\bai_tap\\src\\case_study\\data\\Customer.csv");
        Map<Facility, Integer> facilityIntegerMap = readFile("D:\\CODEGYM\\Exercise\\bai_tap\\src\\case_study\\data\\Facility");
        Customer customer = null;
        Facility facility = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                for (int i = 0; i < customers.size(); i++) {
                    if (customers.get(i).getId() == Integer.parseInt(array[3])) {
                        customer = customers.get(i);
                    }
                }
                for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
                    if (entry.getKey().getIdFacility().equals(array[4])) {
                        facility = entry.getKey();
                    }
                }
                bookings.add(new Booking(Integer.parseInt(array[0]), LocalDate.parse(array[1]), LocalDate.parse(array[2]),
                        customer, facility, array[5]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public static List<Contract> readFileContract(String pathFile) {
        List<Contract> contractList=new ArrayList<>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        String[] array = null;
        List<Customer> customers = readFileList("D:\\CODEGYM\\Exercise\\bai_tap\\src\\case_study\\data\\Customer.csv");
        Set<Booking> bookings = readFileBooking("D:\\CODEGYM\\Exercise\\bai_tap\\src\\case_study\\data\\Booking.csv");
        Set<Booking> temp = ReadAndWrite.readFileBooking(PATH_FILE_TEMP);

        Customer customer = null;
        Booking booking = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                if(line.isEmpty()) continue;

                array = line.split(",");

                for (Customer value : customers) {
                    if (value.getId() == Integer.parseInt(array[4])) {
                        customer = value;
                    }
                }

                for (Booking booking1 : temp) {
                    if (booking1.getIdBooking() == Integer.parseInt(array[1])) {
                        booking = booking1;
                    }
                }

                contractList.add(new Contract(Integer.parseInt(array[0]), booking, Double.parseDouble(array[2]),
                        Double.parseDouble(array[3]), customer));

            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contractList;
    }
}


