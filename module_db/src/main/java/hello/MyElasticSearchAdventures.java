package hello;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyElasticSearchAdventures {
    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl = "http://localhost:9200" + "/twitter/_doc/1?pretty";

    MyElasticSearchAdventures(){
    }

    void initial_request(){

        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);

        //System.out.println("\n\n Initial request \n\n " + response.getBody());
    }

    void insert(String key, String value){
        String fullRequestAddress = fooResourceUrl;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> a = null;
        a = new HttpEntity<String>(build_json_for_request(key, value), headers);

        ResponseEntity<String> response1 = restTemplate.postForEntity(fullRequestAddress, a, String.class);

        System.out.println("\n\n insert \n\n " + response1.getBody());
    }

    private String build_json_for_request(String key, String value){
        String JsonData = "{ " +
                "\"user\": \"" + key + "\"," +
                " \"post_date\": \"2009-11-15T13:12:00\"," +
                " \"message\":" + "\"" + value + "\"" +
                "}";

        return JsonData;
    }

    public String get(String key) {
        String fullRequestAddress = fooResourceUrl;

        String s = "http://localhost:9200/" + key + "/_search?pretty=true'";

        ResponseEntity<String> response1 = restTemplate.getForEntity(fullRequestAddress, String.class);

        JSONObject aa = null;
        String ans = "";
        try {
            aa = new JSONObject(response1.getBody());
            ans = aa.getJSONObject("_source").getString("message");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ans;
    }

}