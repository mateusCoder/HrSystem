package com.mateus.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class StandardError {

    private LocalDateTime timestamp;

    private String error;

    private Integer status;

    private String path;
}
