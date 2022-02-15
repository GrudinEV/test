package ru.narbekov.testproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private String guid;
    private String function;
    private String description;
    private OP_TYPE opType;

    public enum OP_TYPE{
        I,
        U,
        D;
    }
}
