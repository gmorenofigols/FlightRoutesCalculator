package src.main.java;

public class FlightRoutesCalculatorView {
    // View layer

    public void printFlightRouteDetails(FlightRoute flightRoute){
        flightRoute.print("all");
    }

    public void printFlightRoute(FlightRoute.Flight f, FlightRoute flightRoute){
        System.out.println("Flight origin:");
        System.out.println(f.toString());
        System.out.println("With return options: ");
        flightRoute.printCalculatorResult();
    }
}