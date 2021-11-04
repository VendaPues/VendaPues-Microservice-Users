package org.vendapues.usersapi.controller;

import error.exception.InvalidCredentialsException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import models.UserDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vendapues.usersapi.dto.LoginDto;
import org.vendapues.usersapi.dto.TokenDto;
import org.vendapues.usersapi.service.UserService;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("v1/auth")
public class AuthController {

    @Value("${app.secret}")
    String secret;

    @Value("${CLAIMS_ROLES_KEY}")
    String claimsRolesKey;

    @Value("${COOKIE_NAME}")
    String cookieName;

    private final UserService userService;

    public AuthController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public TokenDto login(@RequestBody LoginDto loginDto) {
        UserDocument user = userService.findByEmail(loginDto.email);
        if (BCrypt.checkpw(loginDto.password, user.getPasswordHash())) {
            return generateTokenDto(user);
        } else {
            throw new InvalidCredentialsException("Invalid credentials.");
        }
    }

    private String generateToken(UserDocument user, Date expirationDate) {
        return Jwts.builder()
                .setSubject(user.getId())
                .claim(claimsRolesKey, user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private TokenDto generateTokenDto(UserDocument user) {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE, 1440);
        String token = generateToken(user, expirationDate.getTime());
        return new TokenDto(token, expirationDate.getTime(), user.getId());
    }
}
