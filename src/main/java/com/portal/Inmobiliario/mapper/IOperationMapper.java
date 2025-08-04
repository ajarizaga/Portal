/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.mapper;

import com.portal.Inmobiliario.model.dto.Operation.OperationResponse;
import com.portal.Inmobiliario.model.entity.Operation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IOperationMapper 
{
    OperationResponse toOperationResponse(Operation operation);
}
