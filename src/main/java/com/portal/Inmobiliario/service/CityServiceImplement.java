/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.exceptions.NotFoundException;
import com.portal.Inmobiliario.mapper.ICityMapper;
import com.portal.Inmobiliario.model.dto.City.CityResponse;
import com.portal.Inmobiliario.model.dto.City.CreateCityRequest;
import com.portal.Inmobiliario.model.entity.City;
import com.portal.Inmobiliario.repository.ICityRepository;
import com.portal.Inmobiliario.repository.IProvinceRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CityServiceImplement implements ICityService
{
    private final IProvinceRepository provinceRepository;
    private final ICityRepository cityRepository;
    private final ICityMapper cityMapper;
    
    @Override
    public CityResponse findById(Long id) 
    {
        return cityRepository.findById(id)
            .map(cityMapper::toCityResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<CityResponse> findAll() 
    {
        return cityRepository.findAll()
            .stream()
            .map(cityMapper::toCityResponse)
            .collect(Collectors.toList());
    }

    @Override
    public List<CityResponse> findByProvinceId(Long provinceId) 
    {
        return (List<CityResponse>) provinceRepository.findById(provinceId)
            .map(province -> cityRepository.findAllByProvince(province))
            .map(city -> city.stream()
                .map(cityMapper::toCityResponse)
                .collect(Collectors.toList()))
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public CityResponse save(CreateCityRequest request) 
    {
        return provinceRepository.findById(request.getIdProvince())
            .map(province ->{
                City city = new City();
                city.setCity(request.getCity());
                city.setProvince(province);
                return cityRepository.save(city);   
            })
            .map(cityMapper::toCityResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public CityResponse update(Long id, CreateCityRequest request) 
    {
        return cityRepository.findById(id)
            .map(city -> provinceRepository
            .findById(request.getIdProvince())
            .map(province ->{
                city.setCity(request.getCity());
                city.setProvince(province);
                return cityRepository.save(city);
            })
        .orElseThrow(NotFoundException::new))
        .map(cityMapper::toCityResponse)
        .orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(Long id) 
    {
        if(cityRepository.findById(id).isEmpty())
        {
            throw new NotFoundException();
        }
        cityRepository.deleteById(id);
    }

}
