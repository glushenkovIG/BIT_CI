package hello;

import org.json.JSONException;
import org.mockito.Mockito;

import java.io.IOException;

class MyApplication {

    public Weather weather;


    public MyApplication(){
        this.weather = Mockito.mock(Weather.class);
    }

    public MyApplication(Weather weather){
        this.weather = weather;
    }
    void printWeather() throws IOException, JSONException {System.out.println(weather.getWeatherFromRBK()); }
}