package com.RestExemple.services.interfaces;

import com.RestExemple.dtos.UserDto;
import com.RestExemple.entities.User;

import java.util.List;

public interface UserService {

    public UserDto insert(UserDto dto);

    public List<UserDto> findAll();

    public void delete(Long id);

    public UserDto findById(Long id);


}
