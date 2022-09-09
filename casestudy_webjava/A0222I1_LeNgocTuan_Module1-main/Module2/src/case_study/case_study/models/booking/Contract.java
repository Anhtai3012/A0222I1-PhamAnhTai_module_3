package case_study.models.booking;

import case_study.models.Person.Customer;

public class Contract {
    private int idContract;
    private Booking idBooking;
    private double depositMoney;
    private double payments;
    private Customer idCustomer;

    public Contract() {
    }

    public Contract(int idContract, Booking idBooking, double depositMoney, double payments, Customer idCustomer) {
        this.idContract = idContract;
        this.idBooking = idBooking;
        this.depositMoney = depositMoney;
        this.payments = payments;
        this.idCustomer = idCustomer;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public Booking getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Booking idBooking) {
        this.idBooking = idBooking;
    }

    public double getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(double depositMoney) {
        this.depositMoney = depositMoney;
    }

    public double getPayments() {
        return payments;
    }

    public void setPayments(double payments) {
        this.payments = payments;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getData() {
        return getIdContract() + "," + getIdBooking().getIdBooking() + "," + getDepositMoney() +
                "," + getPayments() + "," + getIdCustomer().getId();
    }

    @Override
    public String toString() {
        return "Contract{" +
                "idContract=" + idContract +
                ", idBooking=" + idBooking.getIdBooking() +
                ", depositMoney=" + depositMoney +
                ", payments=" + payments +
                ", idCustomer=" + idCustomer.getId() +
                '}';
    }
}
