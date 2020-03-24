package hello;

import org.json.JSONException;
import org.mockito.Mockito;

import java.io.IOException;

class MyApplication {

    public RBK rbk;
    public Weather weather;
    public ExchangePrediction exchangePrediction;


    public MyApplication(){
        this.rbk = Mockito.mock(RBK.class);
        this.weather = Mockito.mock(Weather.class);
        this.exchangePrediction = Mockito.mock(ExchangePrediction.class);
    }

    public MyApplication(RBK rbk, Weather weather, ExchangePrediction exchangePrediction) {
        this.rbk = rbk;
        this.weather = weather;
        this.exchangePrediction = exchangePrediction;
    }

    void printCourse() {
        System.out.println(rbk.getMax());
    }
    void predictCourse(double a) {System.out.println(exchangePrediction.predictExchange(a));}
    void printWeather() throws IOException, JSONException {System.out.println(weather.getWeatherFromRBK()); }
}