/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.exceptions.NotFoundException;
import com.portal.Inmobiliario.mapper.IDeedDetailMapper;
import com.portal.Inmobiliario.model.dto.DeedDetails.CreateDeedDetailRequest;
import com.portal.Inmobiliario.model.dto.DeedDetails.DeedDetailResponse;
import com.portal.Inmobiliario.model.entity.DeedDetail;
import com.portal.Inmobiliario.repository.IDeedDetailRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeedDetailImplement implements IDeedDetailService
{
    private final IDeedDetailMapper deedDetailMapper;
    private final IDeedDetailRepository deedDetailRepository;

    @Override
    public DeedDetailResponse findById(Long id) 
    {
        return deedDetailRepository.findById(id)
            .map(deedDetailMapper::toDeedDetailResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<DeedDetailResponse> findAll() 
    {
        return deedDetailRepository.findAll()
            .stream()
            .map(deedDetailMapper::toDeedDetailResponse)
            .collect(Collectors.toList());
    }

    @Override
    public DeedDetailResponse save(CreateDeedDetailRequest request) 
    {
        DeedDetail deedDetail = new DeedDetail();
        deedDetail.setDetail(request.getDetail());
        DeedDetail savedDeedDetail = deedDetailRepository.save(deedDetail);
        return findById(savedDeedDetail.getId());
    }

    @Override
    public DeedDetailResponse update(Long id, CreateDeedDetailRequest request) 
    {
        return deedDetailRepository.findById(id)
            .map(deedDetail->{
                deedDetail.setDetail(request.getDetail());
                return deedDetailRepository.save(deedDetail);
            })
            .map(deedDetailMapper::toDeedDetailResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(Long id) 
    {
        if(deedDetailRepository.findById(id).isEmpty())
        {
            throw new NotFoundException();
        }
        else
        {
            deedDetailRepository.deleteById(id);
        }
    }
    
}
