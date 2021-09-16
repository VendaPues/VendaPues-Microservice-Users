package ieti.proyecto.exception;

import ieti.proyecto.error.ErrorCodeEnum;
import ieti.proyecto.error.InternalServerErrorException;
import ieti.proyecto.exception.ServerErrorResponseDto;
import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends InternalServerErrorException
{
    public InvalidCredentialsException()
    {
        super( new ServerErrorResponseDto( "Invalid username or password", ErrorCodeEnum.INVALID_USER_CREDENTIALS,
                HttpStatus.UNAUTHORIZED ), HttpStatus.UNAUTHORIZED );
    }
}

