package hello.repository;

import hello.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jgodoi on 29/03/2017.
 */
public interface GreetingRepository extends JpaRepository<Greeting,Long> {
    Greeting findByContent(String name);
}
