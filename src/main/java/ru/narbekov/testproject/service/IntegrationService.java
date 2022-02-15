package ru.narbekov.testproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.narbekov.testproject.dto.MessageDto;
import ru.narbekov.testproject.mapper.MappedObject;

import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class IntegrationService {
    private final Map<String, MappedObject<?>> mapperVault;

    public void handle(MessageDto message, Class<?> clazz){
        mapperVault.values().stream()
                .filter(obj -> clazz.equals(obj.getEntityClass()))
                .findFirst()
                .ifPresent(obj -> obj.handle(message));
    }
}
