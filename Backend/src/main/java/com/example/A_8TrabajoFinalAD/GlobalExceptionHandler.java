package com.example.A_8TrabajoFinalAD;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Maneja el error cuando un producto no es encontrado
	@ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> manejarProductoNoEncontrado(ProductoNoEncontradoException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Producto no encontrado");
        response.put("mensaje", ex.getMessage());
        response.put("status", HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Maneja los errores de validación
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> manejarValidacionError(MethodArgumentNotValidException ex) {
        StringBuilder mensajeError = new StringBuilder("Error de validación: ");
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            mensajeError.append(error.getDefaultMessage()).append(", ");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensajeError.toString());
    }

    // Maneja errores genéricos
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarErrorGenerico(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor: " + ex.getMessage());
    }
}

