/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.model.dto.Currency.CreateCurrencyRequest;
import com.portal.Inmobiliario.model.dto.Currency.CurrencyResponse;
import java.util.List;


public interface ICurrencyService 
{
    CurrencyResponse findById(Long id);
    List<CurrencyResponse> findAll();
    CurrencyResponse save(CreateCurrencyRequest request);
    CurrencyResponse update(Long id, CreateCurrencyRequest request);
    void deleteById(Long id);
}
