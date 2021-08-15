package src.main.java;

import com.google.gson.JsonObject;

public class MVCPatternDemo {
    public static void main(String[] arg){
        FlightRoute model = retrieveFlightRouteFromDb();
        FlightRoutesCalculatorView view = new FlightRoutesCalculatorView();
        FlightRoutesCalculatorController controller = new FlightRoutesCalculatorController(model, view);

        controller.updateView();
        controller.fetchData();
        // controller.updateView();
        // model.calculations();
        controller.showFlightRoutesView(1);
    }

    private static FlightRoute retrieveFlightRouteFromDb(){
        return new FlightRoute();
    }
}