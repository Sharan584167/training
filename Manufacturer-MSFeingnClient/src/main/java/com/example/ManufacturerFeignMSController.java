package com.example;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Manufacturer;

@RestController
public class ManufacturerFeignMSController {
	
	@Autowired
	private ManufacturerFeignClient feignClient;

	@RequestMapping(value="/" , method=RequestMethod.GET)
	@ResponseBody
	public Resources<Manufacturer> getData(){
		return feignClient.findAll();
	}
	
	@RequestMapping(value="/getByDate" , method=RequestMethod.GET)
	@ResponseBody
	public Resources<Manufacturer> getByDate(@RequestParam("startDate") @DateTimeFormat(iso=ISO.DATE) Date startDate){
		return feignClient.findByDateBefore(startDate);
	}
}
