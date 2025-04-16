/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliairo.model.dto.Orientation;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

/**
 *
 * @author Gamer
 */
@Getter
@Builder
public class CreateOrientationRequest 
{
    @NotEmpty(message = "Campo obligatorio")
    @NotNull(message = "Campo obligatorio")
    private String orientation;
}
