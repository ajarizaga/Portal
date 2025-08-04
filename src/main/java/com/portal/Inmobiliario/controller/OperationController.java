/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.controller;

import com.portal.Inmobiliario.model.dto.Operation.CreateOperationRequest;
import com.portal.Inmobiliario.model.dto.Operation.OperationResponse;
import com.portal.Inmobiliario.service.IOperationService;
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
@RequestMapping("/api/operations")
public class OperationController 
{
    private final IOperationService operationService;
    
    @GetMapping
    private List<OperationResponse> findAll()
    {
        return operationService.findAll();
    }
    
    @GetMapping("/{id}")
    private OperationResponse findById(@PathVariable Long id)
    {
        return operationService.findById(id);
    }
    
    @PostMapping
    private ResponseEntity<OperationResponse> save(@Valid @RequestBody CreateOperationRequest request)
    {
       OperationResponse response = operationService.save(request);
       return ResponseEntity.created(URI.create("api/operations/" + response.getId())).body(response);
    }
    
    @PutMapping("/{id}")
    private OperationResponse update(@PathVariable Long id, @Valid @RequestBody CreateOperationRequest request)
    {
        return operationService.update(id, request);
    }
    
    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable Long id)
    {
        operationService.deleteById(id);
    }
}
