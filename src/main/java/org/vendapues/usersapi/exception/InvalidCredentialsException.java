package org.vendapues.usersapi.exception;

import org.springframework.http.HttpStatus;
import org.vendapues.usersapi.error.ErrorCodeEnum;
import org.vendapues.usersapi.error.InternalServerErrorException;

public class InvalidCredentialsException extends InternalServerErrorException
{
    public InvalidCredentialsException()
    {
        super( new ServerErrorResponseDto( "Invalid username or password", ErrorCodeEnum.INVALID_USER_CREDENTIALS,
                HttpStatus.UNAUTHORIZED ), HttpStatus.UNAUTHORIZED );
    }
}
