/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.model.dto.Province.CreateProvinceRequest;
import com.portal.Inmobiliario.model.dto.Province.ProvinceResponse;
import java.util.List;

/**
 *
 * @author Gamer
 */

public interface IProvinceService 
{
    ProvinceResponse findById(Long id);
    List<ProvinceResponse> findAll();
    List<ProvinceResponse>findAllByCountryId(Long countryId);
    ProvinceResponse save(CreateProvinceRequest request);
    ProvinceResponse update(Long id, CreateProvinceRequest request);
    void deletebyId(Long id);
}
