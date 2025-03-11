import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

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


}
