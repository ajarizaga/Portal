/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.model.dto.City.CityResponse;
import com.portal.Inmobiliario.model.dto.City.CreateCityRequest;
import java.util.List;


public interface ICityService 
{
    CityResponse findById(Long id);
    List<CityResponse> findAll();
    List<CityResponse> findByProvinceId(Long provinceId);
    CityResponse save(CreateCityRequest request);
    CityResponse update (Long id, CreateCityRequest request);
    void deleteById(Long id);
}
