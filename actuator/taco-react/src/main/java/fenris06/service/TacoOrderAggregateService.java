package fenris06.service;

import fenris06.model.Taco;
import fenris06.model.TacoOrder;
import fenris06.repository.OrderRepository;
import fenris06.repository.TacoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TacoOrderAggregateService {
    private final TacoRepository tacoRepo;
    private final OrderRepository orderRepo;

    public Mono<TacoOrder> save(TacoOrder tacoOrder) {
        return Mono.just(tacoOrder)
                .flatMap(order -> {
                            List<Taco> tacos = order.getTacos();
                            order.setTacos(new ArrayList<>());
                            return tacoRepo.saveAll(tacos)
                                    .map(taco -> {
                                                order.addTaco(taco);
                                                return order;
                                            }
                                    )
                                    .last();
                        }
                )
                .flatMap(orderRepo::save);
    }

    public Mono<TacoOrder> findById(Long id) {
        return orderRepo
                .findById(id)
                .flatMap(order-> {
                    return tacoRepo.findAllById(order.getTacoIds())
                            .map(taco -> {
                                order.addTaco(taco);
                                return order;
                            }).last();
                });
    }
}
