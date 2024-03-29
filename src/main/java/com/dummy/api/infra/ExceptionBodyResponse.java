package com.dummy.api.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionBodyResponse {
    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;
}
