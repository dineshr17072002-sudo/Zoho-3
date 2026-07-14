package RailwayTicket;

public class Passenger {
    String Name;
    int Age;
    String Gender;
    String BerthPref;
    String AllocatedBerth;
    String TicketId;

    public Passenger(String name, int age, String gender, String berthPref, String allocatedBer, String ticketId) {
        Name = name;
        this.Age = age;
        this.Gender = gender;
        BerthPref = berthPref;
        AllocatedBerth = allocatedBer;
        TicketId = ticketId;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "Name='" + Name + '\'' +
                ", age=" + Age +
                ", gender='" + Gender + '\'' +
                ", BerthPref='" + BerthPref + '\'' +
                ", AllocatedBer='" + AllocatedBerth + '\'' +
                ", TicketId='" + TicketId + '\'' +
                '}';
    }
}
