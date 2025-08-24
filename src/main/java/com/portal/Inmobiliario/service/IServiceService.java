/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.model.dto.Service.CreateServiceRequest;
import com.portal.Inmobiliario.model.dto.Service.ServiceResponse;
import java.util.List;


public interface IServiceService 
{
    ServiceResponse findById(Long id);
    List<ServiceResponse> findAll();
    ServiceResponse save(CreateServiceRequest request);
    ServiceResponse update(Long id, CreateServiceRequest request);
    void deleteById(Long id);
}
