package ru.narbekov.testproject.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.narbekov.testproject.domain.AggregationRuleEntity;
import ru.narbekov.testproject.dto.MessageDto;
import ru.narbekov.testproject.service.IntegrationService;

@Service
@Slf4j
@RequiredArgsConstructor
public class AggregationRuleConsumer {
    private final ObjectMapper objectMapper;
    private final IntegrationService service;

    public void consume(String genericRecord) {
        try {
            MessageDto messageDto = objectMapper.readValue(genericRecord, MessageDto.class);
            service.handle(messageDto, AggregationRuleEntity.class);
        } catch (JsonProcessingException ex) {
            log.error("ERROR parsing message", ex);
        }
    }
}
