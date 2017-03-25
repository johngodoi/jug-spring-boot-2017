package hello.domain;

import hello.model.Greeting;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author john
 * @since 25/03/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GreetingDaoTest {
    @Autowired
    private GreetingDAO dao;

    @Test
    public void findAllButNone(){
        Assert.assertEquals(0, dao.findAll().size());
    }
    @Test
    public void findAllWithOne(){
        dao.save(new Greeting());
        Assert.assertEquals(1, dao.findAll().size());
    }
}
