import java.util.Scanner;

public class AirlineReservationSystem {
    // Define variables to keep track of seat availability
private static boolean[] firstClassSeats = new boolean[5];
private static boolean[] economyClassSeats = new boolean[5];

// Define variables for passenger information
private static String[] passengerNames = new String[10];
private static String[] passengerClasses = new String[10];
private static int[] passengerSeatNumbers = new int[10];
private static int passengerCount = 0;

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int choice = 0;
    while (choice != 3) {
        System.out.println("Welcome to the Airline Reservation System");
        System.out.println("1. Reserve a seat");
        System.out.println("2. Cancel a reservation");
        System.out.println("3. Quit");
        System.out.print("Enter your choice: ");
        choice = input.nextInt();
        switch (choice) {
            case 1:
                reserveSeat();
                break;
            case 2:
                cancelReservation();
                System.out.println("Thank you for using the Airline Reservation System");
                
                break;
            case 3:
                System.out.println("Thank you for using the Airline Reservation System");
                break;
            default:
                System.out.println("Invalid choice, please try again");
                break;
        }
    }
}

// Method to reserve a seat
public static void reserveSeat() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter passenger name: ");
    String name = input.nextLine();
    System.out.println("Select seat class: ");
    System.out.println("1. First class");
    System.out.println("2. Economy class");
    System.out.print("Enter your choice: ");
    int classChoice = input.nextInt();
    int seatNumber = 0;
    boolean[] seats;
    String seatClass;
    if (classChoice == 1) {
        seats = firstClassSeats;
        seatClass = "First class";
    } else {
        seats = economyClassSeats;
        seatClass = "Economy class";
    }
    // Check if there are any available seats
    boolean seatFound = false;
    for (int i = 0; i < seats.length; i++) {
        if (!seats[i]) {
            seatNumber = i + 1;
            seats[i] = true;
            seatFound = true;
            break;
        }
    }
    if (seatFound) {
        System.out.println("Seat reserved in " + seatClass + " with seat number " + seatNumber);
        passengerNames[passengerCount] = name;
        passengerClasses[passengerCount] = seatClass;
        passengerSeatNumbers[passengerCount] = seatNumber;
        passengerCount++;
    } else {
        System.out.println("Sorry, no seats available in " + seatClass);
    }
}

// Method to cancel a reservation
public static void cancelReservation() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter passenger name: ");
    String name = input.nextLine();
    int index = -1;
    for (int i = 0; i < passengerCount; i++) {
        if (passengerNames[i].equalsIgnoreCase(name)) {
            index = i;
            break;
        }
    }
    if (index == -1) {
        System.out.println("Passenger " + name + " not found");
    } else {
        String seatClass = passengerClasses[index];
        int seatNumber = passengerSeatNumbers[index];
        if (seatClass.equalsIgnoreCase("First class")) {
            firstClassSeats[seatNumber - 1] = false;
        }
}}}
