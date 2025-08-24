/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.mapper.IAmenityMapper;
import com.portal.Inmobiliario.model.dto.Amenity.AmenityResponse;
import com.portal.Inmobiliario.model.dto.Amenity.CreateAmenityRequest;
import com.portal.Inmobiliario.repository.IAmenityRepository;
import java.util.List;

public interface IAmenityService 
{
    AmenityResponse findById(Long id);
    List<AmenityResponse> findAll();
    AmenityResponse save(CreateAmenityRequest request);
    AmenityResponse update(Long id, CreateAmenityRequest request);
    void deleteById(Long id);
}
