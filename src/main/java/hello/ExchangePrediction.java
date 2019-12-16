package hello;

import org.springframework.stereotype.Service;

@Service
public class ExchangePrediction {
    Weather weather;
    public ExchangePrediction(){
        this.weather = new Weather();
    }

    public double predictExchange( double exchange){
        return 0;

        //TODO discomment this part
        /*
        try {
            return (exchange  + weather.getWeatherFromRBK()) / 2;
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

         */
    }
}
