package com.api.user.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StandError {
    private LocalDateTime timestamp;
    private String error;
    private Integer status;
    private String path;
}
