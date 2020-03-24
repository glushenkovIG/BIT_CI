package hello;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangePrediction {
    Weather weather;
    public ExchangePrediction(){
        this.weather = new Weather();
    }

    public double predictExchange( double exchange){
        return (requestWeather() + exchange)/2;
    }

    private int requestWeather() {
        RestTemplate restTemplate = new RestTemplate();
        String requestURL
                = "http://weather:8082/weather";
        ResponseEntity<String> response = restTemplate.getForEntity(requestURL, String.class);

        return Integer.parseInt(response.getBody());
    }
}
