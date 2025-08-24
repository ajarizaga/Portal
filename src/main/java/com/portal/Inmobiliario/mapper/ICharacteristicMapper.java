/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.mapper;

import com.portal.Inmobiliario.model.dto.Characteristic.CharacteristicResponse;
import com.portal.Inmobiliario.model.entity.Characteristic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICharacteristicMapper 
{
    CharacteristicResponse toCharacteristicResponse(Characteristic characteristic);
}
