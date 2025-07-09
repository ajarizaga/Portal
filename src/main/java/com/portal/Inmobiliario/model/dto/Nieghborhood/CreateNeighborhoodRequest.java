/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.model.dto.Nieghborhood;

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
public class CreateNeighborhoodRequest 
{
    @NotNull(message = "El barrio no puede ser nulo")
    @NotEmpty(message = "El barrio no puede estar vacio")
    private String neighborhood;
}
