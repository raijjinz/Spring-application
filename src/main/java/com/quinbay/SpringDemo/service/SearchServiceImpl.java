package com.quinbay.SpringDemo.service;

import com.quinbay.SpringDemo.Client.SearchClient;
import com.quinbay.SpringDemo.DTO.ProductDTO;
import com.quinbay.SpringDemo.DTO.RequestDTO;
import com.quinbay.SpringDemo.DTO.ResponseDTO;
import com.quinbay.SpringDemo.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class SearchServiceImpl implements SearchService {


    @Autowired
    private SearchClient searchClient;








    public ResponseDTO returnArray(RequestDTO x){
        String brand = (x.getSearchTerm()); // q= samsung
        String location = "stockLocation:" + x.getLocation(); // q= "sl:" +
        ArrayList<ProductDTO> arrProducts = getArrayOfProducts(brand);
        ArrayList<ProductDTO> arrLocProducts = getArrayOfProducts(location);

        ResponseDTO obj = new ResponseDTO();
        obj.setArrP(arrProducts);
        obj.setProductLocation(arrLocProducts);
        return obj;


    }


    public ArrayList<ProductDTO> getArrayOfProducts(String x)  {
        ArrayList<ProductDTO> arrpto = new ArrayList<>();
        Map<String, Object> productResponse = searchClient.getProducts(x);


        Map<String, Object> response = (Map<String, Object>) productResponse.get("response");
        List<Map<String, Object>> products = (List<Map<String, Object>>) (response.get("docs"));
        for (Map<String, Object> mapObj : products) {
            ProductDTO product = new ProductDTO();
            product.setTitle(mapObj.get("name").toString());
            if ((Integer) mapObj.get("isInStock") > 0) {
                product.setInStock(true);
            } else {
                product.setInStock(false);
            }
            product.setSalePrice(Double.parseDouble(mapObj.get("offerPrice").toString()));
            product.setDescription(mapObj.get("description").toString());
            arrpto.add(product);
        }
        return arrpto;
    }

//        Map<String, Object> locresponse = (Map<String, Object>) productLocResponse.get("response");
//        List<Map<String, Object>> locproducts = (List<Map<String, Object>>) (locresponse.get("docs"));
//        ArrayList<ProductDTO> productLocationDTOs = new ArrayList<>();
//        for (Map<String,Object> mapObj:locproducts) {
//                ProductDTO product = new ProductDTO();
//                product.setTitle(mapObj.get("name").toString());
//                if ((Integer) mapObj.get("isInStock") > 0) {
//                    product.setInStock(true);
//                } else {
//                    product.setInStock(false);
//                }
//                product.setSalePrice(Double.parseDouble(mapObj.get("offerPrice").toString()));
//                product.setDescription(mapObj.get("description").toString());
//            productLocationDTOs.add(product);
//  }




}







//        product.setDescription("Samsung galaxy..");
//        product.setSalePrice(20000);
//        product.setInStock(true);
//        product.setTitle("Samsung galaxy s5");


//        ArrayList<ProductDTO> arrP = new ArrayList<>();
//        ProductDTO a = new ProductDTO();
//        a.setDescription("Laptop");
//        a.setInStock(true);
//        a.setTitle("Samsung");
//        a.setSalePrice(5000);
//        arrP.add(a);
//
//        ProductDTO b = new ProductDTO();
//        b.setTitle("Samsung");
//        b.setInStock(false);
//        b.setDescription("Phone");
//        b.setSalePrice(10000);
//        arrP.add(b);
//        ResponseDTO obj = new ResponseDTO();
//        obj.setArrP(arrP);
//        return obj;



