package com.pets.petsdemo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserleavesRepository userleavesRepository;

    public UserServiceImpl(UserRepository userRepository, UserleavesRepository userleavesRepository) {
        this.userRepository = userRepository;
        this.userleavesRepository = userleavesRepository;
    }

    @Override
    public List<Userdtls> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Userleaves> getAllUserLeaves() {
        return userleavesRepository.findAll();
    }

    @Override
    public Userdtls getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUser(Userdtls user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}