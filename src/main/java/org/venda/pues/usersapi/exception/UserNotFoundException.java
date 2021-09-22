package org.venda.pues.usersapi.exception;

import org.venda.pues.usersapi.error.ErrorCodeEnum;
import org.venda.pues.usersapi.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException
    extends InternalServerErrorException
{
    public UserNotFoundException()
    {
        super( new ServerErrorResponseDto( "User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND ),
               HttpStatus.NOT_FOUND );
    }
}
