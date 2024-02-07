/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliairo.controller;

import com.portal.Inmobiliairo.dto.CountryDTO;
import com.portal.Inmobiliairo.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
