package com.example.project;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot2ApplicationTests {


private MockMvc mockMvc;
    
    @Autowired
    WebApplicationContext context;
    
   

    @Before
    public void setup() {
        //this.mockMvc = MockMvcBuilders.standaloneSetup(new WeatherApiController()).build();
    	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


	@Test
	public void retrievetest_ok() throws Exception {
		
		 mockMvc.perform(get("/test/hospitals/1001" )).andDo(print())
	                .andExpect(status().isOk())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1001))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Apollo Hospital"))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.rating").value(3.8))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.city").value("Chennai"));

	}

	@Test
	public void retrievetest_list_ok() throws Exception {
		
		 mockMvc.perform(get("/test/hospitals" )).andDo(print())
	                .andExpect(status().isOk());
	                

	}
    
}
