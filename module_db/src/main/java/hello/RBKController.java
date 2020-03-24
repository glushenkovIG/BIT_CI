package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RBKController {
    RBK rbk;
    RBKController(){
        this.rbk = new RBK();
    }

    @RequestMapping("/rbk")
    public String index() {
        return rbk.getMax();
    }
}
