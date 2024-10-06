package ru.fenris06.repository;

import org.springframework.data.repository.CrudRepository;
import ru.fenris06.model.Taco;

public interface TacoRepository 
         extends CrudRepository<Taco, Long> {

}
