/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliairo.service;

import com.portal.Inmobiliairo.dto.CountryDTO;
import com.portal.Inmobiliairo.model.Country;
import com.portal.Inmobiliairo.repository.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gamer
 */
@Service
public class CountryServiceImpl implements ICountryService{

    @Autowired
    private ICountryRepository ICountryRepository;
            
    @Override
    public CountryDTO createCountry(CountryDTO countryDTO)
    {
        //DTO a entidad
        Country country = new Country();
        country.setCountry(countryDTO.getCountry());
        
        Country newCountry =ICountryRepository.save(country);
        
        //entidad a DTO
        CountryDTO countryRequest = new CountryDTO();
        countryRequest.setCountry(country.getCountry());
        
        return countryRequest;
    }
    
}
