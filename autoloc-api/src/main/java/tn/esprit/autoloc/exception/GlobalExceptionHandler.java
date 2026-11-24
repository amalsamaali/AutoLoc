package tn.esprit.autoloc.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Gestion centralisee des erreurs de l'API.
 * Intercepte notamment les echecs de validation (@Valid) et renvoie un JSON lisible.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Renvoie un corps JSON listant les champs invalides et leur message
     * lorsque la validation d'un @RequestBody echoue (statut 400).
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> champsInvalides = new LinkedHashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            champsInvalides.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        Map<String, Object> corps = new LinkedHashMap<>();
        corps.put("timestamp", LocalDateTime.now());
        corps.put("status", HttpStatus.BAD_REQUEST.value());
        corps.put("erreur", "Erreur de validation");
        corps.put("champsInvalides", champsInvalides);

        return ResponseEntity.badRequest().body(corps);
    }
}
