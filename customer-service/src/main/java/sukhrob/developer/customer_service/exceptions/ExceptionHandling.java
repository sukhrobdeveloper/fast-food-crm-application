package sukhrob.developer.customer_service.exceptions;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<?> handleException(EntityExistsException exception) {
        return ResponseEntity
                .status(HttpStatusCode.valueOf(409))
                .body(exception.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleException(EntityNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatusCode.valueOf(404))
                .body(ex.getMessage());
    }

}
