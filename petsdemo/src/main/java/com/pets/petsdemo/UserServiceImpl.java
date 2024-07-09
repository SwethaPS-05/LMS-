package com.pets.petsdemo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserleavesRepository userleavesRepository;

    

    public UserServiceImpl(UserRepository userRepository,UserleavesRepository userleavesRepository) {
        this.userRepository = userRepository;
        this.userleavesRepository = userleavesRepository;
    }



    @Override
    public List<Userdtls> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Userleaves> getAllUserleaves(){
        return userleavesRepository.findAll();
    }

}
