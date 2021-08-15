package src.main.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightRoutesCalculatorControllerTest {

    FlightRoute model;
    FlightRoutesCalculatorView view;
    FlightRoutesCalculatorController controller;

    String mockupUrl;
    String mockupUrlInvalid;

    @BeforeEach
    void setUp() {
        model = new FlightRoute();
        view = new FlightRoutesCalculatorView();
        controller = new FlightRoutesCalculatorController(model, view);

        mockupUrl = "https://run.mocky.io/v3/1d769332-43ce-410f-8a68-43fd9782dd87";
        mockupUrlInvalid = "https://run.mocky.io/v3/1d769332-43ce-410f-8a68-43fd97";
    }

    @Test
    void testHttpGetInvalid(){
        Throwable exception = assertThrows(IllegalStateException.class, () -> controller.fetchData(mockupUrlInvalid));
        assertEquals("Request empty", exception.getMessage());
    }
}