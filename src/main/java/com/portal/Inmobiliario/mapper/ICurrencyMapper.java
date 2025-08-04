/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.mapper;

import com.portal.Inmobiliario.model.dto.Currency.CurrencyResponse;
import com.portal.Inmobiliario.model.entity.Currency;
import org.mapstruct.Mapper;

/**
 *
 * @author garro
 */
@Mapper(componentModel = "spring")
public interface ICurrencyMapper 
{
    CurrencyResponse toCurrencyResponse(Currency currency);
}
