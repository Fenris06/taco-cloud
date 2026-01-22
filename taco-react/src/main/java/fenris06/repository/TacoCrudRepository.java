package fenris06.repository;

import fenris06.model.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoCrudRepository extends CrudRepository<Taco, Long> {

}
