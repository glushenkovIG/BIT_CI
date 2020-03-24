package hello;

import org.json.JSONException;
import org.mockito.Mockito;

import java.io.IOException;

class MyApplication {

    public RBK rbk;

    public MyApplication(){
        this.rbk = Mockito.mock(RBK.class);
    }

    public MyApplication(RBK rbk) {
        this.rbk = rbk;
    }

    void printCourse() {
        System.out.println(rbk.getMax());
    }
}