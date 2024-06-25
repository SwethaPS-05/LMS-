package com.pets.petsdemo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }



    @Override
    public List<Userdtls> getAllUsers() {
        return userRepository.findAll();
    }

}
