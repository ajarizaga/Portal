/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.exceptions.NotFoundException;
import com.portal.Inmobiliario.mapper.INeighborhoodMapper;
import com.portal.Inmobiliario.model.dto.Nieghborhood.CreateNeighborhoodRequest;
import com.portal.Inmobiliario.model.dto.Nieghborhood.NeighborhoodResponse;
import com.portal.Inmobiliario.model.entity.Neighborhood;
import com.portal.Inmobiliario.repository.ICityRepository;
import com.portal.Inmobiliario.repository.INeighborhoodRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class NeighborhoodServiceImplement implements INeighborhoodService
{
    private final INeighborhoodRepository neighborhoodRepository;
    private final ICityRepository cityRepository;
    private final INeighborhoodMapper neighborhoodMapper;
    
    @Override
    public NeighborhoodResponse findById(Long id) 
    {
        return neighborhoodRepository.findById(id)
            .map(neighborhoodMapper::toNeighborhoodResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<NeighborhoodResponse> findAll() 
    {
        return neighborhoodRepository.findAll()
            .stream()
            .map(neighborhoodMapper::toNeighborhoodResponse)
            .collect(Collectors.toList());
    }

    @Override
    public List<NeighborhoodResponse> findByCityId(Long id) 
    {
        return cityRepository.findById(id)
            .map(city -> neighborhoodRepository.findAllByCity(city))
                .map(neighborhood -> neighborhood.stream()
                .map(neighborhoodMapper::toNeighborhoodResponse)
                .collect(Collectors.toList()))
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public NeighborhoodResponse save(CreateNeighborhoodRequest request) 
    {
        return cityRepository.findById(request.getIdCity())
            .map(city ->{
                Neighborhood neighborhood = new Neighborhood();
                neighborhood.setNeighborhood(request.getNeighborhood());
                neighborhood.setCity(city);
                return neighborhoodRepository.save(neighborhood);
            })
            .map(neighborhoodMapper::toNeighborhoodResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public NeighborhoodResponse update(Long id, CreateNeighborhoodRequest request) 
    {
        return neighborhoodRepository.findById(id)
            .map(neighborhood -> cityRepository
                .findById(request.getIdCity())
                .map(city ->{
                    neighborhood.setNeighborhood(request.getNeighborhood());
                    neighborhood.setCity(city);
                    return neighborhoodRepository.save(neighborhood);
                })
            .orElseThrow(NotFoundException::new))
            .map(neighborhoodMapper::toNeighborhoodResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(Long id) 
    {
        if(neighborhoodRepository.findById(id).isEmpty())
        {
            throw new NotFoundException();
        }
        neighborhoodRepository.deleteById(id);
    }
    
}
