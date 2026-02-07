//package fenris06;
//
//import fenris06.controler.TacoController;
//import fenris06.model.Ingredient;
//import fenris06.model.Taco;
//import fenris06.repository.TacoRepository;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//
//
//public class TacoControllerTest {
//
//
//    @Test
//    public void shouldReturnRecentTaco() {
//
//        Taco[] tacos = {
//                testTaco(1L),testTaco(2L),
//                testTaco(3L), testTaco(4L),
//                testTaco(5L), testTaco(6L),
//                testTaco(7L), testTaco(8L),
//                testTaco(9L), testTaco(10L),
//                testTaco(11L), testTaco(12L),
//                testTaco(13L), testTaco(14L),
//                testTaco(15L), testTaco(16L)
//        };
//        Flux<Taco> tacoFlux = Flux.just(tacos);
//        TacoRepository tacoRepository = Mockito.mock(TacoRepository.class);
//        Mockito.when(tacoRepository.findAll()).thenReturn(tacoFlux);
//
//        WebTestClient testClient = WebTestClient.bindToController(new TacoController(tacoRepository))
//                .build();
//
//        testClient.get().uri("/api/tacos?recent")
//                .exchange()
//                .expectStatus().isOk()
//                .expectBodyList(Taco.class)
//                .contains(Arrays.copyOf(tacos,12));
//
//    }
//
//    private Taco testTaco(Long number) {
//        Taco taco = new Taco();
//
//        taco.setId(number!=null ? number: 0);
//        taco.setName("Taco" + number);
//        List<Ingredient> ingredients = new ArrayList<>();
//        ingredients.add(new Ingredient("INGA", "Ingredient A", Ingredient.Type.WRAP));
//        ingredients.add(new Ingredient("INGB", "Ingredient B", Ingredient.Type.PROTEIN));
//        taco.setIngredients(ingredients);
//        return taco;
//    }
//
//    @Test
//    public void shouldSaveTaco() {
//        TacoRepository tacoRepository = Mockito.mock(TacoRepository.class);
//        WebTestClient testClient = WebTestClient.bindToController(new TacoController(tacoRepository))
//                .build();
//        Mono<Taco> unsavedTaco = Mono.just(testTaco(1L));
//
//        Taco savedTaco = testTaco(1L);
//        Flux<Taco>  savedTacoMono= Flux.just(savedTaco);
//
//        Mockito.when(tacoRepository.saveAll(Mockito.any(Mono.class))).thenReturn(savedTacoMono);
//
//
//        testClient.post()
//                .uri("/api/tacos")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(unsavedTaco, Taco.class)
//                .exchange()
//                .expectBody(Taco.class)
//                .isEqualTo(savedTaco);
//    }
//}
