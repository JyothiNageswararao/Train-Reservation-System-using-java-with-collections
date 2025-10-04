import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TrainReservationSystem {

    // Helper method to find train by number
    private static Train getTrainByNumber(List<Train> trains, int trainNumber) {
        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                return train;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Train> trains = new ArrayList<>();

        // Sample trains
        trains.add(new Train(101, "Express Train", "Hyderabad", "Secunderabad", 5));
        trains.add(new Train(102, "Fast Track", "Secunderabad", "Tirupati", 9));
        trains.add(new Train(103, "Super Express", "Delhi", "Hyderabad", 3));

        while (true) {
            System.out.println("\n======== Train Reservation System ==========");
            System.out.println("1. View Available Trains");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // consume invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable trains:");
                    for (Train train : trains) {
                        System.out.println(train.getTrainNumber() + " - " + train.getTrainName()
                                + " (" + train.getSource() + " to " + train.getDestination()
                                + ") | Available seats: " + train.getAvailableSeats());
                    }
                    break;

                case 2:
                    System.out.print("\nEnter train number to book ticket: ");
                    int trainNumber = sc.nextInt();
                    sc.nextLine();
                    Train selectedTrain = getTrainByNumber(trains, trainNumber);

                    if (selectedTrain != null) {
                        System.out.print("Enter passenger name: ");
                        String passengerName = sc.nextLine();
                        selectedTrain.bookTicket(passengerName);
                    } else {
                        System.out.println("Invalid train number");
                    }
                    break;

                case 3:
                    System.out.print("\nEnter train number to cancel ticket: ");
                    int cancelTrainNumber = sc.nextInt();
                    sc.nextLine();
                    Train cancelTrain = getTrainByNumber(trains, cancelTrainNumber);

                    if (cancelTrain != null) {
                        System.out.print("Enter passenger name to cancel: ");
                        String cancelName = sc.nextLine();
                        cancelTrain.cancelTicket(cancelName);
                    } else {
                        System.out.println("Invalid train number");
                    }
                    break;

                case 4:
                    System.out.print("\nEnter train number to view details: ");
                    int detailsTrainNumber = sc.nextInt();
                    sc.nextLine();
                    Train detailsTrain = getTrainByNumber(trains, detailsTrainNumber);

                    if (detailsTrain != null) {
                        detailsTrain.showBookingDetails();
                    } else {
                        System.out.println("Invalid train number");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

