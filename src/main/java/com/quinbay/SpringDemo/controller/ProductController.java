package com.quinbay.SpringDemo.controller;

import com.quinbay.SpringDemo.DTO.RequestDTO;
import com.quinbay.SpringDemo.DTO.ResponseDTO;
import com.quinbay.SpringDemo.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private SearchService searchService;

    @PostMapping(path = "/search")
    public ResponseDTO search(@RequestBody RequestDTO req){
        return searchService.returnArray(req);
    }
}
