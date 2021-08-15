package src.main.java;

import java.util.Iterator;
import java.util.LinkedList;

public class FlightRoute {
    // TODO: Implement sort by Price.

    private LinkedList<Flight> AllFlights = new LinkedList<>();
    private LinkedList<Flight> InBoundFlights = new LinkedList<>();
    private LinkedList<Flight> OutBoundFlights = new LinkedList<>();
    private LinkedList<Flight> results = new LinkedList<>();

    public FlightRoute() {
    }

    public void add(Flight flight){
        AllFlights.add(flight);

        if(flight.isOutBound)
            OutBoundFlights.add(flight);
        else
            InBoundFlights.add(flight);
    }

    public void calculations(){
        /* takes into consideration only same airport destinations, not countries (requirement!).
           TODO: check when airline does not match. */

        for(Flight o: OutBoundFlights){
            LinkedList<Flight> f = new LinkedList<>();
            for(Flight i: InBoundFlights){
                if(o.getAirline().equalsIgnoreCase(i.getAirline())){
                    // checks departure locations are the same
                    if(o.getDepartureAirportCode().equalsIgnoreCase(i.getArrivalAirportCode()) &&
                            o.getArrivalAirportCode().equalsIgnoreCase(i.getDepartureAirportCode()))
                    {
                        f.add(i);
                    }
                }
            }
            System.out.println("With " + o.toString() + " " + f);
        }
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

    public void flightRoutesCalculator(Flight o){
        /*  Calculates possible flight routes from a flight.

            Takes into consideration only same airport destinations, not countries (requirement!).

            TODO: check when airline does not match.
            TODO: make it bidirectional for outbound & inbound flights.
        */

        LinkedList<Flight> f = new LinkedList<>();
        for(Flight i: InBoundFlights){
            if(o.getAirline().equalsIgnoreCase(i.getAirline())){
                // checks departure locations are the same
                if(o.getDepartureAirportCode().equalsIgnoreCase(i.getArrivalAirportCode()) &&
                        o.getArrivalAirportCode().equalsIgnoreCase(i.getDepartureAirportCode()))
                {
                    f.add(i);
                }
            }
        }
        results = f;
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

        while(i.hasNext()) {
            Flight f = i.next();
            System.out.println(f.toString());
        }

    }

    public void printCalculatorResult(){
        for (Flight f : results) {
            System.out.println(f.toString());
        }
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
