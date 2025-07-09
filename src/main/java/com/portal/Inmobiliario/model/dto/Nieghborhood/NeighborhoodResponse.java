/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.model.dto.Nieghborhood;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

/**
 *
 * @author garro
 */
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NeighborhoodResponse 
{
    private Long id;
    private String neighborhood;
}
