package fenris06.service;

import fenris06.model.Ingredient;

public interface OrderMessagingService {

    void sentIngredient(Ingredient ingredient);
}
