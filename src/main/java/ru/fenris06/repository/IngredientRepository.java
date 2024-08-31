package ru.fenris06.repository;

import org.springframework.data.repository.CrudRepository;
import ru.fenris06.model.Ingredient;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
