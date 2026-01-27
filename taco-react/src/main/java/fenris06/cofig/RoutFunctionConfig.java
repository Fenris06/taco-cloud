/*
package fenris06.cofig;

import fenris06.model.Taco;
import fenris06.repository.TacoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.ServerResponse.created;
import static reactor.core.publisher.Mono.just;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Configuration
public class RoutFunctionConfig {

    private TacoRepository tacoRepository;

    @Bean
    public RouterFunction<?> routerFunction() {
        return route(GET("/api/tacos")
                .and(queryParam("recent", t -> t != null)), this::recents)
                .andRoute(POST("/api/tacos"), this::postTaco);
    }


    public Mono<ServerResponse> recents(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(tacoRepository.findAll().take(12), Taco.class);
    }


    private Mono<ServerResponse> postTaco(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Taco.class)
                .flatMap(taco -> tacoRepository.save(taco))
                .flatMap(saveTaco -> {
                    return ServerResponse
                            .created(URI.create(
                                    "http://localhost:8080/api/tacos/"
                                            + saveTaco.getId()
                            ))
                            .body(saveTaco, Taco.class);
                });
    }


}
*/
