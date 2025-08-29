/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.mapper;

import com.portal.Inmobiliario.model.dto.Ownership.OwnershipResponse;
import com.portal.Inmobiliario.model.entity.Ownership;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {INeighborhoodMapper.class, ICurrencyMapper.class, IOrientationMapper.class, IOwnershipTypeMapper.class, IServiceMapper.class, IAmenityMapper.class, ICharacteristicMapper.class})
 
public interface IOwnershipMapper 
{
    OwnershipResponse toOwnershipResponse(Ownership ownership);
}