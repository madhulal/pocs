package org.mozanta.temperature;


import org.apache.axis2.AxisFault;
import org.mozanta.temperature.client.MozantaTemperatureServiceStub;

import java.rmi.RemoteException;

/**
 * Created by madhulal on 03-09-2015.
 */
public class TemperatureClient {

    private static final String SERVICE_URL = "http://localhost:8000/axis2/services/MozantaTemperatureService";

    private MozantaTemperatureServiceStub stub;

    public float celsiusToFahrenheit(final float celsius) throws RemoteException {
        final CelsiusToFahrenheitDocument requestDoc = CelsiusToFahrenheitDocument.Factory.newInstance();
        final CelsiusToFahrenheitDocument.CelsiusToFahrenheit celsiusToFarenheit = requestDoc.addNewCelsiusToFahrenheit();
        celsiusToFarenheit.setCelsius(celsius);
        final CelsiusToFahrenheitResponseDocument responseDoc = getStub().celsiusToFahrenheit(requestDoc);
        return responseDoc.getCelsiusToFahrenheitResponse().getReturn();
    }

    public float fahrenheitToCelsius(final float fahrenheit) throws RemoteException {
        final FahrenheitToCelsiusDocument requestDoc = FahrenheitToCelsiusDocument.Factory.newInstance();
        final FahrenheitToCelsiusDocument.FahrenheitToCelsius fahrenheitToCelsius = requestDoc.addNewFahrenheitToCelsius();
        fahrenheitToCelsius.setFahrenheit(fahrenheit);
        final FahrenheitToCelsiusResponseDocument responseDoc = getStub().fahrenheitToCelsius(requestDoc);
        return responseDoc.getFahrenheitToCelsiusResponse().getReturn();
    }

    public MozantaTemperatureServiceStub getStub() throws AxisFault {
        if (null == stub)
            stub = new MozantaTemperatureServiceStub(SERVICE_URL);
        return stub;
    }
}
