package src.main.java;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FlightRoutesCalculatorController {
    // Controller layer

    private FlightRoutesCalculator model;
    private FlightRoutesCalculatorView view;

    private String ApiUrl = "http://www.mocky.io/v2/5cebcb7d330000cc296d7772";

    public FlightRoutesCalculatorController(FlightRoutesCalculator model, FlightRoutesCalculatorView view){
        this.model = model;
        this.view = view;
    }

    public void fetchData(){

        try {
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(
                            URI.create(ApiUrl))
                    .header("accept", "application/json")
                    .build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // System.out.println(response.body());
            JsonObject jsonObject = new JsonParser().parse(response.body()).getAsJsonObject();
            System.out.println(jsonObject);

        } catch (IOException | InterruptedException e){
            // timeout, api address non-existent, etc. exceptions
            e.printStackTrace();
        }
    }

    // getters...
    public int getFlightId(){
        return model.getFlightId();
    }

    public String getAirline(){
        return model.getAirline();
    }

    public int getPrice(){
        return model.getPrice();
    }
    //... end getters

    // setters...
    public void setFlightId(int flightId){
        model.setFlightId(flightId);
    }

    public void setAirline(String airline){
        model.setAirline(airline);
    }

    public void setPrice(int price){
        model.setPrice(price);
    }
    //... end setters

    public void updateView(){
        view.printCalculatorDetails(model.getFlightId(), model.getAirline(), model.getPrice());
    }

}