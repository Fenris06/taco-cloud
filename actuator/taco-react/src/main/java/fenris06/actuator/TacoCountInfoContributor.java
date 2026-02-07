package fenris06.actuator;

import fenris06.repository.TacoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TacoCountInfoContributor implements InfoContributor {
    private final TacoRepository tacoRepo;

    @Override
    public void contribute(Info.Builder builder) {
        long tacoCount= tacoRepo.count().block();
        Map<String, Object> tacoMap = new HashMap<>();
        tacoMap.put("count", tacoCount);
        builder.withDetail("taco-status", tacoMap);
    }
}
