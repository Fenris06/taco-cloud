package fenris06.repository;

import fenris06.model.Taco;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TacoRepository 
         extends PagingAndSortingRepository<Taco, Long> {

}
