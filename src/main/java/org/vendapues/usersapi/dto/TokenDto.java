package org.vendapues.usersapi.dto;

import java.util.Date;

public class TokenDto {
    String token;

    Date expirationDate;

    String userId;

    public TokenDto(String token, Date expirationDate, String userId) {
        this.token = token;
        this.expirationDate = expirationDate;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getUserId() {
        return userId;
    }
}
