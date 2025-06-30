/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.exceptions.NotFoundException;
import com.portal.Inmobiliario.mapper.IOrientationMapper;
import com.portal.Inmobiliario.model.dto.Orientation.CreateOrientationRequest;
import com.portal.Inmobiliario.model.dto.Orientation.OrientationResponse;
import com.portal.Inmobiliario.model.entity.Orientation;
import com.portal.Inmobiliario.repository.IOrientationRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gamer
 */
@Service
@RequiredArgsConstructor
public class OrientationServiceImplement implements IOrientationService
{
    private final IOrientationRepository orientationRepository;
    private final IOrientationMapper orientationMapper;

    @Override
    public OrientationResponse findbyId(Long id) 
    {
        return orientationRepository.findById(id)
            .map(orientationMapper::toOrientationResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<OrientationResponse> findAll() 
    {
        return orientationRepository.findAll()
            .stream()
            .map(orientationMapper::toOrientationResponse)
            .collect(Collectors.toList());
    }

    @Override
    public OrientationResponse save(CreateOrientationRequest request) 
    {
        Orientation orientation = new Orientation();
        orientation.setOrientation(request.getOrientation());
        Orientation savedOrientation = orientationRepository.save(orientation);
        return orientationRepository.findById(savedOrientation.getId())
            .map(orientationMapper::toOrientationResponse)
            .orElseThrow(NotFoundException::new);
        
    }

    @Override
    public OrientationResponse update(Long id, CreateOrientationRequest request)
    {
        return orientationRepository.findById(id)
            .map(orientation->{
                orientation.setOrientation(request.getOrientation());
                return orientationRepository.save(orientation);
            })
            .map(orientationMapper::toOrientationResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteByid(Long id) 
    {
        if(orientationRepository.findById(id).isEmpty())
        {
            throw new NotFoundException();
        }
        else
            orientationRepository.deleteById(id);
    }
    
}
