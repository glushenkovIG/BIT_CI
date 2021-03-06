package hello;

import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequiredArgsConstructor
public class ExchangePredictionController {
    private final ExchangePrediction exchangePrediction = new ExchangePrediction();

    @RequestMapping(value = "/predict/{exchange}"+"", method = GET)
    public String index(@PathVariable double exchange) {
        double dd = exchangePrediction.predictExchange(exchange);

        System.out.println("exchange: " + exchange);
        return "" + dd;
    }
}
