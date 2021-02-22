package com.quinbay.SpringDemo.service.impl;

import com.quinbay.SpringDemo.dto.MyRequestDto;
import com.quinbay.SpringDemo.service.UserInterface;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserInterfaceImpl implements UserInterface {

    public UserInterfaceImpl(){
        System.out.println("Inside user service constructor");
    }

    @PostConstruct
    public void init(){
        System.out.println("Inside user service post constr");
    }
    @Override
    public boolean updateEmployee(MyRequestDto req, String id) {
        return false;
    }
}
