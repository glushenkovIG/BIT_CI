package hello;

import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class DataBaseController {
    Weather weather;
    DataBaseController(){
        this.weather = new Weather();
    }

    @RequestMapping(value = "/put/{exchange}", method = GET)
    public String index() throws IOException, JSONException {
        return "" + weather.getWeatherFromRBK();
    }
}