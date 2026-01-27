package fenris06.model;

import lombok.*;
import org.springframework.data.annotation.Id;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "id")
@RequiredArgsConstructor
@NoArgsConstructor()
public class Taco {
    @Id
    private Long id;

    private @NonNull String name;

    private Set<Long> ingredientIds = new HashSet<>();

    public void addIngredient(Ingredient ingredient) {
        ingredientIds.add(ingredient.getId());
    }
}

