package java;


public class FlightRoutesCalculator {
    // Model layer

    private int FlightId;
    private string Airline;
    private string DepartureAirportCode;
    private string ArrivalAirportCode;
    private int Price;

    // getters...
    public int getFlightId() {
        return FlightId;
    }

    public string getAirline() {
        return Airline;
    }

    public string getDepartureAirportCode() {
        return DepartureAirportCode;
    }

    public string getArrivalAirportCode() {
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

    public void setAirline(string airline) {
        Airline = airline;
    }

    public void setDepartureAirportCode(string departureAirportCode) {
        DepartureAirportCode = departureAirportCode;
    }

    public void setArrivalAirportCode(string arrivalAirportCode) {
        ArrivalAirportCode = arrivalAirportCode;
    }

    public void setPrice(int price) {
        Price = price;
    }
    //... end setters

    public const string data = "{\n" +
            "    \"outboundFlights\": [\n" +
            "\t\t{\n" +
            "\t\t\t\"id\": 1,\n" +
            "\t\t\t\"airline\": \"Transavia\",\n" +
            "\t\t\t\"departureAirportCode\": \"BCN\",\n" +
            "\t\t\t\"arrivalAirportCode\": \"AMS\",\n" +
            "\t\t\t\"price\": 15\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id\": 2,\n" +
            "\t\t\t\"airline\": \"Vueling\",\n" +
            "\t\t\t\"departureAirportCode\": \"BCN\",\n" +
            "\t\t\t\"arrivalAirportCode\": \"AMS\",\n" +
            "\t\t\t\"price\": 20\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id\": 3,\n" +
            "\t\t\t\"airline\": \"Vueling\",\n" +
            "\t\t\t\"departureAirportCode\": \"GIR\",\n" +
            "\t\t\t\"arrivalAirportCode\": \"AMS\",\n" +
            "\t\t\t\"price\": 25\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id\": 4,\n" +
            "\t\t\t\"airline\": \"Transavia\",\n" +
            "\t\t\t\"departureAirportCode\": \"BCN\",\n" +
            "\t\t\t\"arrivalAirportCode\": \"AMS\",\n" +
            "\t\t\t\"price\": 30\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id\": 5,\n" +
            "\t\t\t\"airline\": \"Transavia\",\n" +
            "\t\t\t\"departureAirportCode\": \"BCN\",\n" +
            "\t\t\t\"arrivalAirportCode\": \"ROT\",\n" +
            "\t\t\t\"price\": 30\n" +
            "\t\t}\n" +
            "\t],\n" +
            "\t\"inboundFlights\": [\n" +
            "\t\t{\n" +
            "\t\t\t\"id\": 11,\n" +
            "\t\t\t\"airline\": \"Transavia\",\n" +
            "\t\t\t\"departureAirportCode\": \"AMS\",\n" +
            "\t\t\t\"arrivalAirportCode\": \"BCN\",\n" +
            "\t\t\t\"price\": 50\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id\": 12,\n" +
            "\t\t\t\"airline\": \"Vueling\",\n" +
            "\t\t\t\"departureAirportCode\": \"AMS\",\n" +
            "\t\t\t\"arrivalAirportCode\": \"BCN\",\n" +
            "\t\t\t\"price\": 30\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id\": 13,\n" +
            "\t\t\t\"airline\": \"Transavia\",\n" +
            "\t\t\t\"departureAirportCode\": \"AMS\",\n" +
            "\t\t\t\"arrivalAirportCode\": \"GIR\",\n" +
            "\t\t\t\"price\": 25\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id\": 14,\n" +
            "\t\t\t\"airline\": \"Vueling\",\n" +
            "\t\t\t\"departureAirportCode\": \"AMS\",\n" +
            "\t\t\t\"arrivalAirportCode\": \"GIR\",\n" +
            "\t\t\t\"price\": 30\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id\": 15,\n" +
            "\t\t\t\"airline\": \"Transavia\",\n" +
            "\t\t\t\"departureAirportCode\": \"AMS\",\n" +
            "\t\t\t\"arrivalAirportCode\": \"BCN\",\n" +
            "\t\t\t\"price\": 30\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}";
}