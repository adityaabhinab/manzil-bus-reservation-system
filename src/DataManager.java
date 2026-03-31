import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to handle File I/O operations.
 * Uses Java Object Serialization to save and load data structures.
 * This ensures data persists even after the application closes.
 */
public class DataManager {

    /**
     * Generic method to save any List object to a file.
     * parameter - data The List (of Buses or Bookings) to save.
     * parameter - filename The name of the file (e.g., "buses.dat").
     */
    public static void saveData(List<?> data, String filename) {
        // Try-with-resources to automatically close streams
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/" + filename))) {
            oos.writeObject(data);
            System.out.println(">> Data saved to " + filename);
        } catch (IOException e) {
            System.out.println(">> Error saving data: " + e.getMessage());
        }
    }

    /**
     * Generic method to load data from a file.
     * parameter -  filename The file to read from.
     * return The list of objects found, or an empty list if file doesn't exist.
     */
    @SuppressWarnings("unchecked") // <--- ADDED THIS LINE TO FIX THE WARNING
    public static <T> List<T> loadData(String filename) {
        File file = new File("data/" + filename);
        
        // Return empty list if this is the first run (file doesn't exist yet)
        if (!file.exists()) return new ArrayList<>(); 

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<T>) ois.readObject(); // Warning is now suppressed
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); // Return empty list on error
        }
    }
}