package hello.domain;

import hello.model.Greeting;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

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

    public Greeting update(Greeting greeting){
        this.entityManager.merge(greeting);
        return greeting;
    }

    public Greeting find(Long id){
        return this.entityManager.find(Greeting.class, id);
    }

    public Greeting remove(Long id){
        Greeting greeting = this.find(id);
        this.entityManager.remove(greeting);
        return greeting;
    }

    public List<Greeting> findAll(){
        return this.entityManager.createNamedQuery("findall", Greeting.class).getResultList();
    }
}
