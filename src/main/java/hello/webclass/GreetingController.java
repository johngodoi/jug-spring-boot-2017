package hello.webclass;

import hello.domain.GreetingDAO;
import hello.model.Greeting;
import hello.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    @Autowired
    private GreetingRepository dao;

    @RequestMapping(method = RequestMethod.POST)
    public Greeting save(@RequestParam(value="name", defaultValue="World") String name) {
        Greeting greeting = new Greeting();
        greeting.setContent(createContent(name));
        return this.dao.save(greeting);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Greeting update(@RequestParam(value="id") Long id, @RequestParam(value="name", defaultValue="World") String name) {
        Greeting greeting = this.find(id);
        greeting.setContent(createContent(name));
        return this.dao.save(greeting);
    }

    @RequestMapping(params = {"id"}, method = RequestMethod.GET)
    public Greeting find(@RequestParam(value="id") Long id) {
        return this.dao.findOne(id);
    }

    @RequestMapping(params = {"name"}, method = RequestMethod.GET)
    public Greeting find(@RequestParam(value="name") String name) {
        return this.dao.findByContent(createContent(name));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Greeting> list(){
        return this.dao.findAll();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Greeting remove(@RequestParam(value = "id") Long id){
        Greeting greeting = this.find(id);
        this.dao.delete(id);
        return greeting;
    }

    private String createContent(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format(template, name);
    }

}
