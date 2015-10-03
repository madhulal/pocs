package org.mozanta.temperature;

import junit.framework.TestCase;

/**
 * Created by madhulal on 04-09-2015.
 */
public class TemperatureClientTest extends TestCase {

    private TemperatureClient client;

    public void setUp() throws Exception {
        super.setUp();
        client = new TemperatureClient();
    }

    public void testCelsiusToFahrenheit() throws Exception {
        float input = 30;
        float output = client.celsiusToFahrenheit(input);
        assertEquals(86.0f, output);

        input = 0;
        output = client.celsiusToFahrenheit(input);
        assertEquals(32.0f, output);
    }

    public void testFahrenheitToCelsius() throws Exception {
        float input = 86;
        float output = client.fahrenheitToCelsius(input);
        assertEquals(30f, output);

        input = 32;
        output = client.fahrenheitToCelsius(input);
        assertEquals(0f, output);
    }

    public void testGetStub() throws Exception {

    }
}