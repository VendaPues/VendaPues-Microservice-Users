package org.vendapues.usersapi.controller.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vendapues.usersapi.controller.dto.LoginDto;
import org.vendapues.usersapi.controller.dto.TokenDto;
import org.vendapues.usersapi.exception.InvalidCredentialsException;
import org.vendapues.usersapi.repository.document.User;
import org.vendapues.usersapi.service.UserService;

import java.util.Calendar;
import java.util.Date;

import static org.vendapues.usersapi.utils.Constants.TOKEN_DURATION_MINUTES;

@RestController
@RequestMapping( "v1/auth" )
public class AuthController {

    @Value( "${app.secret}" )
    String secret;

    @Value( "${CLAIMS_ROLES_KEY}" )
    String claimsRolesKey;

    @Value( "${COOKIE_NAME}" )
    String cookieName;

    private final UserService userService;

    public AuthController( @Autowired UserService userService )
    {
        this.userService = userService;
    }

    @PostMapping
    public TokenDto login(@RequestBody LoginDto loginDto )
    {
        User user = userService.findByEmail( loginDto.email );
        if ( BCrypt.checkpw( loginDto.password, user.getPasswordHash() ) )
        {
            return generateTokenDto( user );
        }
        else
        {
            throw new InvalidCredentialsException();
        }
    }

    private String generateToken( User user, Date expirationDate )
    {
        return Jwts.builder()
                .setSubject( user.getId() )
                .claim( claimsRolesKey, user.getRoles() )
                .setIssuedAt(new Date() )
                .setExpiration( expirationDate )
                .signWith( SignatureAlgorithm.HS256, secret )
                .compact();
    }

    private TokenDto generateTokenDto( User user )
    {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add( Calendar.MINUTE, TOKEN_DURATION_MINUTES );
        String token = generateToken( user, expirationDate.getTime() );
        return new TokenDto( token, expirationDate.getTime() );
    }
}
