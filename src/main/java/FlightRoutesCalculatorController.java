package src.main.java;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FlightRoutesCalculatorController {
    // Controller layer

    private FlightRoute model;
    private FlightRoutesCalculatorView view;

    private final String BaseUrl = "http://www.mocky.io/";
    private String FlightsUrl = "v2/5cebcb7d330000cc296d7772";

    public FlightRoutesCalculatorController(FlightRoute model, FlightRoutesCalculatorView view){
        this.model = model;
        this.view = view;
    }

    public void fetchData(){
        /* Workflow for http GET from API */

        JsonObject jsonObject = apiGetData();
        apiProcessGetData(jsonObject);
    }

    public JsonObject apiGetData(){
        try {
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(
                            URI.create(BaseUrl + FlightsUrl))
                    .header("accept", "application/json")
                    .build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new JsonParser().parse(response.body()).getAsJsonObject();

        } catch (IOException | InterruptedException e){
            // timeout, api address non-existent, etc. exceptions
            e.printStackTrace();
            return null;
        }
    }

    public void apiProcessGetData(JsonObject jsonObject){
        //TODO: refactor Flight to Builder pattern.

        for(Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            JsonArray flightsArray = entry.getValue().getAsJsonArray();
            String key = entry.getKey();

            for (int i = 0; i < flightsArray.size(); i++) {
                JsonObject flightDetails = flightsArray.get(i).getAsJsonObject();

                FlightRoute.Flight Flight = new FlightRoute.Flight();
                Flight.setFlightId(flightDetails.get("id").getAsInt());
                Flight.setAirline(flightDetails.get("airline").toString());
                Flight.setDepartureAirportCode(flightDetails.get("departureAirportCode").toString());
                Flight.setArrivalAirportCode(flightDetails.get("arrivalAirportCode").toString());
                Flight.setPrice(flightDetails.get("price").getAsInt());
                Flight.setIsOutBound(key.contains("outboundFlights"));

                model.add(Flight);
            }
        }
    }

    public void updateView(){
        view.printFlightRouteDetails(model);
    }

    public void showFlightRoutesView(int id){
        FlightRoute.Flight f = model.getFlightById(id);
        model.flightRoutesCalculator(f);
        view.printFlightRoute(f, model);
    }
}