package fenris06.repository;

import fenris06.model.Ingredient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface IngredientRepository extends ReactiveCrudRepository<Ingredient, String> {
    Mono<Ingredient> findBySlug(String slug);
}
