package com.quinbay.SpringDemo.controller;
import com.quinbay.SpringDemo.dto.MyRequestDto;
import com.quinbay.SpringDemo.dto.myResponseDTO;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
    @GetMapping(path = "/hello")
    public String hello(){
        return "success";

    }

    @PostMapping(path = "/hello-post")
    public String hellopost(){
        return "Post request sent";

    }

    @GetMapping(path ="/hello-query")
    public String helloQuery(@RequestParam String query){
        return "the query param was" + query;


    }

    @PostMapping(path = "/regist")
    public String registerUser(@RequestBody MyRequestDto request){
        return request.toString();

    }


    @GetMapping(path = "/employee/{employeeId}")
    public myResponseDTO getEmployeeDetails(@PathVariable String employeeId){
        myResponseDTO response = new myResponseDTO();
        response.setId(employeeId);
        return response;
    }
}
