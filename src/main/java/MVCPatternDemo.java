package java;

public class MVCPatternDemo {
    public static void main(String[] arg){
        FlightRoutesCalculator model = retrieveFlightRoutesCalculatorFromDb();
        FlightRoutesCalculatorView view = new FlightRoutesCalculatorView();
        FlightRoutesCalculatorController controller = new FlightRoutesCalculatorController(model, view);

        controller.updateView();
        controller.setAirline('Travelling');
        controller.updateView();
    }

    private static FlightRoutesCalculator retrieveFlightRoutesCalculatorFromDb(){
        FlightRoutesCalculator flight = new FlightRoutesCalculator();
        flight.setFlightId(1),
        flight.setAirline('Vueling');
        flight.setPrice(15);
    }
}