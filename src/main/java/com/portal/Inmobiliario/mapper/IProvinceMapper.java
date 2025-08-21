/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.mapper;

import com.portal.Inmobiliario.model.dto.Province.ProvinceResponse;
import com.portal.Inmobiliario.model.entity.Province;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = ICountryMapper.class)
public interface IProvinceMapper 
{
    ProvinceResponse toProvinceResponse(Province province);
}
