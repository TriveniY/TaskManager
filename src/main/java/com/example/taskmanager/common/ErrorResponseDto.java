package com.example.taskmanager.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ErrorResponseDto {
    private int status;
    private String message;

}
