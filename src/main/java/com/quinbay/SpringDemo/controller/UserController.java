package com.quinbay.SpringDemo.controller;

import com.quinbay.SpringDemo.dto.EmployeeDTO;
import com.quinbay.SpringDemo.dto.MyRequestDto;
import com.quinbay.SpringDemo.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {


    public UserController(UserInterface userInterface) {
        this.userInterface = userInterface;
        System.out.println("Inside UserController constructor");
    }

    @PostConstruct
    public void init(){
        System.out.println("Inside usercontroller post constr");
    }
    @Autowired
    private UserInterface userInterface;

    @PostMapping(path = "/update/employee/{id}")
    public boolean updateEmployee(@PathVariable String id, @RequestBody MyRequestDto request){
        return userInterface.updateEmployee(request, id);

    }
}
