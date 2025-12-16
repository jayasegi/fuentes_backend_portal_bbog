package com.portal.api.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.portal.api.exceptions.CustomException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Error de validación (@Valid) en DTOs
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(
		MethodArgumentNotValidException ex,
		HttpServletRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
			.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		ErrorResponse response = new ErrorResponse(
			LocalDateTime.now(),
			HttpStatus.BAD_REQUEST.value(),
			"Validation error",
			request.getRequestURI(),
			errors
		);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	/**
	 * Error de validación en parámetros de URL (@Validated)
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handleConstraintViolation(
		ConstraintViolationException ex, HttpServletRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getConstraintViolations().forEach(
			v -> errors.put(v.getPropertyPath().toString(), v.getMessage())
		);

		ErrorResponse response = new ErrorResponse(
			LocalDateTime.now(),
			HttpStatus.BAD_REQUEST.value(),
			"Constraint violation",
			request.getRequestURI(),
			errors
		);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	/**
	 * Acceso denegado (fallos de rol o autorización)
	 */
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorResponse> handleAccessDenied(
		AccessDeniedException ex, HttpServletRequest request) {

		ErrorResponse response = new ErrorResponse(
			LocalDateTime.now(),
			HttpStatus.FORBIDDEN.value(),
			"Access denied",
			request.getRequestURI()
		);
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
	}

	/**
	 * Manejo de excepciones personalizadas (RuntimeException)
	 */
	//ResponseEntity<ErrorResponse> handleRuntime(RuntimeException ex, HttpServletRequest request) 
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleRuntime(RuntimeException ex) {

		ErrorResponse response = new ErrorResponse(
			LocalDateTime.now(),
			HttpStatus.BAD_REQUEST.value(),
			ex.getMessage(),
			"" //request.getRequestURI()
		);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> customRuntime(CustomException ex) {

		ErrorResponse response = new ErrorResponse(
			LocalDateTime.now(),
			ex.getHttpCode(), // HttpStatus.BAD_REQUEST.value(),
			ex.getMessage(),
			"" //request.getRequestURI()
		);

		return ResponseEntity.status(ex.getHttpCode()).body(response); //HttpStatus.BAD_REQUEST
	}

	/**
	 * Manejo de errores desconocidos
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneral(
		Exception ex, HttpServletRequest request) {

		ErrorResponse response = new ErrorResponse(
			LocalDateTime.now(),
			HttpStatus.INTERNAL_SERVER_ERROR.value(),
			"Internal server error",
			request.getRequestURI()
		);

		ex.printStackTrace(); // opcional: logear

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}

	/**
	 * Clase interna para estandarizar el error
	 */
	public static class ErrorResponse {

		private LocalDateTime timestamp;
		private int status;
		private String error;
		private String path;
		private Map<String, String> details;

		public ErrorResponse(LocalDateTime timestamp, int status, String error, String path) {
			this.timestamp = timestamp;
			this.status = status;
			this.error = error;
			this.path = path;
		}

		public ErrorResponse(LocalDateTime timestamp, int status, String error,
			String path, Map<String, String> details) {
			this(timestamp, status, error, path);
			this.details = details;
		}

		public LocalDateTime getTimestamp() { return timestamp; }
		public int getStatus() { return status; }
		public String getError() { return error; }
		public String getPath() { return path; }
		public Map<String, String> getDetails() { return details; }

		public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
		public void setStatus(int status) { this.status = status; }
		public void setError(String error) { this.error = error; }
		public void setPath(String path) { this.path = path; }
		public void setDetails(Map<String, String> details) { this.details = details; }
	}
}
