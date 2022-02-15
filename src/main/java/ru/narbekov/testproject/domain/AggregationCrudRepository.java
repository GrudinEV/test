package ru.narbekov.testproject.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AggregationCrudRepository implements CrudRepository<AggregationRuleEntity>{
    @Override
    public Optional<AggregationRuleEntity> findById(String id) {
        log.info("find entity");
        return Optional.empty();
    }

    @Override
    public AggregationRuleEntity save(AggregationRuleEntity entity) {
        log.info("save entity");
        return null;
    }

    @Override
    public void deleteById(String guid) {
        log.info("delete entity");
    }
}
