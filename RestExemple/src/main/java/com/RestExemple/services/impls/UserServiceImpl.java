package com.RestExemple.services.impls;

import com.RestExemple.dtos.UserDto;
import com.RestExemple.entities.User;
import com.RestExemple.repositories.UserRepository;
import com.RestExemple.services.interfaces.UserService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto insert(UserDto dto) {

        User user = User.builder().build();
        try{

            user = userRepository.save(User
                .builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .build());

        }catch (Exception e){
            e.printStackTrace();
        }

        return UserDto
                .builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

//        for(User user : users){
//            userDtos.add(new UserDto(user.getId(), user.getEmail()));
//        }

        users.forEach(user -> {
            userDtos.add(UserDto
                    .builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .build());
        });

        return userDtos;
    }

    @Override
    public void delete(Long id) {

        userRepository.deleteById(id);

    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).get();
        return UserDto
                .builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
