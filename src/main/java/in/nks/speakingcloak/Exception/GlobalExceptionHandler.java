package in.nks.speakingcloak.Exception;

import java.time.LocalDateTime;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 * Global Exception Handler Class
 * @Author: Naresh
 */
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<?> handleInvalidInputException(InvalidDataException ex) {
		ErrorResponse response = new ErrorResponse(LocalDateTime.now(), ex.getMessage());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception ex) {
		ErrorResponse response = new ErrorResponse(LocalDateTime.now(), ex.getMessage());
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntimeException(RuntimeException ex) {
		ErrorResponse response = new ErrorResponse(LocalDateTime.now(), ex.getMessage());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}

}
