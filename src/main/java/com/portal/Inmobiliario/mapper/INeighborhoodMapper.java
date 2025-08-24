/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.mapper;

import com.portal.Inmobiliario.model.dto.Nieghborhood.NeighborhoodResponse;
import com.portal.Inmobiliario.model.entity.Neighborhood;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface INeighborhoodMapper 
{
    NeighborhoodResponse toNeighborhoodResponse(Neighborhood neighborhood);
}
