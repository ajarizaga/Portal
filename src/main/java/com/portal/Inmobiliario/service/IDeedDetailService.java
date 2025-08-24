/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.model.dto.DeedDetails.CreateDeedDetailRequest;
import com.portal.Inmobiliario.model.dto.DeedDetails.DeedDetailResponse;
import java.util.List;


public interface IDeedDetailService 
{
    DeedDetailResponse findById(Long id);
    List<DeedDetailResponse> findAll();
    DeedDetailResponse save(CreateDeedDetailRequest request);
    DeedDetailResponse update(Long id, CreateDeedDetailRequest request);
    void deleteById(Long id);
}
