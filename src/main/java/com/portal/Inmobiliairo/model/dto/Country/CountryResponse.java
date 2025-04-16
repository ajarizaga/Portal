/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliairo.model.dto.Country;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

/**
 *
 * @author Gamer
 */
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryResponse 
{
    private Long id;
    private String nombre;
}
