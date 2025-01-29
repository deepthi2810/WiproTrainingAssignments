package hotel;

import java.util.Date;

public class Booking {
    private int bookingId;
    private Customer customer;
    private Room room;
    private Date checkInDate;
    private Date checkOutDate;

    public Booking(int bookingId, Customer customer, Room room, Date checkInDate, Date checkOutDate) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        room.setBooked(true); 
    }

    public int getBookingId() {
        return bookingId;
    }

    public void checkout() {
        room.setBooked(false); 
    }

    @Override
    public String toString() {
        return "Booking [ID=" + bookingId + ", Customer=" + customer.getName() + ", Room=" + room.getRoomNumber() +
                ", Check-in=" + checkInDate + ", Check-out=" + checkOutDate + "]";
    }
}
