package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuotesController {
    @RequestMapping("/quotes")
    public String index() {
        return "I’m returning quotes to you!";
    }
}
