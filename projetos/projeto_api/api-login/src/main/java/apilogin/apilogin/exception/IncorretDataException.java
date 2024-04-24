package apilogin.apilogin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class IncorretDataException extends Exception{

    public IncorretDataException(String message) {
        super(message);
    }
}
