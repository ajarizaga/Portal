/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.controller;

import com.portal.Inmobiliario.model.dto.Amenity.AmenityResponse;
import com.portal.Inmobiliario.model.dto.Amenity.CreateAmenityRequest;
import com.portal.Inmobiliario.service.IAmenityService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/amenities")
public class AmenityController 
{
    private final IAmenityService amenityService;
    
    @GetMapping
    public List<AmenityResponse> findAll()
    {
        return amenityService.findAll();
    }
    
    @GetMapping("/{id}")
    public AmenityResponse findById(@PathVariable Long id)
    {
        return amenityService.findById(id);
    }
    
    @PostMapping
    public ResponseEntity<AmenityResponse> save (@Valid @RequestBody CreateAmenityRequest request)
    {
       AmenityResponse response = amenityService.save(request);
       return ResponseEntity.created(URI.create("api/amenities/" + response.getId())).body(response);
    }
    
    @PutMapping("/{id}")
    public AmenityResponse update(@PathVariable Long id, @RequestBody CreateAmenityRequest request)
    {
        return amenityService.update(id, request);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        amenityService.deleteById(id);
    }
}
