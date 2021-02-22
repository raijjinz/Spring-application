package com.quinbay.SpringDemo.service;

import com.quinbay.SpringDemo.DTO.ProductDTO;
import com.quinbay.SpringDemo.DTO.RequestDTO;
import com.quinbay.SpringDemo.DTO.ResponseDTO;
import com.quinbay.SpringDemo.SearchService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SearchServiceImpl implements SearchService {
    public ResponseDTO returnArray(RequestDTO x){
        ArrayList<ProductDTO> arrP = new ArrayList<>();
        ProductDTO a = new ProductDTO();
        a.setDescription("Laptop");
        a.setInStock(true);
        a.setTitle("Samsung");
        a.setSalePrice(5000);
        arrP.add(a);

        ProductDTO b = new ProductDTO();
        b.setTitle("Samsung");
        b.setInStock(false);
        b.setDescription("Phone");
        b.setSalePrice(10000);
        arrP.add(b);
        ResponseDTO obj = new ResponseDTO();
        obj.setArrP(arrP);
        return obj;
    }
}
