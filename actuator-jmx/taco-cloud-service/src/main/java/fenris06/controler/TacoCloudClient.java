package fenris06.controler;

import fenris06.model.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class TacoCloudClient {
    private RestTemplate restTemplate;

    public TacoCloudClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
//    public Ingredient getIngredientById(String ingredientId) {
//        Map<String, String> urlVariables = new HashMap<>();
//        urlVariables.put("id", ingredientId);
//        return restTemplate.getForObject("http://localhost:8080/ingredients/{id}",
//                Ingredient.class, ingredientId);
//    }

 /*   public Ingredient getIngredientById(String ingredientId) {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", ingredientId);
        URI uri = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/ingredients/{id}")
                .build(urlVariables);
        return restTemplate.getForObject(uri,
                Ingredient.class);
    }*/

    public Ingredient getIngredientById(String ingredientId) {
        ResponseEntity<Ingredient> responseEntity =
                restTemplate.getForEntity("http://localhost:8080/ingredients/{id}",
                        Ingredient.class, ingredientId);
        log.info("Fetched time: {}",
                responseEntity.getHeaders().getDate());
        return responseEntity.getBody();
    }

    public void updateIngredientById(Ingredient ingredient) {
        restTemplate.put("http://localhost:8080/ingredients/{id}", ingredient, ingredient.getId());
    }

    public void deleteIngredientById(Ingredient ingredient) {
        restTemplate.delete("http://localhost:8080/ingredients/{id}", ingredient.getId());
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        ResponseEntity<Ingredient> responseEntity =
                restTemplate.postForEntity("http://localhost:8080/ingredients",
                        ingredient,
                        Ingredient.class);
        log.info("New resource created at {}",
                responseEntity.getHeaders().getLocation());
        return responseEntity.getBody();
    }
}
