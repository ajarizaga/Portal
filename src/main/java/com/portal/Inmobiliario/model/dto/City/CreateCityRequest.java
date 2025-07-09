/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.model.dto.City;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author garro
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCityRequest 
{
    @NotEmpty(message = "Campo ciudad no puede estar vacio")
    @NotNull(message = "Campo ciudad no puede ser nulo")
    private String city;
    
    private Long idProvince;
}
