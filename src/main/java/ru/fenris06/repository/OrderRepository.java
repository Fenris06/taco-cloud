package ru.fenris06.repository;

import org.springframework.data.repository.CrudRepository;
import ru.fenris06.model.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

}