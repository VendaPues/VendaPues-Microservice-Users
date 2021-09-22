package org.venda.pues.usersapi.exception;

import org.springframework.http.HttpStatus;
import org.venda.pues.usersapi.error.ErrorCodeEnum;
import org.venda.pues.usersapi.error.InternalServerErrorException;

public class InvalidCredentialsException extends InternalServerErrorException
{
    public InvalidCredentialsException()
    {
        super( new ServerErrorResponseDto( "Invalid username or password", ErrorCodeEnum.INVALID_USER_CREDENTIALS,
                HttpStatus.UNAUTHORIZED ), HttpStatus.UNAUTHORIZED );
    }
}

