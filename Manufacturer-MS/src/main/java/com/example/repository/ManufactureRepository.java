package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.example.model.Manufacturer;

@RepositoryRestResource(path="/datarest")
public interface ManufactureRepository extends MongoRepository<Manufacturer, Integer> {

	List<Manufacturer> findByStartDateBefore(@Param("startDate" )
								@DateTimeFormat(iso=ISO.DATE)Date date);
}
