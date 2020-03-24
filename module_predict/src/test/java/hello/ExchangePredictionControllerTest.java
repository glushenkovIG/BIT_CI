package hello;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

@Ignore
public class ExchangePredictionControllerTest {
    ExchangePrediction exchangePrediction;
    public ExchangePredictionControllerTest(){
        this.exchangePrediction = new ExchangePrediction();
    }


    @Test
    public void unit1() throws IOException, JSONException {
        System.out.println("Correct start");

        RBK rbkMock = Mockito.mock(RBK.class);
        Weather weatherMock = Mockito.mock(Weather.class);
        ExchangePrediction exchangePredictionMock = Mockito.mock(ExchangePrediction.class);

        MyApplication app = new MyApplication(rbkMock, weatherMock, exchangePredictionMock);
        app.predictCourse(10);
        Mockito.verify(exchangePredictionMock).predictExchange(10);
        app.predictCourse(10);


        Assert.assertTrue(exchangePrediction.predictExchange(10) < 100);
    }

    @Test
    public void getFromCache() {
        double value = 10;
        System.out.println(exchangePrediction.predictExchange(value));
        System.out.println(exchangePrediction.predictExchange(value));
    }
}