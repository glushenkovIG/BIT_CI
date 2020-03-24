package hello;

import org.json.JSONException;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.*;

public class MyApplicationTest {
    MyApplication myApp;

    public MyApplicationTest(){
        this.myApp = new MyApplication();
    }

    @Test
    public void unit1() throws IOException, NoSuchFieldException, JSONException {

        System.out.println("Correct start");

        myApp.printCourse();
        Mockito.verify(myApp.rbk).getMax();

        myApp.printWeather();
        Mockito.verify(myApp.weather).getWeatherFromRBK();

        myApp.predictCourse(10);
        Mockito.verify(myApp.exchangePrediction).predictExchange(10);
    }

}