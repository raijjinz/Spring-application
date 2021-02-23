package com.quinbay.SpringDemo.DTO;

import java.util.ArrayList;
import java.util.List;

public class ResponseDTO {
    private ArrayList<ProductDTO> arrP ;
    private List<ProductDTO> productLocation;

    public List<ProductDTO> getProductLocation() {
        return productLocation;
    }

    public void setProductLocation(List<ProductDTO> productLocation) {
        this.productLocation = productLocation;
    }

    public ArrayList<ProductDTO> getArrP() {
        return arrP;
    }

    public void setArrP(ArrayList<ProductDTO> arrP) {
        this.arrP = arrP;
    }
}
