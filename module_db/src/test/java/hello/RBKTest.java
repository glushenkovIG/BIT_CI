package hello;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class RBKTest {
    RBK rbk;

    public RBKTest(){
        rbk = new RBK();
    }

    @Test
    public void unit1() throws IOException {
        System.out.println("Correct start");

        RBK rbkMock = Mockito.mock(RBK.class);
        Weather weatherMock = Mockito.mock(Weather.class);
        ExchangePrediction exchangePredictionMock = Mockito.mock(ExchangePrediction.class);

        MyApplication app = new MyApplication(rbkMock, weatherMock, exchangePredictionMock);
        app.printCourse();
        Mockito.verify(rbkMock).getMax();

        app = new MyApplication(rbk, weatherMock, exchangePredictionMock);
        app.printCourse();
    }
/*
    @Test
    public void getMax() {
        Assert.assertTrue(Double.parseDouble(rbk.getMax()) > 60);
    }

 */
}