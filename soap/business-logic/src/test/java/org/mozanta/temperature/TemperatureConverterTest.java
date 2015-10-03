package org.mozanta.temperature;

import junit.framework.TestCase;

/**
 * Created by madhulal on 04-09-2015.
 */
public class TemperatureConverterTest extends TestCase {

    private TemperatureConverter converter;

    public void setUp() throws Exception {
        super.setUp();
        converter = new TemperatureConverter();
    }

    public void testCelsiusToFahrenheit() throws Exception {
        float input = 30;
        float output = converter.celsiusToFahrenheit(input);
        assertEquals(86.0f, output);

        input = 0;
        output = converter.celsiusToFahrenheit(input);
        assertEquals(32.0f, output);
    }

    public void testFahrenheitToCelsius() throws Exception {
        float input = 86;
        float output = converter.fahrenheitToCelsius(input);
        assertEquals(30f, output);

        input = 32;
        output = converter.fahrenheitToCelsius(input);
        assertEquals(0f, output);
    }
}