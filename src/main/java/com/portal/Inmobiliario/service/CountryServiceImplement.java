/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.exceptions.CountryNotFoundException;
import com.portal.Inmobiliario.mapper.ICountryMapper;
import com.portal.Inmobiliario.model.dto.Country.CountryResponse;
import com.portal.Inmobiliario.model.dto.Country.CreateCountryRequest;
import com.portal.Inmobiliario.model.entity.Country;
import com.portal.Inmobiliario.repository.ICountryRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CountryServiceImplement implements ICountryService
{
    private final ICountryRepository countryRepository;
    private final ICountryMapper countryMapper;
    
    @Override
    public CountryResponse findById(Long id) 
    {
        return countryRepository.findById(id)
            .map(countryMapper::toCountryResponse)
            .orElseThrow(CountryNotFoundException::new);
    }

    @Override
    public List<CountryResponse> findAll() 
    {
        return countryRepository.findAll()
            .stream()
            .map(countryMapper::toCountryResponse)
            .collect(Collectors.toList());
    }

    @Override
    public CountryResponse save(CreateCountryRequest request) 
    {
        try
        {
            Country country = new Country();
            country.setCountry(request.getCountry());
            Country savedCountry = countryRepository.save(country);
            return findById(savedCountry.getId());
        }
        catch(Exception e)
        {
            return null;
        }        
    }

    @Override
    public CountryResponse update(Long id, CreateCountryRequest request) 
    {
        return countryRepository.findById(id)
            .map(country ->{
                country.setCountry(request.getCountry());
                return countryRepository.save(country);
            })
            .map(countryMapper::toCountryResponse)
            .orElseThrow(CountryNotFoundException::new);
    }
    
    @Override
    public void deleteById(Long id) 
    {
        if(countryRepository.findById(id).isEmpty())
        {
            throw new CountryNotFoundException();
        }
        else
            countryRepository.deleteById(id);
  
    }
    
}