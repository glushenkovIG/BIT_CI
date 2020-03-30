package hello;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;

@Service
public class ExchangePrediction {
    Weather weather;
    String host_url = "http://db:7379/";

    public ExchangePrediction(){
        this.weather = new Weather();
    }

    public double predictExchange( double exchange){
        try {
            if(db_contains(exchange) == 1 ){
                return db_load(exchange);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Double weather = requestWeather();
        db_store(exchange, weather);
        return ( + exchange)/2;
    }

    private Double requestWeather() {
        RestTemplate restTemplate = new RestTemplate();

        String requestURL
                = "http://weather:8082/weather";
        ResponseEntity<String> response = restTemplate.getForEntity(requestURL, String.class);
        Double weather = Double.parseDouble(response.getBody());

        return weather;
    }

    private Integer db_contains(double exchange) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();

        String requestURL
                = host_url + "EXISTS/" + exchange;
        ResponseEntity<LinkedHashMap> response1 = restTemplate.getForEntity(requestURL, LinkedHashMap.class);
        // todo the problem
        // https://github.com/nicolasff/webdis
        // docker run --rm -d -p 8184:7379 webdis

        // http://127.0.0.1:8083/predict/39
        // http://127.0.0.1:8184/GET/39
        System.out.println(response1.getBody()); // {EXISTS=1}
        ResponseEntity<LinkedHashMap> response = restTemplate.getForEntity(requestURL, LinkedHashMap.class);
        // System.out.println(String.format("-------------------------" + response.getBody(), 4));

        System.out.println(response.getBody()); // {}
        return Integer.parseInt(response.getBody().get("EXISTS").toString());
    }

    private double db_load(double exchange){
        RestTemplate restTemplate = new RestTemplate();

        String requestURL
                = host_url + "GET/" + exchange;
        ResponseEntity<LinkedHashMap> response = restTemplate.getForEntity(requestURL, LinkedHashMap.class);
        System.out.println(response.getBody().getClass());
        return Double.parseDouble(response.getBody().get("GET").toString());
    }

    private void db_store(double exchange, Double weather){
        RestTemplate restTemplate = new RestTemplate();

        String requestURL
                = host_url + "SET/" + exchange + "/" + weather;
        ResponseEntity<LinkedHashMap> response = restTemplate.getForEntity(requestURL, LinkedHashMap.class);
    }
}
