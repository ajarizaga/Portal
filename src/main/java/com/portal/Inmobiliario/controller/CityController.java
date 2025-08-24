/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.controller;

import com.portal.Inmobiliario.model.dto.City.CityResponse;
import com.portal.Inmobiliario.model.dto.City.CreateCityRequest;
import com.portal.Inmobiliario.service.ICityService;
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
@RequestMapping("/api/cities")
public class CityController 
{
    private final ICityService cityService;
    
    @GetMapping
    public List<CityResponse> findAlll()
    {
        return cityService.findAll();
    }
    
    @GetMapping("/{id}")
    public CityResponse findById(@PathVariable Long id)
    {
        return cityService.findById(id);
    }
    
    @GetMapping("/province/{id}")
    public List<CityResponse> findAllByProvinceId(@PathVariable Long id)
    {
        return cityService.findByProvinceId(id);
    }
    
    @PostMapping
    public ResponseEntity<CityResponse> save(@Valid @RequestBody CreateCityRequest request)
    {
        CityResponse response =cityService.save(request);
        return ResponseEntity.created(URI.create("/api/cities/" + response.getId())).body(response);
    }
    
    @PutMapping("/{id}")
    public CityResponse update(@PathVariable Long id, @Valid @RequestBody CreateCityRequest request)
    {
        return cityService.update(id, request);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id)
    {
        cityService.deleteById(id);
    }
}
