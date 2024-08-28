package com.application.dreamstuffapplicationapi.services;

import com.application.dreamstuffapplicationapi.models.Users;
import com.application.dreamstuffapplicationapi.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAll() {
        return usersRepository.getAllData();
    }

    public Users getById(Long user_id) {
        return usersRepository.getById(user_id);
    }

    public Users addUsers(Users users) {
        return usersRepository.save(users);
    }

    public Users getUserById(Long user_id) {
        return usersRepository.getById(user_id);
    }

    public Users updateUsers(Users updatedUsers) {
        Optional<Users> optionalUsers = usersRepository.findById(updatedUsers.getUser_id());
        if (optionalUsers.isPresent()) {
            Users existingUsers = optionalUsers.get();
            existingUsers.setFirst_name(updatedUsers.getFirst_name());
            existingUsers.setLast_name(updatedUsers.getLast_name());
            existingUsers.setEmail(updatedUsers.getEmail());
            existingUsers.setPassword(updatedUsers.getPassword());
            usersRepository.save(existingUsers);
        }
        return updatedUsers;
    }
    public String deleteUsers(Long user_id) {
        usersRepository.deleteById(user_id);
        return "User removed !!!";
    }
}

