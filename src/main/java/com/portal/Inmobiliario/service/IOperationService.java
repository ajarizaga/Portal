/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.model.dto.Operation.CreateOperationRequest;
import com.portal.Inmobiliario.model.dto.Operation.OperationResponse;
import java.util.List;


public interface IOperationService 
{
    OperationResponse findById(Long id);
    List<OperationResponse> findAll();
    OperationResponse save(CreateOperationRequest request);
    OperationResponse update(Long id, CreateOperationRequest request);
    void deleteById(Long id);
}
