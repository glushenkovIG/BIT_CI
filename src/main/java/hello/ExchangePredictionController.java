package hello;

import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequiredArgsConstructor
public class ExchangePredictionController {
    private final ExchangePrediction exchangePrediction;
    private final MyElasticSearchAdventures myElasticSearchAdventures;

    @RequestMapping(value = "/predict/{exchange}", method = GET)

    public String index(@PathVariable double exchange) throws IOException, JSONException {
        if(!myElasticSearchAdventures.get("" + exchange).equals("")){
            return myElasticSearchAdventures.get("" + exchange) + "\n000000000000000\n";
        }

        double dd = exchangePrediction.predictExchange(exchange);
        myElasticSearchAdventures.insert("" + exchange, "" + dd);
        System.out.println("exchange: " + exchange);
        return "" + dd;
    }
}
