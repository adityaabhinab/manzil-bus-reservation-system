import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a confirmed Ticket/Booking.
 * Stores the relationship between a Bus, a Passenger, and a specific Seat.
 */
public class Booking implements Serializable {
    private String bookingId;
    private String busId;
    private Passenger passenger;
    private int seatRow;
    private int seatCol;
    private Date bookingDate;

    /**
     * Creates a new booking record.
     * Generates a unique Ticket ID based on the current timestamp.
     * parameter - busId The ID of the bus being booked
     * parameter - passenger The passenger object
     * parameter - row Seat row index
     * parameter - col Seat column index
     */
    public Booking(String busId, Passenger passenger, int row, int col) {
        this.bookingId = "TKT-" + System.currentTimeMillis(); // Generate unique ID
        this.busId = busId;
        this.passenger = passenger;
        this.seatRow = row;
        this.seatCol = col;
        this.bookingDate = new Date(); // Timestamp for right now
    }

    public Date getBookingDate() { return bookingDate; }

    //Override
    public String toString() {
        // Converts column index 0 to 'A', 1 to 'B', etc. for display
        char colChar = (char) ('A' + seatCol); 
        
        // Format date (e.g., "Mon Nov 24 10:30:00 2025")
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");
        String dateStr = sdf.format(bookingDate);
        
        return "Ticket: " + bookingId + " | Date: " + dateStr + 
               " | Bus: " + busId + 
               " | Seat: " + (seatRow + 1) + colChar + 
               " | Passenger: " + passenger.toString();
    }
}