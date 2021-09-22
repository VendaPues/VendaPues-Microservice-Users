package org.venda.pues.usersapi.controller.user;

import java.util.Date;

public class TokenDto
{

    String token;

    Date expirationDate;

    public TokenDto( String token, Date expirationDate )
    {
        this.token = token;
        this.expirationDate = expirationDate;
    }

    public String getToken()
    {
        return token;
    }

    public Date getExpirationDate()
    {
        return expirationDate;
    }
}
