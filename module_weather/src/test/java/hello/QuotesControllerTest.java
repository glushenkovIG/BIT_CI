package hello;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuotesControllerTest {
    @Test
    public void unit1(){
        HelloController helloController = new HelloController();
        helloController.index();
        QuotesController qc = new QuotesController();
        return;
    }

}