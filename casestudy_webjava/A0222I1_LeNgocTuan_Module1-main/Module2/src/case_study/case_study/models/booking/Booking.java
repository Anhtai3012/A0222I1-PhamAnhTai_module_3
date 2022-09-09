package case_study.models.booking;

import case_study.models.Person.Customer;
import case_study.models.facility.Facility;
import case_study.util.BookingComparator;
import case_study.util.Format;


import java.time.LocalDate;
import java.util.Objects;


public class Booking {
    private int idBooking;
    private LocalDate startDay;
    private LocalDate endDay;
    private Customer idCustomer;
    private Facility idFacility;
    private String serviceType;

    public Booking() {
    }

    public Booking(int idBooking, LocalDate startDay, LocalDate endDay, Customer idCustomer, Facility idFacility, String serviceType) {
        this.idBooking = idBooking;
        this.startDay = startDay;
        this.endDay = endDay;
        this.idCustomer = idCustomer;
        this.idFacility = idFacility;
        this.serviceType = serviceType;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Facility getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(Facility idFacility) {
        this.idFacility = idFacility;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) obj;
        return this.idBooking == booking.idBooking &&
                Objects.equals(idFacility, booking.idFacility) &&
                Objects.equals(serviceType, booking.serviceType) &&
                Objects.equals(startDay, booking.startDay) &&
                Objects.equals(endDay, booking.endDay);
    }

    public String getData() {
        return getIdBooking() + "," + getStartDay() + "," + getEndDay() +
                "," + getIdCustomer().getId() + "," + getIdFacility().getIdFacility() + "," + getServiceType();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking='" + idBooking + '\'' +
                ", startDay=" + Format.getDateFormatter(startDay) +
                ", endDay=" + Format.getDateFormatter(endDay) +
                ", idCustomer=" + idCustomer.getId() +
                ", idFacility=" + idFacility.getIdFacility() +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}
