package case_study.util;

import case_study.models.booking.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        int diff = o1.getStartDay().compareTo(o2.getStartDay());
        if (diff != 0) {
            return diff;
        }
        return Integer.compare(o1.getEndDay().compareTo(o2.getEndDay()), 0);
    }
}
