package com.pets.petsdemo;

import java.util.List;

public interface UserService {
    List<Userdtls> getAllUsers();
    List<Userleaves> getAllUserLeaves();
    Userdtls getUserById(int id);
    void saveUser(Userdtls user);
    void deleteUserById(int id);
    
}