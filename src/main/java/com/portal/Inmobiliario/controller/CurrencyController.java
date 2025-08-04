/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.controller;

import com.portal.Inmobiliario.model.dto.Currency.CreateCurrencyRequest;
import com.portal.Inmobiliario.model.dto.Currency.CurrencyResponse;
import com.portal.Inmobiliario.service.ICurrencyService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author garro
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/currencies")
public class CurrencyController 
{
    private final ICurrencyService currencyService;
    
    @GetMapping
    public List<CurrencyResponse> findAll()
    {
        return currencyService.findAll();
    }
    
    @GetMapping("/{id}")
    public CurrencyResponse findById(@PathVariable Long id)
    {
        return currencyService.findById(id);
    }
    
    @PostMapping
    public ResponseEntity<CurrencyResponse> save(@Valid @RequestBody CreateCurrencyRequest request)
    {
        CurrencyResponse response = currencyService.save(request);
        return ResponseEntity.created(URI.create("api/currencies/" + response.getId())).body(response);
    }
    
    @PutMapping("/{id}")
    public CurrencyResponse update(@PathVariable Long id, @RequestBody CreateCurrencyRequest request)
    {
        return currencyService.update(id, request);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id)
    {
        currencyService.deleteById(id);
    }
}
