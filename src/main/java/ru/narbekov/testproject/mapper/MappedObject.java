package ru.narbekov.testproject.mapper;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import ru.narbekov.testproject.domain.CrudRepository;
import ru.narbekov.testproject.dto.MessageDto;

@Slf4j
@Getter
public abstract class MappedObject<T> {
    private final Class<T> entityClass;
    private final CrudRepository<T> repository;

    public MappedObject(Class<T> entityClass, CrudRepository<T> repository) {
        this.entityClass = entityClass;
        this.repository = repository;
    }

    public abstract T map(MessageDto message);

    public void handle(MessageDto messageDto) {
        switch (messageDto.getOpType()) {
            case I:
            case U:
                save(
                        map(messageDto)
                );
                break;
            case D:
                delete(messageDto.getGuid());
        }
    }

    protected void save(T entity) {
        repository.save(entity);
    }

    protected void delete(String guid) {
        repository.deleteById(guid);
    }
}
