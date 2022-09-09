package case_study.service.control;

import case_study.models.booking.Booking;
import java_basic.manager_book.Book;

import java.util.ArrayList;
import java.util.List;

public class TempClass {
    static List<Booking> tempList;

   public TempClass () {
       tempList = new ArrayList<>();
   }

    public void addTemp(Booking booking) {
        tempList.add(booking);
    }

    public Booking searchById(int id) {
        for (Booking book : tempList) {
            if (book.getIdBooking() == id) return book;
        }
        return null;
    }

}
