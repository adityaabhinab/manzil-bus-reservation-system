import java.io.Serializable;

/**
 * Represents a Bus in the fleet.
 * Implements Serializable to allow saving the object state to a file.
 * This class uses a 2D boolean array to visually map the seating arrangement.
 */
public class Bus implements Serializable {
    
    // --- Fields ---
    private String busId;       // Unique identifier (e.g., "B-101")
    private String source;      // Departure city
    private String destination; // Arrival city
    private double price;       // Ticket cost per seat
    
    /** * The Seating Grid: 
     * rows = physical rows in the bus
     * cols = seats per row (A, B, C, D)
     * true = booked, false = available
     */
    private boolean[][] seats; 

    /**
     * Constructor to initialize a new Bus.
     * Sets up a standard 10-row, 4-column layout (40 seats).
     * parameter - busId Unique ID
     * parameter - source Start location
     * parameter - destination End location
     * parameter price - Ticket price
     */
    public Bus(String busId, String source, String destination, double price) {
        this.busId = busId;
        this.source = source;
        this.destination = destination;
        this.price = price;
        this.seats = new boolean[10][4]; // Initializes all to false (empty)
    }

    // --- Getters ---
    public String getBusId() { return busId; }
    
    /** Returns a formatted route string "Source -> Destination" */
    public String getRoute() { return source + " -> " + destination; }
    
    public double getPrice() { return price; }
    
    public boolean[][] getSeats() { return seats; }

    /**
     * Checks if a specific seat is already taken.
     * parameter - row Row index (0-9)
     * parameter - col Column index (0-3)
     * return true if booked, false if empty
     */
    public boolean isSeatBooked(int row, int col) {
        return seats[row][col];
    }

    /**
     * Marks a specific seat as booked.
     * parameter - row Row index
     * parameter - col Column index
     */
    public void bookSeat(int row, int col) {
        this.seats[row][col] = true;
    }

    //Override
    public String toString() {
        return "Bus [" + busId + "] " + source + " to " + destination + " ($" + price + ")";
    }
}