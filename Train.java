import java.util.ArrayList;
import java.util.List;

public class Train {
    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private int totalSeats;
    private List<String> bookedPassengers;

    // Constructor
    public Train(int trainNumber, String trainName, String source, String destination, int totalSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.bookedPassengers = new ArrayList<>();
    }

    // Getters
    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return totalSeats - bookedPassengers.size();
    }

    // Book ticket
    public boolean bookTicket(String passengerName) {
        if (getAvailableSeats() > 0) {
            bookedPassengers.add(passengerName);
            System.out.println("Ticket booked for " + passengerName + " on train " + trainNumber);
            return true;
        } else {
            System.out.println("No seats available on this train...");
            return false;
        }
    }

    // Cancel ticket
    public boolean cancelTicket(String passengerName) {
        if (bookedPassengers.remove(passengerName)) {
            System.out.println("Ticket cancelled for " + passengerName);
            return true;
        } else {
            System.out.println("No booking found for " + passengerName);
            return false;
        }
    }

    // Show booking details
    public void showBookingDetails() {
        System.out.println("\nTrain: " + trainName + " (Train No: " + trainNumber + ")");
        System.out.println("Route: " + source + " --> " + destination);
        System.out.println("Total seats: " + totalSeats + " | Available seats: " + getAvailableSeats());
        System.out.println("Booked passengers: " + bookedPassengers);
    }
}
