/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.controller;

import com.portal.Inmobiliario.model.dto.Nieghborhood.CreateNeighborhoodRequest;
import com.portal.Inmobiliario.model.dto.Nieghborhood.NeighborhoodResponse;
import com.portal.Inmobiliario.service.INeighborhoodService;
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
@RequestMapping("/api/neighborhoods")
public class NeighborhoodController 
{
    private final INeighborhoodService neighborhoodService;
    
    @GetMapping
    public List<NeighborhoodResponse> findAll()
    {
        return neighborhoodService.findAll();
    }       
    
    @GetMapping("/{id}")
    public NeighborhoodResponse findById(@PathVariable Long id)
    {
        return neighborhoodService.findById(id);
    }
    
    @GetMapping("/city/{id}")
    public List<NeighborhoodResponse> findAllByCityId(@PathVariable Long id)
    {
        return neighborhoodService.findByCityId(id);
    }
    
    @PostMapping
    public ResponseEntity<NeighborhoodResponse> save(@Valid @RequestBody CreateNeighborhoodRequest request)
    {
        NeighborhoodResponse response = neighborhoodService.save(request);
        return ResponseEntity.created(URI.create("/api/neighborhoods/" +response.getId())).body(response);
    }
    
    @PutMapping("/{id}")
    public NeighborhoodResponse update(@PathVariable Long id, @RequestBody CreateNeighborhoodRequest request)
    {
        return neighborhoodService.update(id, request);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id)
    {
        neighborhoodService.deleteById(id);
    }
    
}
