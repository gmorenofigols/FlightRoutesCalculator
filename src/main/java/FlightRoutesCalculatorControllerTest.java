package src.main.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FlightRoutesCalculatorControllerTest {

    FlightRoute model;
    FlightRoutesCalculatorView view;
    FlightRoutesCalculatorController controller;

    FlightRoute.Flight f1;
    FlightRoute.Flight f2;
    FlightRoute.Flight f3;
    FlightRoute.Flight f4;
    FlightRoute.Flight f5;

    String mockupUrl;
    String mockupUrlInvalid;

    @BeforeEach
    void setUp() {
        model = new FlightRoute();
        view = new FlightRoutesCalculatorView();
        controller = new FlightRoutesCalculatorController(model, view);

        f1 = new FlightRoute.Flight();
        f2 = new FlightRoute.Flight();
        f3 = new FlightRoute.Flight();
        f4 = new FlightRoute.Flight();
        f5 = new FlightRoute.Flight();

        model.add(f1);
        model.add(f2);
        model.add(f3);
        model.add(f4);
        model.add(f5);

        f1.setPrice(10);
        f1.setAirline("A");
        f1.setDepartureAirportCode("LLE");
        f1.setArrivalAirportCode("GRN");
        f1.setIsOutBound(true);

        f2.setPrice(20);
        f2.setAirline("A");
        f2.setDepartureAirportCode("GRN");
        f2.setArrivalAirportCode("LLE");
        f2.setIsOutBound(false);

        f3.setPrice(30);
        f3.setAirline("B");
        f3.setDepartureAirportCode("LLE");
        f3.setArrivalAirportCode("DK");
        f3.setIsOutBound(false);

        f4.setPrice(40);
        f4.setAirline("A");
        f4.setDepartureAirportCode("GRN");
        f4.setArrivalAirportCode("LLE");
        f4.setIsOutBound(false);

        f5.setPrice(50);
        f5.setAirline("A");
        f5.setDepartureAirportCode("GRN");
        f5.setArrivalAirportCode("LLE");
        f5.setIsOutBound(false);

        mockupUrl = "https://run.mocky.io/v3/1d769332-43ce-410f-8a68-43fd9782dd87";
        mockupUrlInvalid = "https://run.mocky.io/v3/1d769332-43ce-410f-8a68-43fd97";
    }

    @Test
    void testHttpGetInvalid(){
        Throwable exception = assertThrows(IllegalStateException.class, () -> controller.fetchData(mockupUrlInvalid));
        assertEquals("Request empty", exception.getMessage());
    }

    @Test
    void testGetFlightById(){
        assertEquals(0, controller.getFlightById(-1).getFlightId());
        assertEquals(0, controller.getFlightById('a').getFlightId());
    }

    @Test
    void testSortByPrice(){
        LinkedList<FlightRoute.Flight> list = new LinkedList<>();
        list.add(f3);
        list.add(f1);
        list.add(f2);
        controller.sortByPrice(list);
        assertTrue(list.get(0).getPrice() <= list.get(1).getPrice());
        assertTrue(list.get(1).getPrice() <= list.get(2).getPrice());
    }

    @Test
    void testIsSameAirline(){
        assertTrue(controller.isSameAirline(f1, f2));
        assertFalse(controller.isSameAirline(f1, f3));
    }

    @Test
    void testIsSameDestinations(){
        assertTrue(controller.isSameDestinations(f1, f2));
        assertFalse(controller.isSameDestinations(f1, f3));
    }


    @Test
    void testFlightRoutesCalculator(){
        controller.flightRoutesCalculator(f1);
        assertEquals(3, controller.getResults().size());
    }
}