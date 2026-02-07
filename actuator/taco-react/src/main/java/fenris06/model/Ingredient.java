package fenris06.model;

import lombok.*;
import org.springframework.data.annotation.Id;


@Data
@EqualsAndHashCode(exclude = "id")
@RequiredArgsConstructor
@NoArgsConstructor()
public class Ingredient {
    @Id
    private Long id;
    private @NonNull String slug;
    private @NonNull String name;
    private @NonNull Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}
