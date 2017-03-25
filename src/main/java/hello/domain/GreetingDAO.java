package hello.domain;

import hello.model.Greeting;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @author john
 * @since 25/03/17
 */
@Transactional
@Repository
public class GreetingDAO {
    @PersistenceContext
    private EntityManager entityManager;
    public Greeting save(Greeting greeting){
        this.entityManager.persist(greeting);
        return greeting;
    }
}
