/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.model.dto.Province;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.portal.Inmobiliario.model.entity.Country;
import lombok.Builder;
import lombok.Getter;

/**
 *
 * @author Gamer
 */
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProvinceResponse 
{
    private Long id;
    private String province;
    private Country country;    
}
