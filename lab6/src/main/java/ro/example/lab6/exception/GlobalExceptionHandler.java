package ro.example.lab6.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

// EXERCISE 2 - Global Exception Handling

// DONE: Add @RestControllerAdvice to handle exceptions globally.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // DONE: Add @ExceptionHandler for EventNotFoundException.
    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEventNotFound(
            EventNotFoundException ex,
            HttpServletRequest request) {

        // DONE: Return 404 Not Found.
        // DONE: Include the following fields in a JSON response:
        // - status
        // - error
        // - message
        // - path

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                "status", HttpStatus.NOT_FOUND.value(),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", ex.getMessage(),
                "path", request.getRequestURI()
        ));
    }

    // EXERCISE 4 - Handle validation errors

    // DONE: Add @ExceptionHandler for
    // MethodArgumentNotValidException.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        // DONE: Extract validation errors for each field.
        // Hint: Use ex.getBindingResult().getFieldErrors()
        Map<String, String> fieldErrors = new LinkedHashMap<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.put(
                    fieldError.getField(),
                    fieldError.getDefaultMessage()
            );
        }

        // DONE: Return 400 Bad Request with:
        // - status: 400
        // - error: "Bad Request"
        // - message: "Validation failed"
        // - fieldErrors: map of field names and error messages

        return ResponseEntity.badRequest().body(Map.of(
                "status", HttpStatus.BAD_REQUEST.value(),
                "error", HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "message", "Validation failed",
                "fieldErrors", fieldErrors
        ));
    }
}
