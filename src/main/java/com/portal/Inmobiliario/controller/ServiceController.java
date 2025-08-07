/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.controller;

import com.portal.Inmobiliario.model.dto.Service.CreateServiceRequest;
import com.portal.Inmobiliario.model.dto.Service.ServiceResponse;
import com.portal.Inmobiliario.service.IServiceService;
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
@RequestMapping("/api/services")
public class ServiceController 
{
    private final IServiceService serviceService;
    
    @GetMapping
    private List<ServiceResponse> findAll()
    {
        return serviceService.findAll();
    }
    
    @GetMapping("/{id}")
    private ServiceResponse findById(@PathVariable Long id)
    {
        return serviceService.findById(id);
    }
    
    @PostMapping
    private ResponseEntity<ServiceResponse> save(@Valid @RequestBody CreateServiceRequest request)
    {
        ServiceResponse response = serviceService.save(request);
        return ResponseEntity.created(URI.create("api/services/" + response.getId())).body(response);
    }
    
    @PutMapping("/{id}")
    private ServiceResponse update(@PathVariable Long id, @Valid @RequestBody CreateServiceRequest request)
    {
        return serviceService.update(id, request);
    }
    
    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable Long id)
    {
        serviceService.deleteById(id);
    }
}
