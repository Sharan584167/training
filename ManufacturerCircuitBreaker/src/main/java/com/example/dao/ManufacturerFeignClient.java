package com.example.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Manufacturer;

@FeignClient("manufacturer-microservice")
public interface ManufacturerFeignClient {
	
	@RequestMapping(value="/datarest",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	Resources<Manufacturer> findAll();
}
