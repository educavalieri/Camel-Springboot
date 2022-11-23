package com.RestExemple.controllers;

import com.RestExemple.dtos.UserDto;
import com.RestExemple.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/insert")
    public ResponseEntity<UserDto> insert(@RequestBody UserDto dto){
        UserDto userDto = userService.insert(dto);
        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        UserDto userDto = userService.findById(id);
        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        List<UserDto> userDtoList = userService.findAll();
        return ResponseEntity.ok().body(userDtoList);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.notFound().build();
    }
}
