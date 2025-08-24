/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.controller;

import com.portal.Inmobiliario.model.dto.Country.CountryResponse;
import com.portal.Inmobiliario.model.dto.Country.CreateCountryRequest;
import com.portal.Inmobiliario.service.ICountryService;
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
@RequestMapping("/api/countries")
public class CountryController 
{
    private final ICountryService countryService;
    
    @GetMapping
    public List<CountryResponse> findAll()
    {
        return countryService.findAll();
    }
    
    @GetMapping("/{id}")
    public CountryResponse findById(@PathVariable Long id)
    {
        return countryService.findById(id);
    }
    
    @PostMapping
    public ResponseEntity<CountryResponse> save(@Valid @RequestBody CreateCountryRequest request)
    {
        CountryResponse response = countryService.save(request);
        return ResponseEntity.created(URI.create("(api/countries/" + response.getId())).body(response);
    }
    
    @PutMapping("/{id}")
    public CountryResponse update(@PathVariable Long id, @Valid @RequestBody CreateCountryRequest request)
    {
        return countryService.update(id, request);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id)
    {
        countryService.deleteById(id);
    }
}
