public class Ticket {
    private int ticketId;
    private static int counter = 1;
    private User user;
    private Train train;
    private int seatBooked;

    public Ticket(User user, Train train, int seatBooked) {
        this.ticketId = counter++;
        this.user = user;
        this.train = train;
        this.seatBooked = seatBooked;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Ticket.counter = counter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getSeatBooked() {
        return seatBooked;
    }

    public void setSeatBooked(int seatBooked) {
        this.seatBooked = seatBooked;
    }

    @Override
    public String toString() {
        return "ticketId: " + ticketId +
                " | Train: " +train.getTrainName()+" | Route: "+train.getSource()+" -> " +train.getDestination()+
                " | Seats: "+seatBooked+" | Booked By: "+user.getFullName();
    }
}
