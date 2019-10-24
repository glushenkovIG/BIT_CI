package hello;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class RBKTest {
    RBK rbk;
    @Test
    void unit1() {
        System.out.println("Correct start");
        RBK rbkMock = Mockito.mock(RBK.class);
        MyApplication app = new MyApplication(rbkMock);
        app.printCourse();
        Mockito.verify(rbkMock).getMax();

        rbk = new RBK();
        app = new MyApplication(rbk);
        app.printCourse();
    }

    @Test
    public void getMax() {
        Assert.assertTrue(Integer.getInteger(rbk.getMax()) > 60);
    }
}