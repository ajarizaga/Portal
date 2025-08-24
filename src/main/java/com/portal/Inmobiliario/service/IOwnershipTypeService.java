/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.model.dto.OwnershipType.CreateOwnershipTypeRequest;
import com.portal.Inmobiliario.model.dto.OwnershipType.OwnershipTypeResponse;
import java.util.List;


public interface IOwnershipTypeService
{
    OwnershipTypeResponse findById(Long id);
    List<OwnershipTypeResponse> findAll();
    OwnershipTypeResponse save(CreateOwnershipTypeRequest request);
    OwnershipTypeResponse update(Long id, CreateOwnershipTypeRequest request);
    void deleteById(Long id);
}
