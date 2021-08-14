package java;

public class FlightRoutesCalculatorController {
    // Controller layer

    private FlightRoutesCalculator model;
    private FlightRoutesCalculatorView view;

    public FlightRoutesCalculatorController(FlightRoutesCalculator model, FlightRoutesCalculatorView view){
        this.model = model;
        this.view = view;
    }

    // getters...
    public String getFlightId(){
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