package hello.webclass;

import hello.domain.GreetingDAO;
import hello.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    @Autowired
    private GreetingDAO dao;

    @RequestMapping(method = RequestMethod.POST)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        Greeting greeting = new Greeting();
        greeting.setContent(String.format(template, name));
        return this.dao.save(greeting);
    }
}
