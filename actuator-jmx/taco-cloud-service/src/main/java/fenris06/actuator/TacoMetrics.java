package fenris06.actuator;

import fenris06.model.Ingredient;
import fenris06.model.Taco;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TacoMetrics extends AbstractRepositoryEventListener<Taco> {
    private MeterRegistry meterRegistry;

    public TacoMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    protected void onAfterCreate(Taco taco) {
        List<Ingredient> ingredients = taco.getIngredients();
        ingredients.forEach(i->{
            meterRegistry.counter("tacocloud", "ingredient", i.getId()).increment();
        });
    }
}
