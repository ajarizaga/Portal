/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.model.dto.Country.CountryResponse;
import com.portal.Inmobiliario.model.dto.Country.CreateCountryRequest;
import java.util.List;

/**
 *
 * @author Gamer
 */
public interface ICountryService 
{
    CountryResponse findById(Long id);
    List<CountryResponse> findAll();
    CountryResponse save(CreateCountryRequest request);
    CountryResponse update(Long id, CreateCountryRequest request);
    void deleteById(Long id);
}
