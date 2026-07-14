package RailwayTicket;
import java.util.*;
public class TicketSystem {

    private final ArrayList<String>availableBerth=new ArrayList<>(Arrays.asList("U","L","M"));

    private final Queue<Passenger>racQueue=new LinkedList<>();

    private final Queue<Passenger>WLQueue=new LinkedList<>();

    private final List<Passenger>confirmList=new ArrayList<>();

    int ticketCounter=1;

    public void bookTicket( String Name, int age, String gender, String BerthPref){

        String ticketId="T"+ticketCounter++;
        Passenger passenger;

        if(!availableBerth.isEmpty()){

            String allocateBer= allocatedBer(age, gender,BerthPref);
            passenger=new Passenger(Name,age,gender, BerthPref,allocateBer,ticketId);

            availableBerth.remove(allocateBer);
            confirmList.add(passenger);
            System.out.println("TICKET IS READY:"+passenger);

        } else if (racQueue.size()<1) {
            passenger=new Passenger(Name,age,gender,BerthPref,"RAC",ticketId );
            racQueue.offer(passenger);
            System.out.println("TICKET IN RAC:"+passenger);

        }else if (WLQueue.size()<1) {
            passenger=new Passenger(Name,age,gender,BerthPref,"WL",ticketId );
            WLQueue.offer(passenger);
            System.out.println("TICKET IN WL:"+passenger);

        }
        System.out.println("NO TICKET");
    }

    public String allocatedBer(int age,String gender,String pefernce) {
        if (age > 60 || gender.equalsIgnoreCase("female") && availableBerth.contains("L")) {
            return "L";
        }

    if (availableBerth.contains(pefernce)){
    return pefernce;
}
    return availableBerth.get(0);
    }
    public void cancelTicket(String ticketId){
        Optional<Passenger>passOpt=confirmList.stream().filter(p->p.TicketId.
                equals(ticketId)).findFirst();

        if (passOpt.isPresent()){
            Passenger passenger=passOpt.get();
            confirmList.remove(passenger);
            availableBerth.add(passenger.AllocatedBerth);

            if(!racQueue.isEmpty()){
                Passenger racp=racQueue.poll();
                String allcatedBerth=allocatedBer(racp.Age,racp.Gender,racp.AllocatedBerth);
                racp.AllocatedBerth=allcatedBerth;
                confirmList.add(racp);
                availableBerth.remove(allcatedBerth);
                System.out.println("RAC MOVED TO CONFIRMED:"+  passenger);

            }
            if (!WLQueue.isEmpty()) {
                Passenger waitingPassenger = WLQueue.poll();
                racQueue.offer(waitingPassenger);
                waitingPassenger.AllocatedBerth = "RAC";
                System.out.println("Waiting list ticket moved to RAC: " + waitingPassenger);
            }
            System.out.println("Ticket cancelled successfully for ID: " + ticketId);

        }else {
            System.out.println("No ticket found with ID: " + ticketId);
        }
    }
    // Printing confirmed tickets

    public void printBookedTickets() {
        if (confirmList.isEmpty()) {
            System.out.println("No confirmed tickets.");
        } else {
            System.out.println("Confirmed Tickets:");
            for (Passenger p :confirmList) {
                System.out.println(p);
            }
        }
    }

    //VIEW WL TICKET

    public void printWLTickets() {
        if (WLQueue.isEmpty()) {
            System.out.println("No WL tickets.");
        } else {
            System.out.println("WL  Tickets:");
            for (Passenger p :WLQueue) {
                System.out.println(p);
            }
        }
    }


    //VIEW RAC TICKET

    public void printRacTickets() {
        if (racQueue.isEmpty()) {
            System.out.println("No rac tickets.");
        } else {
            System.out.println("RAC Tickets:");
            for (Passenger p :racQueue) {
                System.out.println(p);
            }
        }
    }


    // Printing available tickets
    public void printAvailableTickets() {
        System.out.println("Available Berths: " +availableBerth.size());
        System.out.println("Available RAC Tickets: " + (1 - racQueue.size()));
        System.out.println("Available Waiting List Tickets: " + (1 - WLQueue.size()));
    }


}
