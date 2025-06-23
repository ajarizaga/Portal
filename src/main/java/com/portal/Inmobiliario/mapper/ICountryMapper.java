/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.mapper;

import com.portal.Inmobiliario.model.dto.Country.CountryResponse;
import com.portal.Inmobiliario.model.entity.Country;
import org.mapstruct.Mapper;

/**
 *
 * @author Gamer
 */
@Mapper(componentModel = "spring")
public interface ICountryMapper 
{
    CountryResponse toCountryResponse(Country country);
}
