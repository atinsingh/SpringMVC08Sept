package io.pragra.learning.mvc.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentNotFoundExceptions extends RuntimeException {

    public StudentNotFoundExceptions(String message) {
        super(message);
    }
}
