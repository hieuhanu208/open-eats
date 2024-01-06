package com.engineerpro.first.helloworld.services;

import com.engineerpro.first.helloworld.dto.UserDTO;
import com.engineerpro.first.helloworld.exceptions.DataNotFoundException;
import com.engineerpro.first.helloworld.model.User;

public interface UserServiceImpl {
    User createUser(UserDTO userDTO) throws DataNotFoundException;

    String login(String phoneNumeber, String password);
}
