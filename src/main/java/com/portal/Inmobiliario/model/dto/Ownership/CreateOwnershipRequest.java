/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.model.dto.Ownership;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOwnershipRequest 
{
    @NotEmpty(message = "El campo no puede estar vacio")
    @NotNull(message = "Campo obligatorio")
    private Integer rooms;
    
    @NotEmpty(message = "El campo no puede estar vacio")
    @NotNull(message = "Campo obligatorio")
    private Integer bedrooms;
    
    @NotEmpty(message = "El campo no puede estar vacio")
    @NotNull(message = "Campo obligatorio")
    private Integer bathrooms;
    
    @NotEmpty(message = "El campo no puede estar vacio")
    @NotNull(message = "Campo obligatorio")
    private BigInteger price;
    
    private boolean garage;
    private Integer yearOfConstruction;
    private boolean plans;
    private String totalMeters;
    private String builtMeters;
    private Integer expenses;
    private Date publicateionDate;
    //private Boolean deed;//se va a caracteristicas
    //private String deedDetails; 
    private String writingDesk;
    private Boolean gasWorkADay;
    
    //1:M
    private Long idNeigborhood;
    private Long idCurrency;
    private Long idOrientation;
    private Long idOwnershipType;
    
    //M:M
    private Set<Long> IdsServices;
    private Set<Long> IdsAmenities;
    private Set<Long> IdsCharacteristic;
}
