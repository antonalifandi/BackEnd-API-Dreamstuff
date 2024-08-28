package com.application.dreamstuffapplicationapi.services;


import com.application.dreamstuffapplicationapi.models.Users;

import java.util.List;

public interface UsersService {

    public List<Users> getAll();

    Users getById(Long user_id);

    Users addUsers(Users users);

    Users updateUsers(Users users);

    String deleteUsers(Long user_id);

    Users getUserById(Long id);
}
