import java.util.Scanner;

/**
 * The Main Entry Point.
 * Provides a Console-based UI (Menu) for the user to interact with the system.
 * Handles input parsing and displaying the Visual Seat Map.
 */
public class Main {
    
    // Static references to Service and Scanner to be used across methods
    private static BusService service = new BusService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("   Manzil BUS - Bus Reservation System v1.0   ");
        System.out.println("============================================");

        // Infinite loop to keep the menu running until user chooses Exit
        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. View All Buses");
            System.out.println("2. Book a Ticket");
            System.out.println("3. View All Bookings (Admin)");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = 0;
            try {
                // Parse integer safely to prevent crashing on string input
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            // Route to appropriate method
            switch (choice) {
                case 1:
                    viewBuses();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.out.println("Exiting... Have a safe journey!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try 1-4.");
            }
        }
    }

    /** Displays the list of all available buses. */
    private static void viewBuses() {
        System.out.println("\n--- AVAILABLE BUSES ---");
        for (Bus b : service.getAllBuses()) {
            System.out.println(b);
        }
    }

    /** Displays history of all bookings made. */
    private static void viewBookings() {
        System.out.println("\n--- BOOKING HISTORY ---");
        for (Booking b : service.getAllBookings()) {
            System.out.println(b);
        }
    }

    /** * Handles the Booking Workflow.
     * Contains the Visual Seat Map Logic.
     */
    private static void bookTicket() {
        System.out.print("Enter Bus ID to book (e.g., B-101): ");
        String busId = scanner.nextLine();
        Bus bus = service.findBus(busId);

        if (bus == null) {
            System.out.println("Bus not found!");
            return;
        }

        // --- THE INNOVATION: VISUAL SEAT MAP ---
        System.out.println("\n--- SEAT MAP for " + bus.getBusId() + " ---");
        System.out.println("      A   B       C   D"); // Column Headers
        
        boolean[][] seats = bus.getSeats();
        
        // Loop through the 2D array to print the grid
        for (int i = 0; i < seats.length; i++) {
            System.out.print("Row " + (i + 1) + (i < 9 ? " " : "") + "| "); // Row Label
            
            for (int j = 0; j < seats[i].length; j++) {
                if (j == 2) System.out.print("    "); // Aisle space between B and C
                
                if (seats[i][j]) {
                    System.out.print("[X] "); // Already Booked
                } else {
                    System.out.print("[ ] "); // Available
                }
            }
            System.out.println(); // New line for next row
        }
        System.out.println("---------------------------");

        // Input Booking Details with validation needed on Row/Col index
        try {
            System.out.println("Enter Row Number (1-10): ");
            int row = Integer.parseInt(scanner.nextLine()) - 1; // Convert 1-based to 0-based
            
            System.out.println("Enter Column (A=1, B=2, C=3, D=4): ");
            int col = Integer.parseInt(scanner.nextLine()) - 1; // Convert 1-based to 0-based

            System.out.print("Enter Passenger Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Phone: ");
            String phone = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            // Process the booking via Service layer
            String result = service.bookTicket(busId, name, phone, age, row, col);
            System.out.println("\n>> " + result);
            
        } catch (Exception e) {
            System.out.println("Error processing input. Please try again.");
        }
    }
}