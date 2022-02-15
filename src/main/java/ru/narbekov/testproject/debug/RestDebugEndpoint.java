package ru.narbekov.testproject.debug;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.narbekov.testproject.consumer.AggregationRuleConsumer;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class RestDebugEndpoint {
    private final AggregationRuleConsumer consumer;

    @GetMapping("/test")
    public void test(){
        String json = String.format("{ \"guid\" : \"%s\", \"function\" : \"%s\", \"description\" : \"%s\", \"opType\" : \"%s\" }",
                UUID.randomUUID(),
                "function 1",
                "description is good",
                "I"
        );
        consumer.consume(json);
    }
}
