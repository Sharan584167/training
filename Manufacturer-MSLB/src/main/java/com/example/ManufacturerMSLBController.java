package com.example;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.model.Manufacturer;

@RestController
public class ManufacturerMSLBController {
	
	@Autowired
	//private ManufacturerFeignClient feignClient;
	private LoadBalancerClient loadBalancerClient; 

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/" , method=RequestMethod.GET)
	@ResponseBody
	public Resources<Manufacturer> getData(){
		ServiceInstance serviceInstance = 
	    loadBalancerClient.choose("manufacturer-microservice");
		RestTemplate restTemplate = new RestTemplate();
		Resources<Manufacturer> resources = null;
		try {
			resources = (Resources<Manufacturer>)restTemplate.getForObject(
					new URI(serviceInstance.getUri().toString().concat("/datarest")), Object.class);
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
		}
		return resources;
	}
	
	/*@RequestMapping(value="/getByDate" , method=RequestMethod.GET)
	@ResponseBody
	public Resources<Manufacturer> getByDate(@RequestParam("startDate") @DateTimeFormat(iso=ISO.DATE) Date startDate){
		return feignClient.findByDateBefore(startDate);
	}*/
	
	@RequestMapping(value="/" , method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String getData1() throws URISyntaxException{
		ServiceInstance serviceInstance = 
	    loadBalancerClient.choose("manufacturer-microservice");
		RestTemplate restTemplate = new RestTemplate();
		Resources<Manufacturer> resources = null;
		/*try {
			resources = (Resources<Manufacturer>)restTemplate.getForObject(
					new URI(serviceInstance.getUri().toString().concat("/datarest")), Object.class);
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
		}*/
		
		String resourcesStr = restTemplate.getForObject(
				new URI(serviceInstance.getUri().toString().concat("/datarest")), String.class);
		return resourcesStr;
	}
}
