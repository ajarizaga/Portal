/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.exceptions.CountryNotFoundException;
import com.portal.Inmobiliario.exceptions.ProvinceNotFoundException;
import com.portal.Inmobiliario.mapper.IProvinceMapper;
import com.portal.Inmobiliario.model.dto.Province.CreateProvinceRequest;
import com.portal.Inmobiliario.model.dto.Province.ProvinceResponse;
import com.portal.Inmobiliario.model.entity.Province;
import com.portal.Inmobiliario.repository.ICountryRepository;
import com.portal.Inmobiliario.repository.IProvinceRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProvinceServiceImplement implements IProvinceService
{

    private final ICountryRepository countryRepository;
    private final IProvinceRepository provinceRepository;
    private final IProvinceMapper provinceMapper;
    
    @Override
    public ProvinceResponse findById(Long id) 
    {
        return provinceRepository.findById(id)
            .map(provinceMapper::toProvinceResponse)
            .orElseThrow(ProvinceNotFoundException::new);
    }

    @Override
    public List<ProvinceResponse> findAll() 
    {
        return provinceRepository.findAll()
            .stream()
            .map(provinceMapper::toProvinceResponse)
            .collect(Collectors.toList());
    }

    @Override
    public List<ProvinceResponse> findAllByCountryId(Long countryId) 
    {
        return (List<ProvinceResponse>) countryRepository.findById(countryId)
            .map(country -> provinceRepository.findAllByCountry(country))
            .map(province ->province.stream()
                .map(provinceMapper::toProvinceResponse)
                .collect(Collectors.toList()))
            .orElseThrow(CountryNotFoundException::new);
    }
    
    @Override
    public ProvinceResponse save(CreateProvinceRequest request) 
    {    
        return countryRepository.findById(request.getIdCountry())
            .map(country ->{
                Province province = new Province();
                province.setProvince(request.getProvince());
                province.setCountry(country);
                return provinceRepository.save(province);
            })
            .map(provinceMapper::toProvinceResponse)
            .orElseThrow(CountryNotFoundException::new);
    }

    @Override
    public ProvinceResponse update(Long id, CreateProvinceRequest request) 
    {
        return provinceRepository.findById(id)
            .map(province -> countryRepository
                .findById(request.getIdCountry())
                .map(country -> {
                    province.setProvince(request.getProvince());
                    province.setCountry(country);
                    return provinceRepository.save(province);
                })
                .orElseThrow(CountryNotFoundException::new))
            .map(provinceMapper::toProvinceResponse)
            .orElseThrow(ProvinceNotFoundException::new);
    }

    @Override
    public void deletebyId(Long id) 
    {
        if(provinceRepository.findById(id).isEmpty())
        {
            throw new ProvinceNotFoundException();
        }
        provinceRepository.deleteById(id);
    }

}
