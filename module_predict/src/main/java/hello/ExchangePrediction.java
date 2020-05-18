package hello;

import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
class ExchangePrediction {
    public String host_url;

    public double predictExchange( double exchange){
        Map<String, String> env = System.getenv();

        host_url = env.get("DB_HOST");

        try {
            if(db_contains(exchange) == 1 ){
                return db_load(exchange);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Double weather = requestWeather();
        db_store(exchange, weather);
        return ( 10 + exchange)/2;
    }

    public Double requestWeather() {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> env = System.getenv();
        String requestURL
                = env.get("WEATHER_HOST");
        ResponseEntity<String> response = restTemplate.getForEntity(requestURL, String.class);
        Double weather = Double.parseDouble(response.getBody());

        return weather;
    }

    public Integer db_contains(double exchange) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();

        String requestURL
                = host_url + "/EXISTS/" + exchange;
        ResponseEntity<LinkedHashMap> response1 = restTemplate.getForEntity(requestURL, LinkedHashMap.class);
        // todo the problem
        // https://github.com/nicolasff/webdis
        // docker run --rm -d -p 7379:7379 webdis

        // http://127.0.0.1:8083/predict/39
        // http://127.0.0.1:8184/GET/39
        System.out.println(response1.getBody()); // {EXISTS=1}
        ResponseEntity<LinkedHashMap> response = restTemplate.getForEntity(requestURL, LinkedHashMap.class);

        System.out.println(response.getBody()); // {}
        return Integer.parseInt(response.getBody().get("EXISTS").toString());
    }

    public double db_load(double exchange){
        RestTemplate restTemplate = new RestTemplate();

        String requestURL
                = host_url + "/GET/" + exchange;
        ResponseEntity<LinkedHashMap> response = restTemplate.getForEntity(requestURL, LinkedHashMap.class);
        System.out.println(response.getBody().getClass());
        return Double.parseDouble(response.getBody().get("GET").toString());
    }

    public void db_store(double exchange, Double weather){
        RestTemplate restTemplate = new RestTemplate();

        String requestURL
                = host_url + "/SET/" + exchange + "/" + weather;
        ResponseEntity<LinkedHashMap> response = restTemplate.getForEntity(requestURL, LinkedHashMap.class);
    }
}
