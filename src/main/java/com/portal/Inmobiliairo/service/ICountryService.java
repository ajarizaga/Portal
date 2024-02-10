/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliairo.service;

import com.portal.Inmobiliairo.dto.CountryDTO;
import java.util.List;

/**
 *
 * @author Gamer
 */
public interface ICountryService 
{
    public CountryDTO createCountry(CountryDTO countryDTO);
    
    public List<CountryDTO> getAllCountries();
    
    public CountryDTO getCountryById(Long id);
    
    public CountryDTO updateCountry(CountryDTO countryDTO, Long id);
    
    public void deleteCountry(Long id);
    
}
