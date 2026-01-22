package fenris06.controler;

import fenris06.model.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
public class TacoCloudClient {
    private RestTemplate restTemplate;


    public TacoCloudClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

/*    public Ingredient getIngredientById(String ingredientId) {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", ingredientId);
        URI uri = UriComponentsBuilder
               .fromHttpUrl("http://localhost:8080/ingredients/{id}") .build(urlVariables);
       return restTemplate.getForObject(uri,
               Ingredient.class);
   }

  public Ingredient getIngredientById(String ingredientId) {
        ResponseEntity<Ingredient> responseEntity =
                restTemplate.getForEntity("http://localhost:8080/ingredients/{id}", Ingredient.class, ingredientId);
        log.info("Fetched time: {}",
                responseEntity.getHeaders().getDate());
        return responseEntity.getBody();
    }*/

    public void updateIngredientById(Ingredient ingredient) {
        // restTemplate.put("http://localhost:8080/ingredients/{id}", ingredient, ingredient.getId());
        Mono<Ingredient> ingredients = WebClient.create()
                .get()
                .uri("http://localhost:8080/ingredients/{id}", ingredient.getId())
                .exchangeToMono(cr-> {
                    if (cr.headers().header("X_UNAVALABLE").contains("true")) {
                        return Mono.empty();
                    }
                    return Mono.just(cr);
                        })
                .flatMap(cr -> cr.bodyToMono(Ingredient.class));
    }

    public void deleteIngredientById(Ingredient ingredient) {
        restTemplate.delete("http://localhost:8080/ingredients/{id}", ingredient.getId());
    }

    public void createIngredient(Ingredient ingredient) {
        Mono<Void> result = WebClient.create()
                .post()
                .uri("http://localhost:8080/ingredients")
                .bodyValue(ingredient)
                .retrieve()
                .bodyToMono(Void.class);

        result.subscribe();

    }

    }
