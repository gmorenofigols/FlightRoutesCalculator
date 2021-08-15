package src.main.java;

import java.io.IOException;

public class MVCPatternDemo {
    public static void main(String[] arg) throws IOException, InterruptedException {
        FlightRoute model = retrieveFlightRouteFromDb();
        FlightRoutesCalculatorView view = new FlightRoutesCalculatorView();
        FlightRoutesCalculatorController controller = new FlightRoutesCalculatorController(model, view);

        String mockupUrl = "https://run.mocky.io/v3/1d769332-43ce-410f-8a68-43fd9782dd87";  // extra added API data.

        controller.fetchData("");
        // controller.fetchData(mockupUrl);
        controller.showAllFlightsView();
        // controller.showFlightRoutesView('a');

        int i;
        for(i=1;i<6;i++){
            controller.showFlightRoutesView(i);
        }
    }

    private static FlightRoute retrieveFlightRouteFromDb(){
        return new FlightRoute();
    }
}