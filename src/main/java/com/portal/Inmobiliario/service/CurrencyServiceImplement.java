/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.exceptions.NotFoundException;
import com.portal.Inmobiliario.mapper.ICurrencyMapper;
import com.portal.Inmobiliario.model.dto.Currency.CreateCurrencyRequest;
import com.portal.Inmobiliario.model.dto.Currency.CurrencyResponse;
import com.portal.Inmobiliario.model.entity.Currency;
import com.portal.Inmobiliario.repository.ICurrencyRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author garro
 */
@Service
@RequiredArgsConstructor
public class CurrencyServiceImplement implements ICurrencyService
{
    private final ICurrencyRepository currencyRepository;
    private final ICurrencyMapper currencyMapper;

    @Override
    public CurrencyResponse findById(Long id) 
    {
        return currencyRepository.findById(id)
            .map(currencyMapper::toCurrencyResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<CurrencyResponse> findAll() 
    {
        return currencyRepository.findAll()
            .stream()
            .map(currencyMapper::toCurrencyResponse)
            .collect(Collectors.toList());
    }

    @Override
    public CurrencyResponse save(CreateCurrencyRequest request) 
    {
        Currency currency = new Currency();
        currency.setCurrency(request.getCurrency());
        currency.setSymbol(request.getSymbol());
        Currency savedurrency = currencyRepository.save(currency);
        return currencyRepository.findById(savedurrency.getId())
            .map(currencyMapper::toCurrencyResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public CurrencyResponse update(Long id, CreateCurrencyRequest request) 
    {
        return currencyRepository.findById(id)
            .map(currency ->{
                currency.setCurrency(request.getCurrency());
                currency.setSymbol(request.getSymbol());
                return currencyRepository.save(currency);
            })
            .map(currencyMapper::toCurrencyResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(Long id) 
    {
        if (currencyRepository.findById(id).isEmpty())
        {
            throw new NotFoundException();
        }
        else
        {
            currencyRepository.deleteById(id);
        }
    }
    
}
