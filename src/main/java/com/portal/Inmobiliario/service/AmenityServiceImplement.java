/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.exceptions.NotFoundException;
import com.portal.Inmobiliario.mapper.IAmenityMapper;
import com.portal.Inmobiliario.model.dto.Amenity.AmenityResponse;
import com.portal.Inmobiliario.model.dto.Amenity.CreateAmenityRequest;
import com.portal.Inmobiliario.model.entity.Amenity;
import com.portal.Inmobiliario.repository.IAmenityRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AmenityServiceImplement implements IAmenityService
{
    private final IAmenityRepository amenityRepository;
    private final IAmenityMapper amenityMapper;

    @Override
    public AmenityResponse findById(Long id) 
    {
        return amenityRepository.findById(id)
            .map(amenityMapper::toAmenityResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<AmenityResponse> findAll() 
    {
        return amenityRepository.findAll()
            .stream()
            .map(amenityMapper::toAmenityResponse)
            .collect(Collectors.toList());
    }

    @Override
    public AmenityResponse save(CreateAmenityRequest request) 
    {
        Amenity amenity = new Amenity();
        amenity.setAmenity(request.getAmenity());
        Amenity savedAmenity = amenityRepository.save(amenity);
        return findById(savedAmenity.getId());
        
    }

    @Override
    public AmenityResponse update(Long id, CreateAmenityRequest request) 
    {
        return amenityRepository.findById(id)
            .map(amenity->{
                amenity.setAmenity(request.getAmenity());
                return amenityRepository.save(amenity);
            })
            .map(amenityMapper::toAmenityResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(Long id) 
    {
        if(amenityRepository.findById(id).isEmpty())
        {
            throw new NotFoundException();
        }
        else
        {
            amenityRepository.deleteById(id);
        }
    }
    
    
}
