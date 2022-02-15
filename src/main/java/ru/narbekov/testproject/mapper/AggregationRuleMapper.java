package ru.narbekov.testproject.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.narbekov.testproject.domain.AggregationCrudRepository;
import ru.narbekov.testproject.domain.AggregationRuleEntity;
import ru.narbekov.testproject.dto.MessageDto;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Component
public class AggregationRuleMapper extends MappedObject<AggregationRuleEntity>{
    @Autowired
    public AggregationRuleMapper(AggregationCrudRepository repository) {
        super(AggregationRuleEntity.class, repository);
    }

    @Override
    public AggregationRuleEntity map(MessageDto message) {
        String guid = message.getGuid();
        AggregationRuleEntity mapped = getRepository()
                .findById(guid)
                .orElse(new AggregationRuleEntity());
        if(isNull(mapped.getGuid()))
            mapped.setGuid(guid);
        if (nonNull(message.getFunction()))
            mapped.setFunction(message.getFunction());
        if (nonNull(message.getDescription()))
            mapped.setDescription(message.getDescription());
        return mapped;
    }
}
