import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

public class FluxBufferingTests {
    @Test
    public void createAFlux_just() {
        Flux<String> fruitFlux = Flux
                .just("apple", "orange", "banana", "kiwi", "strawberry");
        StepVerifier.create(fruitFlux)
                .expectNext("apple")
                .expectNext("orange")
                .expectNext("banana")
                .expectNext("kiwi")
                .expectNext("strawberry")
                .verifyComplete();
    }

    @Test
    public void createAFlux_fromArray() {
        String[] fruits = new String[]{"apple", "orange", "banana", "kiwi", "strawberry"};
        Flux<String> fruitFlux = Flux.fromArray(fruits);

        StepVerifier.create(fruitFlux)
                .expectNext("apple")
                .expectNext("orange")
                .expectNext("banana")
                .expectNext("kiwi")
                .expectNext("strawberry")
                .verifyComplete();
    }

    @Test
    public void createAFlux_fromIterable() {
        List<String> fruits = List.of("apple", "orange", "banana", "kiwi", "strawberry");
        Flux<String> fruitFlux = Flux.fromIterable(fruits);

        StepVerifier.create(fruitFlux)
                .expectNext("apple")
                .expectNext("orange")
                .expectNext("banana")
                .expectNext("kiwi")
                .expectNext("strawberry")
                .verifyComplete();
    }

    @Test
    public void createAFlux_fromStream() {
        Stream<String> fruits = Stream.of("apple", "orange", "banana", "kiwi", "strawberry");
        Flux<String> fruitFlux = Flux.fromStream(fruits);

        StepVerifier.create(fruitFlux)
                .expectNext("apple")
                .expectNext("orange")
                .expectNext("banana")
                .expectNext("kiwi")
                .expectNext("strawberry")
                .verifyComplete();
    }

    @Test
    public void createAFlux_rage() {
      Flux<Integer> integerFlux = Flux.range(1,5);

        StepVerifier.create(integerFlux)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .expectNext(5)
                .verifyComplete();
    }

    @Test
    public void createAFlux_interval() {
        Flux<Long> intervalFlux = Flux.interval(Duration.ofSeconds(1))
                .take(5);
        StepVerifier.create(intervalFlux)
                .expectNext(0L)
                .expectNext(1L)
                .expectNext(2L)
                .expectNext(3L)
                .expectNext(4L)
                .verifyComplete();
    }

    @Test
    public void mergeFlux() {
        Flux<String> characterFlux = Flux
                .just("Garfield", "Kojak", "Barbossa")
                .delayElements(Duration.ofMillis(500));
        Flux<String> foodFlux = Flux
                .just("Lasagna", "Lollipops", "Apples")
                .delaySubscription(Duration.ofMillis(250))
                .delayElements(Duration.ofMillis(500));
        Flux<String> mergeFlux = characterFlux.mergeWith(foodFlux);

        StepVerifier.create(mergeFlux)
                .expectNext("Garfield")
                .expectNext("Lasagna")
                .expectNext("Kojak")
                .expectNext("Lollipops")
                .expectNext("Barbossa")
                .expectNext("Apples")
                .verifyComplete();
     }

}
