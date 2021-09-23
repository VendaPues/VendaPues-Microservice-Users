package org.vendapues.usersapi.exception;

import org.vendapues.usersapi.error.ErrorCodeEnum;
import org.vendapues.usersapi.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends InternalServerErrorException
{
    public UserNotFoundException()
    {
        super( new ServerErrorResponseDto( "User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND ),
                HttpStatus.NOT_FOUND );
    }
}
