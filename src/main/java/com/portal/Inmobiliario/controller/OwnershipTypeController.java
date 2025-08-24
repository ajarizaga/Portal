/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.controller;

import com.portal.Inmobiliario.model.dto.OwnershipType.CreateOwnershipTypeRequest;
import com.portal.Inmobiliario.model.dto.OwnershipType.OwnershipTypeResponse;
import com.portal.Inmobiliario.service.IOwnershipTypeService;
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
@RequestMapping("/api/ownershiptypes")
public class OwnershipTypeController 
{
    private final IOwnershipTypeService ownershipTypeService;
    
    @GetMapping
    public List<OwnershipTypeResponse> findAll()
    {
        return ownershipTypeService.findAll();
    }
    
    @GetMapping("/{id}")
    public OwnershipTypeResponse findById(@PathVariable Long id)
    {
        return ownershipTypeService.findById(id);
    }
    
    @PostMapping
    public ResponseEntity<OwnershipTypeResponse> save(@Valid @RequestBody CreateOwnershipTypeRequest request)
    {
        OwnershipTypeResponse response = ownershipTypeService.save(request);
        return ResponseEntity.created(URI.create("(api/ownershipTypes/" + response.getId())).body(response);
    }
    
    @PutMapping("/{id}")
    public OwnershipTypeResponse update (@PathVariable Long id, @Valid @RequestBody CreateOwnershipTypeRequest request)
    {
        return ownershipTypeService.update(id, request);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id)
    {
        ownershipTypeService.deleteById(id);
    }
}
