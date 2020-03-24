package hello;

import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WeatherController {
    Weather weather;
    WeatherController(){
        this.weather = new Weather();
    }

    @RequestMapping("/weather")
    public String index() throws IOException, JSONException {
        return "" + weather.getWeatherFromRBK();
    }
}
