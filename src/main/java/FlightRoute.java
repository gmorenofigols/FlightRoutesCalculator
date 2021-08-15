package src.main.java;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class FlightRoute {
    // TODO: Implement sort by Price.

    private LinkedList<Flight> AllFlights = new LinkedList<>();
    private LinkedList<Flight> InBoundFlights = new LinkedList<>();
    private LinkedList<Flight> OutBoundFlights = new LinkedList<>();

    public FlightRoute() {
    }

    public void add(Flight flight){
        AllFlights.add(flight);

        if(flight.isOutBound)
            OutBoundFlights.add(flight);
        else
            InBoundFlights.add(flight);
    }

    public Flight getFlightById(int id){
        // TODO: fix return null.

        Iterator<Flight> i = OutBoundFlights.iterator();
        while(i.hasNext()) {
            Flight f = i.next();
            if(f.getFlightId() == id){
                return f;
            }
        }
        return null;
    }


    public void sortByPrice(LinkedList<Flight> list){
        /* Sorts from lowest to highest price from Flight.Price. */

        list.sort(Comparator.comparingInt(Flight::getPrice));
    }

    public void print(String kind){
        /* Prints linkedLists according to kind: [all | outbound | inbound] */

        Iterator<Flight> i;
        if(kind.equalsIgnoreCase("all"))
            i = AllFlights.iterator();
        else if(kind.equalsIgnoreCase("outbound"))
            i = OutBoundFlights.iterator();
        else
            i = InBoundFlights.iterator();

        System.out.println();
        while(i.hasNext()) {
            Flight f = i.next();
            System.out.println(f.toString());
        }

    }

    public LinkedList<Flight> getAllFlights() {
        return AllFlights;
    }

    public LinkedList<Flight> getOutBoundFlights() {
        return OutBoundFlights;
    }

    public LinkedList<Flight> getInBoundFlights() {
        return InBoundFlights;
    }

    public static class Flight {
        //TODO: refactor to Builder

        private int FlightId;
        private String Airline;
        private String DepartureAirportCode;
        private String ArrivalAirportCode;
        private int Price;
        private boolean isOutBound;

        // getters & setters...
        public int getFlightId() {
            return FlightId;
        }

        public void setFlightId(int flightId) {
            FlightId = flightId;
        }

        public String getAirline() {
            return Airline;
        }

        public void setAirline(String airline) {
            Airline = airline;
        }

        public String getDepartureAirportCode() {
            return DepartureAirportCode;
        }

        public void setDepartureAirportCode(String departureAirportCode) {
            DepartureAirportCode = departureAirportCode;
        }

        public String getArrivalAirportCode() {
            return ArrivalAirportCode;
        }

        public void setArrivalAirportCode(String arrivalAirportCode) {
            ArrivalAirportCode = arrivalAirportCode;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int price) {
            Price = price;
        }

        public boolean isOutBound() {
            return isOutBound;
        }

        public void setIsOutBound(boolean outbound) {
            isOutBound = outbound;
        }
        // ...getters & setters

        @Override
        public String toString(){
            return "Id: " + getFlightId() + " - " + getAirline() + " From: " + getDepartureAirportCode()
                    + " To: " + getArrivalAirportCode() + " Price: " + getPrice() + " Outbound: " + isOutBound();
        }
    }
}
