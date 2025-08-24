/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.model.dto.Orientation.CreateOrientationRequest;
import com.portal.Inmobiliario.model.dto.Orientation.OrientationResponse;
import java.util.List;


public interface IOrientationService 
{
    OrientationResponse findbyId(Long id);
    List<OrientationResponse> findAll();
    OrientationResponse save(CreateOrientationRequest request);
    OrientationResponse update(Long id, CreateOrientationRequest request);
    void deleteByid(Long id);
}
