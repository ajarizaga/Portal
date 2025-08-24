/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.controller;

import com.portal.Inmobiliario.model.dto.Province.CreateProvinceRequest;
import com.portal.Inmobiliario.model.dto.Province.ProvinceResponse;
import com.portal.Inmobiliario.service.IProvinceService;
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


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/provinces")
public class ProvinceController 
{
    private final IProvinceService provinceService;
    
    @GetMapping
    public List<ProvinceResponse> findAll()
    {
        return provinceService.findAll();
    }
    
    @GetMapping("/{id}")
    public ProvinceResponse findById(@PathVariable Long id)
    {
        return provinceService.findById(id);
    }
    
    @GetMapping("/country/{id}")
    public List<ProvinceResponse> findAllByCountryId(@PathVariable Long id)
    {
        return provinceService.findAllByCountryId(id);
    }
    
    @PostMapping
    public ResponseEntity<ProvinceResponse> save(@Valid @RequestBody CreateProvinceRequest request)
    {      
        ProvinceResponse response = provinceService.save(request);
        return ResponseEntity.created(URI.create("/api/provinces/" + response.getId())).body(response);   
    }
    
    @PutMapping("/{id}")
    public ProvinceResponse update(@PathVariable Long id, @Valid @RequestBody CreateProvinceRequest request)
    {
        return provinceService.update(id, request);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id)
    {
        provinceService.deletebyId(id);
    }
}
