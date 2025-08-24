/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.mapper;

import com.portal.Inmobiliario.model.dto.Orientation.OrientationResponse;
import com.portal.Inmobiliario.model.entity.Orientation;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface IOrientationMapper 
{
    OrientationResponse toOrientationResponse(Orientation orientation);
}
