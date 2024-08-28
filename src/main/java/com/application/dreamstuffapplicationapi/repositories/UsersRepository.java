package com.application.dreamstuffapplicationapi.repositories;

import com.application.dreamstuffapplicationapi.models.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Long> {


    @Query("SELECT u from Users u ")
    List<Users> getAllData();

    @Query("SELECT u FROM Users u WHERE u.user_id = :user_id")
    Users getById(Long user_id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Users u WHERE u.user_id = :user_id")
    void deleteById(@Param("user_id") Long user_id);




}
