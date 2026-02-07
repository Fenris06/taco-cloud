package fenris06.repository;

import fenris06.model.Ingredient;
import fenris06.model.Ingredient.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.beans.BeanProperty;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataR2dbcTest
class IngredientRepositoryTest {
    @Autowired
    IngredientRepository ingredientRepository;

    @BeforeEach
    public void setup() {
        Flux<Ingredient> deleteAndSent = ingredientRepository.deleteAll()
                .thenMany(ingredientRepository.saveAll(
                                Flux.just(
                                        new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                                        new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                                        new Ingredient("CHED", "Cheddar Cheese", Type.CHEESE)
                                )
                        )
                );

        StepVerifier.create(deleteAndSent)
                .expectNextCount(3L)
                .verifyComplete();
    }

    @Test
    public void shouldSaveAndFetchIngredients() {
        StepVerifier.create(ingredientRepository.findAll())
                .recordWith(ArrayList::new)
                .thenConsumeWhile(x -> true)
                .consumeRecordedWith(ingredients -> {
                    assertThat(ingredients).hasSize(3);
                    assertThat(ingredients).contains(
                            new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
                    assertThat(ingredients).contains(
                            new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
                    assertThat(ingredients).contains(
                            new Ingredient("CHED", "Cheddar Cheese", Type.CHEESE));
                })
                .verifyComplete();

        StepVerifier.create(ingredientRepository.findBySlug("FLTO"))
                .assertNext(ingredient -> {
                    ingredient.equals(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
                });
    }

}