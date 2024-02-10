/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliairo.service;

import com.portal.Inmobiliairo.dto.CountryDTO;
import com.portal.Inmobiliairo.exceptions.ResourceNotFoundException;
import com.portal.Inmobiliairo.model.Country;
import com.portal.Inmobiliairo.repository.ICountryRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gamer
 */
@Service
public class CountryServiceImpl implements ICountryService{

    @Autowired
    private ICountryRepository iCountryRepository;
            
    @Override
    public CountryDTO createCountry(CountryDTO countryDTO)
    {
        Country country = mapEntity(countryDTO);
        
        Country newCountry =iCountryRepository.save(country);
        
        CountryDTO countryRequest = mapDTO(newCountry);
        
        return countryRequest;
    }

    @Override
    public List<CountryDTO> getAllCountries() {
        List<Country> countries = iCountryRepository.findAll();
        return countries.stream().map(country -> mapDTO(country)).collect(Collectors.toList());
    }
    
    //convierte entidad a DTO
    private CountryDTO mapDTO(Country country)
    {
        CountryDTO countryRequest = new CountryDTO();
        
        countryRequest.setId(country.getId());
        countryRequest.setCountry(country.getCountry());
        
        return countryRequest;
    }
    
    //convierte DTO a entidad
    private Country mapEntity(CountryDTO countryDTO)
    {
        Country country = new Country();
        
        country.setId(countryDTO.getId());
        country.setCountry(countryDTO.getCountry());
                
        return country;
    }

    @Override
    public CountryDTO getCountryById(Long id) 
    {
        Country country = iCountryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pais", "id", id));
        return mapDTO(country);
    }

    @Override
    public CountryDTO updateCountry(CountryDTO countryDTO, Long id) {
        Country country= iCountryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("pais", "id", id));
        
        country.setCountry(countryDTO.getCountry());
        
        Country countryUpdated= iCountryRepository.save(country);
        
        return mapDTO(countryUpdated);
    }

    @Override
    public void deleteCountry(Long id)
    {
        Country country = iCountryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("pais", "id", id));
        iCountryRepository.delete(country);
    }

   
}
