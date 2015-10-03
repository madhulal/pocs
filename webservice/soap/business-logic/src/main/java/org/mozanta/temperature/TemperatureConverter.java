package org.mozanta.temperature;

/**
 * Created by madhulal on 02-09-2015.
 */

public class TemperatureConverter {

    public float celsiusToFahrenheit(float celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public float fahrenheitToCelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
