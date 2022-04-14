package com.nguyenkietblog.nkblog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class ErrorMessage {
    private HttpStatus status;
    private String message;
}
