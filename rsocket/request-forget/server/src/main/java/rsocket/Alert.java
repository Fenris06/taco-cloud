package rsocket;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Alert {
    private Level level;
    private String orderBy;
    private Instant orderAt;

    public enum Level {
        YELLOW, ORANGE, RED, BLACK
    }
}

