package com.example.project;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HospitalController {

    @Autowired
	private HospitalService hospitalService;
	
    @GetMapping("/test/hospitals")
    public @ResponseBody List<Hospital> getAllHospitals() throws Exception {
		return hospitalService.getAllHospitals();
    }
    @GetMapping("/test/hospitals/{id}")
    public @ResponseBody Hospital getHospital(@PathVariable("id") int id) throws Exception {

            return hospitalService.getHospital(id);
        }

}
