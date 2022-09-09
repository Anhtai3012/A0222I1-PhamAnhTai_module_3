package java_basic.manager_resort.models;

import java.time.LocalDate;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;


public class Booking implements Comparable<Booking> {
    public String idPerson;
    public String idFacility;
    public String bookingCode;
    public LocalDate startDate;
    public LocalDate endDate;

    public Booking(String idPerson, String idFacility, String bookingCode, LocalDate startDate, LocalDate endDate) {
        this.idPerson = idPerson;
        this.idFacility = idFacility;
        this.bookingCode = bookingCode;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static String getPropertiesBooking() {
        return "Start Date,End Date";
    }

    public int getDateToUse() {
        return (int) DAYS.between(startDate, endDate);
    }

    @Override
    public int compareTo(Booking o) {
        int diff = startDate.compareTo(o.startDate);
        if (diff != 0) return diff;
        return endDate.compareTo(o.endDate);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Booking)) return false;
        Booking booking = (Booking) object;
        return Objects.equals(idPerson, booking.idPerson) &&
                Objects.equals(idFacility, booking.idFacility) &&
                Objects.equals(bookingCode, booking.bookingCode);
    }

    @Override
    public int hashCode() {
        return bookingCode.hashCode();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idPerson='" + idPerson + '\'' +
                ", idFacility='" + idFacility + '\'' +
                ", bookingCode='" + bookingCode + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
