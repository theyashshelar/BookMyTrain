import java.util.List;
import java.util.Scanner;

public class IRCTCAPP {

    private final Scanner sc = new Scanner(System.in);
    private final UserService userService = new UserService();
    private final BookingService bookingService = new BookingService();

    public static void main(String[] args) {
        new IRCTCAPP().start();
    }

    public void start() {
        while (true) {
            System.out.println("\n------ Welcome to IRCTC APP ------");
            if (!UserService.isLoggedIn()){
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.println("Enter Your Choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> exitApp();
                    default -> System.out.println("Invalid Choice.");
                }
            }else {
                showUserMenu();
            }
        }
    }

    public void register() {
        System.out.println("Enter Username: ");
        String userName = sc.next();

        System.out.println("Enter Password: ");
        String password = sc.next();

        System.out.println("Enter Full Name: ");
        sc.nextLine();
        String fullName = sc.nextLine();

        System.out.println("Enter Contact: ");
        String contact = sc.next();

        userService.registerUser(userName, password, fullName, contact);
    }

    public void login() {
        System.out.println("Enter Username: ");
        String userName = sc.next();

        System.out.println("Enter Password: ");
        String password = sc.next();

        userService.loginUser(userName, password);
    }

    private void showUserMenu(){
        while (userService.isLoggedIn()) {
            System.out.println("\n------ User Menu ------");
            System.out.println("1. Search Trains");
            System.out.println("2. Book Ticket");
            System.out.println("3. View My Tickets");
            System.out.println("4. Cancel Tickets");
            System.out.println("5. View All Trains");
            System.out.println("6. Logout");
            System.out.println("Enter Your Choice: ");

            int choice = sc.nextInt();

            switch (choice){
                case 1 -> searchTrain();
                case 2 -> bookTicket();
                case 3 -> viewMyTicket();
                case 4 -> cancelTicket();
                case 5 -> bookingService.listAllTrains();
                case 6 -> userService.logOutUser();
                default -> System.out.println("Invalid Choice.");
            }
        }
    }

    private void searchTrain() {
        System.out.println("Enter Source Station");
        String source = sc.next();
        System.out.println("Enter Destination Station");
        String destination = sc.next();

        List<Train> trains = bookingService.searchTrain(source, destination);
        if (trains.isEmpty()) {
            System.out.println("No Trains Found between "+source +" and "+destination);
            return;
        }
        System.out.println("Trains Found:");
        for (Train train: trains) {
            System.out.println(train );
        }

        System.out.println("Do you want to book ticket ? (yes / no): ");
        String choice = sc.next();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("Enter Train ID to book: ");
            int trainId = sc.nextInt();

            System.out.println("Enter number of seats to book:");
            int seats = sc.nextInt();

            Ticket ticket = bookingService.bookTicket(userService.getCurrentUser(), trainId, seats);
            if (ticket != null) {
                System.out.println("Booking Successful!");
                System.out.println(ticket);
            }
        }else {
            System.out.println("Returning to user menu...");
        }
    }

    private void bookTicket() {
        System.out.println("Enter Source Station");
        String source = sc.next();
        System.out.println("Enter Destination Station");
        String destination = sc.next();

        List<Train> trains = bookingService.searchTrain(source, destination);
        if (trains.isEmpty()) {
            System.out.println("No Trains available for booking");
            return;
        }
        System.out.println("Available Trains: ");
        for (Train train: trains) {
            System.out.println(train );
        }

        System.out.println("Do you want to book ticket ? (yes / no): ");
        String choice = sc.next();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("Enter Train ID to book: ");
            int trainId = sc.nextInt();
            System.out.println("Enter number of seats to book:");
            int seats = sc.nextInt();

            Ticket ticket = bookingService.bookTicket(userService.getCurrentUser(), trainId, seats);
            if (ticket != null) {
                System.out.println("Booking Successful!");
                System.out.println(ticket);
            }
        }
    }

    private void viewMyTicket() {
        List<Ticket> ticketByUser = bookingService.getTicketByUser(userService.getCurrentUser());
        if (ticketByUser.isEmpty()){
            System.out.println("No ticket Booked yet");
        }
        else {
            System.out.println("Your Tickets");
            for (Ticket ticket: ticketByUser) {
                System.out.println(ticket);
            }
        }
    }

    private void cancelTicket() {
        System.out.println("Enter Ticket ID to cancel: ");
        int ticketId = sc.nextInt();
        bookingService.cancelTicket(ticketId,userService.getCurrentUser());
    }

    private void exitApp() {
        System.out.println("Thank you For Using IRCTC App.");
        System.exit(0);
    }
}
