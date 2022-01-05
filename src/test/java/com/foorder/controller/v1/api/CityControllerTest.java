package com.foorder.controller.v1.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foorder.model.location.City;
import com.foorder.service.CityService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;


@WebMvcTest(CityController.class)
class CityControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    CityService cityService;

    private City mockCity(){
        return new City("RandomCity");
    }

    public static String asJsonString(Object city) {
        try {
            return new ObjectMapper().writeValueAsString(city);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//    @Test
//    void getHealth() throws Exception {
//        String uri = "/api/v1/city";
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
//                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        Product[] productlist = super.mapFromJson(content, Product[].class);
//        assertTrue(productlist.length > 0);
//    }

    @Test
    void getCityByName() throws Exception {
        String uri = "/api/v1/city/get";
        //        Mockito.when(mapper.mapToEntity(Mockito.any(CustomerDto.class))).thenReturn(customer);
        HashMap<String, String> city = new HashMap<>();
        city.put("name", "RandomCity");
        String actualResult = mvc
                .perform(MockMvcRequestBuilders.get(uri).param("name", "Delhi"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
//        Assertions.assertEquals(actualResult, "{\"name\":\"" +city.get("name")+"\"}");

    }

    @Test
    void getTopNUserProfiles() {
    }

    @Test
    public void createCity() throws Exception {
        String uri = "/api/v1/city/create";
        City city = this.mockCity();
        
//        Mockito.when(mapper.mapToEntity(Mockito.any(CustomerDto.class))).thenReturn(customer);
        String actualResult = mvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(city)))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
//        Assertions.assertEquals(actualResult, "{ " + custDto.getId() + " sucessfully added");
    }

    @Test
    void deleteCity() {
    }
}