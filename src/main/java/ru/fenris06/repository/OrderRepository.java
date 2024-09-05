package ru.fenris06.repository;

import org.springframework.data.repository.CrudRepository;
import ru.fenris06.model.TacoOrder;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {

}