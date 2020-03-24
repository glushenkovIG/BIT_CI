package hello;

//import net.minidev.json.JSONObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Objects;


class Weather {
    public int getWeatherFromRBK() throws IOException, JSONException {
        RestTemplate restTemplate = new RestTemplate();
        String requestURL
                = "https://api.darksky.net/forecast/7ba6164198e89cb2e6b2454d90e7b41d/42.3601,-71.0589,255657600?exclude=currently,flags";
        ResponseEntity<String> response = restTemplate.getForEntity(requestURL, String.class);

        JSONObject json = new JSONObject(response.getBody());
        System.out.println("GetHeaders" + json.toString());
        System.out.println("daily result=" + json.getJSONObject("daily").getJSONArray("data"));

        int a = json.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getInt("temperatureHigh");
        System.out.println(a);
        return a;
    }
}
