package com.application.dreamstuffapplicationapi.services;

import com.application.dreamstuffapplicationapi.dto.EmployeeDTO;
import com.application.dreamstuffapplicationapi.dto.LoginDTO;
import com.application.dreamstuffapplicationapi.response.LoginResponse;

public interface EmployeeService {


    String addEmployee(EmployeeDTO employeeDTO);

    LoginResponse loginEmployee(LoginDTO loginDTO);
}
