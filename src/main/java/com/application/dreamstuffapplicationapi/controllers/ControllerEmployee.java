package com.application.dreamstuffapplicationapi.controllers;


import com.application.dreamstuffapplicationapi.dto.EmployeeDTO;
import com.application.dreamstuffapplicationapi.dto.LoginDTO;
import com.application.dreamstuffapplicationapi.response.LoginResponse;
import com.application.dreamstuffapplicationapi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/employee")
public class ControllerEmployee {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
