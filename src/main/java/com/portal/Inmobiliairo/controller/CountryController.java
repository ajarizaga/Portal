/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliairo.controller;

import com.portal.Inmobiliairo.dto.CountryDTO;
import com.portal.Inmobiliairo.dto.CountryResponse;
import com.portal.Inmobiliairo.service.ICountryService;
import com.portal.Inmobiliairo.utilities.AppConstants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gamer
 */
@RestController
@RequestMapping("/api/countries")
public class CountryController {
    
    @Autowired
    private ICountryService countryService;
    
    @PostMapping
    public ResponseEntity<CountryDTO> saveCountry(@RequestBody CountryDTO countryDTO)
    {
        return new ResponseEntity<>(countryService.createCountry(countryDTO),HttpStatus.CREATED);
    }
    
    @GetMapping
    private CountryResponse listCountries(
            @RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER_DEFAULT, required = false) int pageNumber,
            @RequestParam(value = "pageZise", defaultValue = AppConstants.PAGE_SIZE_DEFAULT, required = false) int pageZise,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.ORDER_BY_DEFAULT, required = false) String orderBy,
            @RequestParam(value = "sortDirection", defaultValue = AppConstants.ORDERE_BY_DIRECTION_DEFAULT, required = false) String sortDirection)
    {
        return countryService.getAllCountries(pageNumber, pageZise, orderBy, sortDirection);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable(name = "id") Long id)
    {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> updateCountry(@RequestBody CountryDTO countryDTO, @PathVariable(name = "id") Long id)
    {
        CountryDTO countryRequest = countryService.updateCountry(countryDTO, id);
        
        return new ResponseEntity<>(countryRequest, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable(name = "id") Long id)
    {
        countryService.deleteCountry(id);
        
        return new ResponseEntity<>("Pais eliminado", HttpStatus.OK);
    }
}
