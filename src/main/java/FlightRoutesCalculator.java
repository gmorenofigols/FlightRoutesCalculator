package src.main.java;

public class FlightRoutesCalculator {
    // Model layer

    private int FlightId;
    private String Airline;
    private String DepartureAirportCode;
    private String ArrivalAirportCode;
    private int Price;

    // getters...
    public int getFlightId() {
        return FlightId;
    }

    public String getAirline() {
        return Airline;
    }

    public String getDepartureAirportCode() {
        return DepartureAirportCode;
    }

    public String getArrivalAirportCode() {
        return ArrivalAirportCode;
    }

    public int getPrice() {
        return Price;
    }
    //... end getters

    // setters...
    public void setFlightId(int flightId) {
        FlightId = flightId;
    }

    public void setAirline(String airline) {
        Airline = airline;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        DepartureAirportCode = departureAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        ArrivalAirportCode = arrivalAirportCode;
    }

    public void setPrice(int price) {
        Price = price;
    }
    //... end setters

}