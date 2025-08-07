/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.exceptions.NotFoundException;
import com.portal.Inmobiliario.mapper.IServiceMapper;
import com.portal.Inmobiliario.model.dto.Service.CreateServiceRequest;
import com.portal.Inmobiliario.model.dto.Service.ServiceResponse;
import com.portal.Inmobiliario.model.entity.Services;
import com.portal.Inmobiliario.repository.IServiceRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceServiceImplement implements IServiceService
{
    private final IServiceMapper serviceMapper;
    private final IServiceRepository serviceRepository;

    @Override
    public ServiceResponse findById(Long id) 
    {
        return serviceRepository.findById(id)
            .map(serviceMapper::toServiceResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<ServiceResponse> findAll() 
    {
        return serviceRepository.findAll()
            .stream()
            .map(serviceMapper::toServiceResponse)
            .collect(Collectors.toList());
    }

    @Override
    public ServiceResponse save(CreateServiceRequest request) 
    {
        Services service = new Services();
        service.setService(request.getService());
        Services savedService =serviceRepository.save(service);
        return findById(savedService.getId());
    }

    @Override
    public ServiceResponse update(Long id, CreateServiceRequest request) 
    {
        return serviceRepository.findById(id)
            .map(service->{
            service.setService(request.getService());
            return serviceRepository.save(service);
            })
            .map(serviceMapper::toServiceResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(Long id) 
    {
        if(serviceRepository.findById(id).isEmpty())
        {
            throw new NotFoundException();
        }
        else
        {
            serviceRepository.deleteById(id);
        }
    }
    
}
