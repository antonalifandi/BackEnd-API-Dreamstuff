package com.application.dreamstuffapplicationapi.services;

import com.application.dreamstuffapplicationapi.dto.EmployeeDTO;
import com.application.dreamstuffapplicationapi.dto.LoginDTO;
import com.application.dreamstuffapplicationapi.models.Employee;
import com.application.dreamstuffapplicationapi.repositories.EmployeeRepository;
import com.application.dreamstuffapplicationapi.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee(
                 employeeDTO.getEmployeeid(),
                 employeeDTO.getEmployeename(),
                 employeeDTO.getEmail(),

                 this.passwordEncoder.encode(employeeDTO.getPassword())
        );

        employeeRepository.save(employee);

        return employee.getEmployeename();
    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        String msg="";
        Employee employee1 = employeeRepository.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employee> employee = employeeRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                        if (employee.isPresent()) {
                            return new LoginResponse("Login Success", true);
                        }else {
                            return new LoginResponse("Login Failed", false);
                        }
            }else {
                return new LoginResponse("Password Not Match", false);
            }
        }else {
            return new LoginResponse("Email Not Exits", false);
        }
    }
}
