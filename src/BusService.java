import java.util.List;

/**
 * Service Layer: Handles the business logic of the application.
 * Manages the lists of Buses and Bookings and communicates with DataManager.
 */
public class BusService {
    private List<Bus> buses;
    private List<Booking> bookings;

    /**
     * Constructor: Initializes lists and attempts to load existing data.
     * If no data exists, it seeds the system with dummy buses.
     */
    public BusService() {
        // Load data on startup
        this.buses = DataManager.loadData("buses.dat");
        this.bookings = DataManager.loadData("bookings.dat");

        // Seed some dummy data if the bus list is empty (First run scenario)
        if (buses.isEmpty()) {
            buses.add(new Bus("B-101", "New York", "Boston", 45.00));
            buses.add(new Bus("B-102", "New York", "Washington", 50.00));
            buses.add(new Bus("B-103", "Boston", "Chicago", 120.00));
            saveAll(); // Save immediately so data exists for next time
        }
    }

    // --- Accessor Methods ---
    public List<Bus> getAllBuses() { return buses; }
    public List<Booking> getAllBookings() { return bookings; }

    /**
     * Helper method to find a bus object by its ID string.
     */
    public Bus findBus(String busId) {
        for (Bus b : buses) {
            if (b.getBusId().equalsIgnoreCase(busId)) return b;
        }
        return null;
    }

    /**
     * Core Logic: Processes a ticket booking.
     * 1. Validates Bus ID.
     * 2. Checks if seat is free.
     * 3. Updates bus state, creates booking, and saves to file.
     */
    public String bookTicket(String busId, String pName, String pPhone, int pAge, int row, int col) {
        Bus bus = findBus(busId);
        
        if (bus == null) return "Bus not found.";
        
        // Validation: Prevent double booking
        if (bus.isSeatBooked(row, col)) return "Seat already booked!";

        // 1. Mark seat as booked in the Bus object
        bus.bookSeat(row, col);

        // 2. Create the Booking Record
        Passenger p = new Passenger(pName, pPhone, pAge);
        Booking newBooking = new Booking(busId, p, row, col);
        bookings.add(newBooking);

        // 3. Save Changes to disk immediately
        saveAll();

        return "SUCCESS! " + newBooking.toString();
    }

    /** Helper to save both lists to files. */
    public void saveAll() {
        DataManager.saveData(buses, "buses.dat");
        DataManager.saveData(bookings, "bookings.dat");
    }
}