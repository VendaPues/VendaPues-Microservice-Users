package org.vendapues.usersapi.controller;

import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vendapues.usersapi.service.UserService;

import javax.annotation.security.RolesAllowed;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Object findById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(userService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }

    @PostMapping
    public Object create(@RequestBody UserDto userDto) {
        try {
            return ResponseEntity.ok(userService.create(userDto));
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("ADMIN")
    public Object delete(@PathVariable String id) {
        try {
            return ResponseEntity.ok(userService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }
}
