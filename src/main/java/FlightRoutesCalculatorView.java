package src.main.java;

import java.util.LinkedList;

public class FlightRoutesCalculatorView {
    // View layer

    public void printFlightRouteDetails(FlightRoute flightRoute){
        flightRoute.print("all");
    }

    public void printFlightRoute(FlightRoute.Flight f, LinkedList<FlightRoute.Flight> results){
        System.out.println("\nFlight origin:");
        System.out.println(f.toString());
        System.out.println("With return options: ");

        if(results.isEmpty()){
            System.out.println("Such empty :(");
        }else{
            for (FlightRoute.Flight r : results) {
                System.out.println(r.toString());
            }
        }
    }
}