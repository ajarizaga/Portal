/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.model.dto.Ownership;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.portal.Inmobiliario.model.dto.Amenity.AmenityResponse;
import com.portal.Inmobiliario.model.dto.Characteristic.CharacteristicResponse;
import com.portal.Inmobiliario.model.dto.Service.ServiceResponse;
import com.portal.Inmobiliario.model.entity.Amenity;
import com.portal.Inmobiliario.model.entity.Currency;
import com.portal.Inmobiliario.model.entity.Neighborhood;
import com.portal.Inmobiliario.model.entity.Orientation;
import com.portal.Inmobiliario.model.entity.OwnershipType;
import com.portal.Inmobiliario.model.entity.Services;
import com.portal.Inmobiliario.model.entity.Characteristic;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OwnershipResponse 
{
    private Long id;
    private Integer rooms;
    private Integer bedrooms;
    private Integer bathrooms;
    private boolean garage;
    private Integer yearOfConstruction;
    private boolean plans;
    private String totalMeters;
    private String builtMeters;
    private BigInteger price;
    private Integer expenses;
    private Date publicateionDate;
    //private Boolean deed;//se va a caracteristicas
    //private String deedDetails; 
    private String writingDesk;
    private Boolean gasWorkADay;
    
    //1:M
    private Neighborhood neigborhood;
    private Currency currency;
    private Orientation orientation;
    private OwnershipType ownershipType;
    
    //M:M
    private Set<ServiceResponse> services;
    private Set<AmenityResponse> amenities;
    private Set<CharacteristicResponse> characteristic;
}
