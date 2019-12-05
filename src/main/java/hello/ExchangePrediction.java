package hello;

import org.json.JSONException;

import java.io.IOException;

public class ExchangePrediction {
    Weather weather;
    public ExchangePrediction(){
        this.weather = new Weather();
    }

    public double predictExchange( double exchange){
        try {
            return (exchange  + weather.getWeatherFromRBK()) / 2;
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
