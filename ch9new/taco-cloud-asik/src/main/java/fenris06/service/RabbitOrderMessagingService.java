package fenris06.service;

import fenris06.model.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitOrderMessagingService implements OrderMessagingService {
    private final RabbitTemplate rabbit;

    @Override
    public void sentIngredient(Ingredient ingredient) {

    }
}
