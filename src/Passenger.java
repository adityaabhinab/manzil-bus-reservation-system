import java.io.Serializable;

/**
 * Represents a passenger booking a ticket.
 * Simple POJO (Plain Old Java Object) to store personal details.
 */
public class Passenger implements Serializable {
    private String name;
    private String phone;
    private int age;

    /**
     * Constructor for a new Passenger.
     * parameter -  name Full name
     * parameter -  phone Contact number
     * parameter -  age Age of passenger
     */
    public Passenger(String name, String phone, int age) {
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    public String getName() { return name; }
    
    public String getPhone() { return phone; } // Now the field is used!
    
    public int getAge() { return age; }

    //Override
    public String toString() {
        // Updated to include phone number in the printout
        return name + " [Ph: " + phone + "] (" + age + "yrs)";
    }
}