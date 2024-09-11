package com.application.dreamstuffapplicationapi.repositories;

import com.application.dreamstuffapplicationapi.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findOneByEmailAndPassword(String email, String password);
    Employee findByEmail(String email);


}
