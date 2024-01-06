package com.engineerpro.first.helloworld.services;

import com.engineerpro.first.helloworld.dto.UserDTO;
import com.engineerpro.first.helloworld.exceptions.DataNotFoundException;
import com.engineerpro.first.helloworld.model.Role;
import com.engineerpro.first.helloworld.model.User;
import com.engineerpro.first.helloworld.repositories.RoleRepository;
import com.engineerpro.first.helloworld.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceImpl {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    /**
     * Create new user
     *
     * @param userDTO
     * @return User user
     */
    @Override
    public User createUser(UserDTO userDTO) {
        String phoneNumber = userDTO.getPhoneNumber();
        if (userRepository.existsByPhoneNumber(phoneNumber)) {
            throw new DataIntegrityViolationException("Phone number is already exist");
        }

        try {
            //convert from userDTO => user
            User newUser = User.builder()
                    .fullName(userDTO.getFullName())
                    .phoneNumber(userDTO.getPhoneNumber())
                    .password(userDTO.getPassword())
                    .address(userDTO.getAddress())
                    .dateOfBirth(userDTO.getDateOfBirth())
                    .facebookAccountId(userDTO.getFacebookAccountId())
                    .googleAccountId(userDTO.getGoogleAccountId())
                    .active(true)
                    .build();
            Role role = roleRepository.findById(userDTO.getRoleId()).orElseThrow(() -> new DataNotFoundException("Role not found"));
            newUser.setRole(role);
            if (userDTO.getFacebookAccountId() == 0 && userDTO.getGoogleAccountId() == 0) {
                //TODO
            }
            return userRepository.save(newUser);
        } catch (DataNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param phoneNumeber
     * @param password
     * @return
     */
    @Override
    public String login(String phoneNumeber, String password) {
        //Spring security
        return null;
    }
}
