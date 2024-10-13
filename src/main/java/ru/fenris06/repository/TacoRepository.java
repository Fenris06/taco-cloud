package ru.fenris06.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.fenris06.model.Taco;

public interface TacoRepository 
         extends PagingAndSortingRepository<Taco, Long> {

}
