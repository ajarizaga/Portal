/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.exceptions.NotFoundException;
import com.portal.Inmobiliario.mapper.IOwnershipTypeMapper;
import com.portal.Inmobiliario.model.dto.OwnershipType.CreateOwnershipTypeRequest;
import com.portal.Inmobiliario.model.dto.OwnershipType.OwnershipTypeResponse;
import com.portal.Inmobiliario.model.entity.OwnershipType;
import com.portal.Inmobiliario.repository.IOwnershipTypeRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author garro
 */
@Service
@RequiredArgsConstructor
public class OwnershipServiceImplemant implements IOwnershipTypeService
{
    private final IOwnershipTypeRepository ownershipTypeRepository;
    private final IOwnershipTypeMapper ownershipTypeMapper;

    @Override
    public OwnershipTypeResponse findById(Long id) 
    {
       return ownershipTypeRepository.findById(id)
           .map(ownershipTypeMapper::toOwnershipTypeResponse)
           .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<OwnershipTypeResponse> findAll()
    {
        return ownershipTypeRepository.findAll()
            .stream()
            .map(ownershipTypeMapper::toOwnershipTypeResponse)
            .collect(Collectors.toList());
    }

    @Override
    public OwnershipTypeResponse save(CreateOwnershipTypeRequest request) 
    {
        try 
        {
            OwnershipType ownershipType = new OwnershipType();
            ownershipType.setType(request.getType());
            OwnershipType savedOwnershipType = ownershipTypeRepository.save(ownershipType);
            return ownershipTypeRepository.findById(savedOwnershipType.getId())
                .map(ownershipTypeMapper::toOwnershipTypeResponse)
                .orElseThrow(NotFoundException::new);
        } 
        catch (Exception e) 
        {
            return null;
        }
    }

    @Override
    public OwnershipTypeResponse update(Long id, CreateOwnershipTypeRequest request) 
    {
        return ownershipTypeRepository.findById(id)
            .map(ownershipType ->{
                ownershipType.setType(request.getType());
                return ownershipTypeRepository.save(ownershipType);
            })
            .map(ownershipTypeMapper::toOwnershipTypeResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(Long id) 
    {
        if(ownershipTypeRepository.findById(id).isEmpty())
        {
            throw new NotFoundException();
        }
        else
        {
            ownershipTypeRepository.deleteById(id);
        }
    }
    
}
