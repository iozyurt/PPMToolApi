package ismail.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ProjectIdException.class})
    public ResponseEntity<Object> handleProjectIdException(ProjectIdException e, WebRequest webRequest) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ProjectIdExceptionResponse response = new ProjectIdExceptionResponse(
                e.getMessage(),
                badRequest,
                badRequest.value()
        );
        return new ResponseEntity<>(response, badRequest);
    }

    @ExceptionHandler(value = {ProjectNotFoundException.class})
    public ResponseEntity<Object> handleNotFound(ProjectNotFoundException e, WebRequest webRequest) {
        HttpStatus badRequest = HttpStatus.NOT_FOUND;

        ProjectIdExceptionResponse response = new ProjectIdExceptionResponse(
                e.getMessage(),
                badRequest,
                badRequest.value()
        );
        return new ResponseEntity<>(response, badRequest);
    }
}
