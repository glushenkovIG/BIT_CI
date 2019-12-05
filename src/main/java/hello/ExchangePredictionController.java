package hello;

import org.json.JSONException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ExchangePredictionController {
    ExchangePrediction exchangePrediction;
    ExchangePredictionController(){
        this.exchangePrediction = new ExchangePrediction();
    }

    @RequestMapping(value = "/predict/{exchange}", method = GET)

    public String index(@PathVariable double exchange) throws IOException, JSONException {
        return "" + exchangePrediction.predictExchange(exchange);
    }
}
