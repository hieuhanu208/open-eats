package com.engineerpro.first.helloworld.Service;

import com.engineerpro.first.helloworld.Entity.User;
import com.engineerpro.first.helloworld.dto.UserDto;
import com.engineerpro.first.helloworld.repository.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {
    @Autowired
    UserInterface userInterface;
    public List<UserDto> getAllUsers(){
        List<User> listUser = userInterface.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : listUser) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setUser_name(user.getUser_name());
            userDto.setPassword(user.getPassword());
            userDto.setFull_name(user.getFull_name());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
}
