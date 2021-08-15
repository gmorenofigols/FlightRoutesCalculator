package src.main.java;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedList;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FlightRoutesCalculatorController {
    // Controller layer

    private FlightRoute model;
    private FlightRoutesCalculatorView view;
    private LinkedList<FlightRoute.Flight> results;

    private final String BaseUrl = "http://www.mocky.io/";
    private String FlightsUrl = "v2/5cebcb7d330000cc296d7772";

    public FlightRoutesCalculatorController(FlightRoute model, FlightRoutesCalculatorView view){
        this.model = model;
        this.view = view;
    }

    public void fetchData(String mockupAPI) throws IOException, InterruptedException {
        /* Workflow for http GET from API

           Accepts more Url or default url.
        */

        if(mockupAPI.isEmpty()){
            JsonObject jsonObject = apiGetData(BaseUrl + FlightsUrl);
            apiProcessGetData(jsonObject);
        }else{
            JsonObject jsonObject = apiGetData(mockupAPI);
            apiProcessGetData(jsonObject);
        }
    }

    public JsonObject apiGetData(String apiUrl) throws IOException, InterruptedException {
        try {
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(
                            URI.create(apiUrl))
                    .header("accept", "application/json")
                    .build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new JsonParser().parse(response.body()).getAsJsonObject();

        } catch (IllegalStateException e){
            // timeout, api address non-existent, etc. exceptions
            throw new IllegalStateException("Request empty");
        } catch (IOException e){
            throw new IOException("I/O error when sending or receiving");
        } catch (InterruptedException e){
            throw new InterruptedException("Operation Interrupted");
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
                try{
                    Flight.setFlightId(flightDetails.get("id").getAsInt());
                    Flight.setAirline(flightDetails.get("airline").toString());
                    Flight.setDepartureAirportCode(flightDetails.get("departureAirportCode").toString());
                    Flight.setArrivalAirportCode(flightDetails.get("arrivalAirportCode").toString());
                    Flight.setPrice(flightDetails.get("price").getAsInt());
                    Flight.setIsOutBound(key.contains("outboundFlights"));
                    model.add(Flight);
                }catch (NullPointerException e){
                    throw new NullPointerException("API Field does not exist");
                }
            }
        }
    }

    public void flightRoutesCalculator(FlightRoute.Flight o){
        /*  Calculates possible flight routes from a flight.

            Takes into consideration only same airport destinations, not countries (requirement!).

            TODO: make it bidirectional from outbound & inbound flights.
        */

        LinkedList<FlightRoute.Flight> flightMatchingAirlines = new LinkedList<>();
        LinkedList<FlightRoute.Flight> flightNotMatchingAirlines = new LinkedList<>();

        for(FlightRoute.Flight i: getInBoundFlights()){
            if(isSameAirline(o, i) && isSameDestinations(o, i)){
                flightMatchingAirlines.add(i);
            }else if(isSameDestinations(o, i)) {
                flightNotMatchingAirlines.add(i);
            }
        }

        results = flightMatchingAirlines.isEmpty() ? flightNotMatchingAirlines : flightMatchingAirlines;
        sortByPrice(results);
    }

    public FlightRoute getModel() {
        return model;
    }

    public LinkedList<FlightRoute.Flight> getAllFlights(){
        return getModel().getAllFlights();
    }

    public LinkedList<FlightRoute.Flight> getOutBoundFlights(){
        return getModel().getOutBoundFlights();
    }

    public LinkedList<FlightRoute.Flight> getResults() {
        return results;
    }

    public LinkedList<FlightRoute.Flight> getInBoundFlights(){
        return getModel().getInBoundFlights();
    }

    public FlightRoute.Flight getFlightById(int i){
        return getModel().getFlightById(i);
    }

    public boolean isSameAirline(FlightRoute.Flight a, FlightRoute.Flight b){
        return a.getAirline().equalsIgnoreCase(b.getAirline());
    }

    public boolean isSameDestinations(FlightRoute.Flight a, FlightRoute.Flight b){
        return a.getDepartureAirportCode().equalsIgnoreCase(b.getArrivalAirportCode()) &&
                a.getArrivalAirportCode().equalsIgnoreCase(b.getDepartureAirportCode());
    }

    public void sortByPrice(LinkedList< FlightRoute.Flight > list){
        getModel().sortByPrice(list);
    }

    public void showAllFlightsView(){
        view.printFlightRouteDetails(model);
    }

    public void showFlightRoutesView(int id){
        FlightRoute.Flight f = getFlightById(id);
        flightRoutesCalculator(f);
        view.printFlightRoute(f, results);
    }
}