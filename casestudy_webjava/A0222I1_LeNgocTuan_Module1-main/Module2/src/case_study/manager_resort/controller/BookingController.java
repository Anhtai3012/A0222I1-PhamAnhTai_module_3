package java_basic.manager_resort.controller;

import java_basic.manager_resort.models.Booking;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class BookingController implements Comparator<Booking> {
    static Set<Booking> bookings;

    static {
        bookings = new TreeSet<>();
    }

    public void addNew(Booking booking) {
        if (isExist(booking)) return;
        bookings.add(booking);
    }

    public boolean isExist(Booking booking) {
        for (Booking book : bookings) {
            if (book.bookingCode.equalsIgnoreCase(booking.bookingCode)) return true;
        }
        return false;
    }

    public void remove(Booking booking) {
        bookings.remove(booking);
    }

    public Booking searchByIdBooking(String idBooking) {
        for (Booking booking : bookings) {
            if (booking.bookingCode.equalsIgnoreCase(idBooking)) return booking;
        }
        return null;
    }

    public void displaySet() {
        bookings.forEach(x -> System.out.println(x.toString()));
    }

    @Override
    public int compare(Booking o1, Booking o2) {
        if (o1.startDate.compareTo(o2.startDate) > 0) return 1;
        if (o1.startDate.compareTo(o2.startDate) < 0) return -1;
        return Integer.compare(o1.endDate.compareTo(o2.endDate), 0);
    }
}
