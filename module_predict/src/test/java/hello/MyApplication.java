package hello;

import org.json.JSONException;
import java.io.IOException;
import static org.mockito.Mockito.*;

class MyApplication {

    public RBK rbk;
    public Weather weather;
    public ExchangePrediction exchangePrediction;

    public MyApplication(){
        this.rbk = mock(RBK.class);
        this.weather = mock(Weather.class);
        this.exchangePrediction = mock(ExchangePrediction.class);
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