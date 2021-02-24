package com.quinbay.SpringDemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinbay.SpringDemo.Client.SearchClient;
import com.quinbay.SpringDemo.DTO.RequestDTO;
import com.quinbay.SpringDemo.DTO.ResponseDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
class SearchServiceImplTest {
    @InjectMocks
    private SearchServiceImpl searchService;
    @Mock
    private SearchClient searchClient;
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    public void teardown(){

    }
    @Test
    void returnArray() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> searchTermMockObject = objectMapper.readValue(new URL("file:src/test/resources/search.mock"), Map.class);


        Mockito.when(searchClient.getProducts("samsung")).thenReturn(searchTermMockObject);
        Mockito.when(searchClient.getProducts("stockLocation:Jakarta")).thenThrow(NullPointerException.class);
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setSearchTerm("samsung");
        requestDTO.setLocation("Jakarta");
        ResponseDTO response = searchService.returnArray(requestDTO);
        assertEquals(response.getArrP().size(),10);
        assertEquals(response.getProductLocation(),null);
        Mockito.verify(searchClient).getProducts("samsung");
        Mockito.verify(searchClient).getProducts("stockLocation:Jakarta");
    }
}