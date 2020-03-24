package hello;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class WeatherTest {
    Weather weather;
    public WeatherTest(){
        this.weather = new Weather();
    }


    @Test
    public void unit1() throws IOException, JSONException {
        System.out.println("Correct start");

        Weather weatherMock = Mockito.mock(Weather.class);

        MyApplication app = new MyApplication(weatherMock);
        app.printWeather();
        Mockito.verify(weatherMock).getWeatherFromRBK();

        app = new MyApplication(weather);
        Assert.assertTrue(weather.getWeatherFromRBK() < 100);
    }
/*
    @Test
    public void getMax() {
        Assert.assertTrue(Double.parseDouble(rbk.getMax()) > 60);
    }

 */
}